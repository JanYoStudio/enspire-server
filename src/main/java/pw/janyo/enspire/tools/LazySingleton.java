package pw.janyo.enspire.tools;

/**
 * @author kiva
 */
public abstract class LazySingleton<T> {
    private T sInstance;

    protected abstract T createInstance();

    public T get() {
        if (sInstance == null) {
            synchronized (LazySingleton.class) {
                if (sInstance == null) {
                    sInstance = createInstance();
                    Log.d("Lazy Singleton instance created");
                }
            }
        }
        return sInstance;
    }
}

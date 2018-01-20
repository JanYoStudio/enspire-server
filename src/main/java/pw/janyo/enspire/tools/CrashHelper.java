package pw.janyo.enspire.tools;

/**
 * @author kiva
 * @date 2018/1/21
 */
public class CrashHelper implements Thread.UncaughtExceptionHandler {
    private static final LazySingleton<CrashHelper> sInstance = new LazySingleton<CrashHelper>() {
        @Override
        protected CrashHelper createInstance() {
            return new CrashHelper();
        }
    };

    private CrashHelper() {}

    public static CrashHelper getInstance() {
        return sInstance.get();
    }

    public void initCurrentThread() {
        Thread.currentThread().setUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread t, Throwable e) {
        Log.e("UncaughtException: " + e.getLocalizedMessage());
    }
}

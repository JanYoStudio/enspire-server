package pw.janyo.enspire.exception;

/**
 * @author kiva
 * @date 2018/1/20
 */
public class EnspireDataException extends RuntimeException {
    public EnspireDataException(String message) {
        super(message);
    }

    public EnspireDataException(Throwable cause) {
        super(cause);
    }
}

package tech.acodesiger.exception;

/**
 * Created by zqy on 17-3-20.
 */
public class SeckillCloseException extends RuntimeException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}

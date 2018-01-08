package cn.bpzzr.change.net;

/**
 * Created by Administrator on 2018/1/8.
 * 自定义的异常类
 */

public class MyAbnormalException extends RuntimeException {
    public MyAbnormalException() {
        super();
    }

    public MyAbnormalException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyAbnormalException(Throwable cause) {
        super(cause);
    }

    public MyAbnormalException(String message) {
        super(message);
    }
}

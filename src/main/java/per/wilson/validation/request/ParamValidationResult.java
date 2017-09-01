package per.wilson.validation.request;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/9/1
 */
public class ParamValidationResult {
    private String message;
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package per.wilson.validation.request;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/9/1
 */
public class ResultMsg {
    private Integer code;
    private String msg;
    private Object data;

    public ResultMsg() {
    }

    public ResultMsg(ResultCode resultCode) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
    }

     public ResultMsg(ResultCode resultCode,Object data) {
         this.code = resultCode.code;
         this.msg = resultCode.msg;
         this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

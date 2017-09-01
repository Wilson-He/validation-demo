package per.wilson.validation.request;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/9/1
 */

@ControllerAdvice
@ResponseBody
public class ParamExceptionHandler {
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    public Object MethodArgumentNotValidHandler(HttpServletRequest request,
                                                MethodArgumentNotValidException exception) throws Exception
    {
        //按需重新封装需要返回的错误信息
        List<ParamValidationResult> paramValidationResults = new ArrayList<>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            ParamValidationResult validationResult = new ParamValidationResult();
            validationResult.setMessage(error.getDefaultMessage());
            validationResult.setParam(error.getField());
            paramValidationResults.add(validationResult);
        }
        return new ResultMsg(ResultCode.CODE_401,paramValidationResults);
    }
}

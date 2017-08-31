package per.wilson.validation.annotation;

import per.wilson.validation.constant.WorkerEnum;
import per.wilson.validation.validator.WorkerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/30
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {WorkerValidator.class})
public @interface WorkerAnnotation {
    /**
     * @return the error message template
     */
    String message() default "参数错误";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};

    WorkerEnum target();

    String value() default "Worker";
}

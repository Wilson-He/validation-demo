package per.wilson.validation.annotation;

import per.wilson.validation.validator.CustomValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/29
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = CustomValidator.class)
public @interface SexEnumAnnotation {
    /**
     * @return the error message template
     */
    String message() default "性别参数错误";

    /**
     * @return the groups the constraint belongs to
     */
    Class<?>[] groups() default {};

    /**
     * @return the payload associated to the constraint
     */
    Class<? extends Payload>[] payload() default {};

    Class<?>[] clazz() default {};

    String[] value() default {};
}

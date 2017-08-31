package per.wilson.validation.validator;

import per.wilson.validation.annotation.WorkerAnnotation;
import per.wilson.validation.constant.WorkerEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/30
 */
public class WorkerValidator implements ConstraintValidator<WorkerAnnotation,String> {
    private WorkerEnum allEnum;

    @Override
    public void initialize(WorkerAnnotation constraintAnnotation) {
        allEnum = constraintAnnotation.target();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return allEnum.check(value);
    }
}

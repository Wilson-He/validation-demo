package per.wilson.validation.validator;

import com.google.common.collect.Lists;
import per.wilson.validation.annotation.SexEnumAnnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/29
 */
public class CustomValidator implements ConstraintValidator<SexEnumAnnotation, String> {
    private List<String> list;

    @Override
    public void initialize(SexEnumAnnotation constraintAnnotation) {
        this.list = Lists.newArrayList(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return list.contains(value);
    }
}

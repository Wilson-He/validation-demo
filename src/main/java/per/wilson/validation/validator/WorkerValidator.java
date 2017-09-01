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
    //验证前获取WorkerAnnotation注解中的方法值并根据需要进行初始化
    public void initialize(WorkerAnnotation constraintAnnotation) {
//        String msg = constraintAnnotation.message();
        allEnum = constraintAnnotation.target();
    }

    /**
     *
     * @param value 需要校验的对象，该处验证的类型是字符串，当然也可以自定义
     * @param context 约束验证上下文
     *                disableDefaultConstraintViolation():用于使默认ConstraintViolation失效是的能够设置不同的违反信息或生成一个基于不同属性的
     *                ConstraintViolation
     *                getDefaultConstraintMessageTemplate():获取默认的约束信息模板
     *                buildConstraintViolationWithTemplate(String messageTemplate):新建一个ConstraintViolation与信息模板,需在disableDefaultConstraintViolation()
     *                      后调用
     * @return 校验通过返回true,否则返回false
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        /*if(StringUtils.isEmpty(value)){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("工作者参数不能为null")
//                    .addPropertyNode("status")   该方法用于针对校验类中的属性,如value类型是一个User对象，则为user.status属性添加非空约束,失败信息为工作者参数不能为null
                    .addConstraintViolation();
            return false;
        }*/
        return allEnum.check(value);
    }
}

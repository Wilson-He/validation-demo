package per.wilson.validation.vo;

import io.swagger.annotations.ApiModel;
import per.wilson.validation.annotation.SexEnumAnnotation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/29
 */
@ApiModel
public class PeopleVO {
    @NotNull
    @Pattern(regexp = "AAA|BBB")
    private String name;

    @SexEnumAnnotation
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

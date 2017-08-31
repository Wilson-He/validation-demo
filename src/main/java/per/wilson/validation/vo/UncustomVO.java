package per.wilson.validation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/30
 */
@ApiModel
public class UncustomVO {
    @NotNull(message = "姓名不能为空")
    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @NotNull
    @Pattern(regexp = "FEMALE|MALE")
    @ApiModelProperty(value = "性别", required = true)
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

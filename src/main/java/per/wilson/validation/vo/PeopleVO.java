package per.wilson.validation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import per.wilson.validation.annotation.SexEnumAnnotation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/29
 */
@ApiModel
public class PeopleVO {
    @NotNull(groups = {WorkerVO.class})
    @Pattern(regexp = "AAA|BBB",groups = {WorkerVO.class})
    @ApiModelProperty("姓名")
    private String name;

    @SexEnumAnnotation(value = {"MALE","FEMALE"})
    private String sex;

    @Past
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

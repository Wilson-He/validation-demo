package per.wilson.validation.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import per.wilson.validation.annotation.WorkerAnnotation;
import per.wilson.validation.constant.WorkerEnum;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/30
 */
@ApiModel/*("职员VO")*/
public class WorkerVO {
    @WorkerAnnotation(target = WorkerEnum.STATUS, message = "状态参数错误")
    @ApiModelProperty(value = "状态")
    private String status;

    @WorkerAnnotation(target = WorkerEnum.SEX, message = "性别参数错误")
    @ApiModelProperty(value = "性别",required = true)
    private String sex;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

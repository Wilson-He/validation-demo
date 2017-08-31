package per.wilson.validation.controller;

import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import per.wilson.validation.vo.PeopleVO;
import per.wilson.validation.vo.UncustomVO;
import per.wilson.validation.vo.WorkerVO;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/31
 */
@RequestMapping("/test")
public interface BaseController {
    @PostMapping(value = "/people")
    @ApiOperation("仅混合实体")
    @ApiImplicitParams({@ApiImplicitParam(name = "vo", value = "混合实体", required = true, dataType = "PeopleVO", paramType = "body")})
    String people(@Validated @RequestBody PeopleVO vo);

    @PostMapping("/uncustom")
    @ApiOperation("参数仅自定义Validation实体")
    @ApiImplicitParams({@ApiImplicitParam(name = "vo", value = "测试实体", required = true, dataType = "UncustomVO", paramType = "body")})
    String uncustom(@RequestBody UncustomVO vo);

    @PostMapping("/param/{id}")
    @ApiOperation("参数仅普通类型")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "long", paramType = "path")/*,
            @ApiImplicitParam(name = "vo", value = "职员信息", required = true, dataType = "WorkerVO", paramType = "body")*/})
    String worker(@PathVariable("id") Long id, @ApiParam(name = "vo", value = "职员信息", required = true) @RequestBody WorkerVO vo);
}

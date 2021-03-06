package per.wilson.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.wilson.validation.controller.BaseController;
import per.wilson.validation.vo.PeopleVO;
import per.wilson.validation.vo.UncustomVO;
import per.wilson.validation.vo.WorkerVO;

import javax.validation.Valid;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/29
 */
@SpringBootApplication(scanBasePackages = "per.wilson.validation")
@RestController
public class Application implements BaseController {

    public String people(@Validated @RequestBody PeopleVO vo) {
        return "success";
    }

    @Override
    public String uncustom(@Valid @RequestBody UncustomVO vo) {
        return "success";
    }

    @Override
    public String worker(@PathVariable("id") Long id, @Valid @RequestBody WorkerVO vo) {
        return id + ":" + vo.getSex();
    }

    @Override
    public String name(@RequestParam String name, @RequestBody WorkerVO vo) {
        return name + ":" + vo.getSex();
    }

/* @Override
    public String name(@RequestParam String name, @ApiParam(required = true, name = "vo", value = "职员信息") @RequestBody WorkerVO vo) {
     return name + ":" + vo.getSex();
 }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

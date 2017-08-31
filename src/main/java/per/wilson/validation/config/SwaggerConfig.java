package per.wilson.validation.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人：Wilson
 * 描述：
 * 创建日期：2017/8/29
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static List<ResponseMessage> responseMessageList = new ArrayList<>();

    static {
        responseMessageList.add(new ResponseMessageBuilder().code(500)
                .message("500 - Internal Server Error")
                .responseModel(new ModelRef("Error")).build());
        responseMessageList.add(new ResponseMessageBuilder().code(403)
                .message("403 - Forbidden").build());
        responseMessageList.add(new ResponseMessageBuilder().code(400)
                .message("400 - Param Error").build());
    }


    @Bean
    public Docket validationDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("自定义校验接口文档")
                .apiInfo(apiInfo())
                .produces(Sets.newHashSet("application/json"))
                .protocols(Sets.newHashSet("http", "https"))
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("per.wilson.validation"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        List list = new ArrayList();
        list.add(new StringVendorExtension("Wilson", "Validation"));
        return new ApiInfo("自定义校验", "枚举校验", "0.0.1", "blog.csdn.net/z28126308",
                contact(), "blog.csdn.net/z28126308", "blog.csdn.net/z28126308", list);
    }

    private Contact contact() {
        return new Contact("Wilson", "bugaosuni@163.com", "bugaosuni@163.com");
    }
}

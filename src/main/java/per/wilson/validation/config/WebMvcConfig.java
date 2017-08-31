package per.wilson.validation.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.List;

import static com.alibaba.fastjson.serializer.SerializerFeature.*;

/**
 * Created by Wilson on 2017/7/10.
 */
@EnableWebMvc
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    protected HttpMessageConverter messageConverter() {
        FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter4();
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Lists.newArrayList(
                new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8")),
                MediaType.APPLICATION_JSON_UTF8,
                new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"))));
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(DisableCircularReferenceDetect, QuoteFieldNames, WriteNonStringKeyAsString,
                WriteNullListAsEmpty, WriteNullBooleanAsFalse, WriteMapNullValue, WriteNullStringAsEmpty);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return fastJsonHttpMessageConverter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, messageConverter());
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        return new CharacterEncodingFilter("UTF-8",true);
    }

}

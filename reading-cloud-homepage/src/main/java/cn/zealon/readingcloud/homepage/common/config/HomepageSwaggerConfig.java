package cn.zealon.readingcloud.homepage.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置类
 * http://localhost:8080/swagger-ui.html
 * @author zealon
 * @since 2019-07-04
 */
@Configuration
@EnableSwagger2
public class HomepageSwaggerConfig {

    /**
     * swagger生成
     *
     * @return Docket
     */
    @Bean
    public Docket customDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.zealon.readingcloud.homepage.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
        return docket;
    }

    /**
     * swagger基础信息
     * @return ApiInfo swagger信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("阅读APP接口")
                .description("图书、用户、搜索相关")
                .termsOfServiceUrl("")
                .contact(new Contact("", "", ""))
                .license("")
                .licenseUrl("")
                .version("0.0.1")
                .build();
    }
}

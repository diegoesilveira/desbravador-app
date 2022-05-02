package br.com.desbravador.gestaoprojetosbackend.infra.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .groupName("br.com.gestaoprojetosbackend")
                .produces(getSupportedMediaTypes())
                .consumes(getSupportedMediaTypes())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private Set<String> getSupportedMediaTypes() {
        return Set.of(MediaType.APPLICATION_JSON_VALUE);
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .description("service to with its administrators")
                .contact(getContact())
                .title("service")
                .build();
    }
    private Contact getContact() {
        return new Contact("Gestao projetos services", "", "");
    }
}
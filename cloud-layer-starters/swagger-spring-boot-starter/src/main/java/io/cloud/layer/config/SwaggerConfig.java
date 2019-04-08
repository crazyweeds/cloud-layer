package io.cloud.layer.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * Swagger
 * @author RippleChan
 * @date 2019-02-26 23:47
 */
@EnableConfigurationProperties(SwaggerCoreProperties.class)
@Slf4j
public class SwaggerConfig {

    @Autowired
    private TypeResolver typeResolver;

    @Autowired
    private SwaggerCoreProperties swaggerCoreProperties;


    @Bean
    public Docket apis() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            .paths(PathSelectors.any())
            .build()
            .pathMapping("/")
            .apiInfo(this.apiInfo())
            .directModelSubstitute(LocalDate.class, String.class)
            .genericModelSubstitutes(ResponseEntity.class)
            .alternateTypeRules(newRule(typeResolver.resolve(DeferredResult.class, typeResolver.resolve(ResponseEntity.class, WildcardType.class)), typeResolver.resolve(WildcardType.class)))
            .useDefaultResponseMessages(false)
            .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("string")).build()))
            .securitySchemes(Collections.singletonList(apiKey()))
            .securityContexts(Collections.singletonList(securityContext()))
            .enableUrlTemplating(false);
        return docket;
    }

    private ApiKey apiKey() {
        return new ApiKey(HttpHeaders.AUTHORIZATION, HttpHeaders.AUTHORIZATION, In.HEADER.toValue());
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.any())
            .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }

    @SuppressWarnings("ALL")
    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
            swaggerCoreProperties.getInfo().getTitle(),
            swaggerCoreProperties.getInfo().getDescription(),
            swaggerCoreProperties.getInfo().getVersion(),
            swaggerCoreProperties.getInfo().getTermsOfServiceUrl(),
            swaggerCoreProperties.getInfo().getContactName(),
            swaggerCoreProperties.getInfo().getLicense(),
            swaggerCoreProperties.getInfo().getLicenseUrl());
        return apiInfo;
    }


    @Bean
    private UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
            .deepLinking(true)
            .displayOperationId(true)
            .defaultModelsExpandDepth(1)
            .defaultModelExpandDepth(1)
            .defaultModelRendering(ModelRendering.EXAMPLE)
            .displayRequestDuration(true)
            .docExpansion(DocExpansion.NONE)
            .filter(false)
            .maxDisplayedTags(null)
            .operationsSorter(OperationsSorter.ALPHA)
            .showExtensions(true)
            .tagsSorter(TagsSorter.ALPHA)
            .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
            .validatorUrl(null)
            .build();
    }


}

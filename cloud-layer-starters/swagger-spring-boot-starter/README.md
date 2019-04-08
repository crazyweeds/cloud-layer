# swagger-spring-boot-starter
SpringBoot快速集成Swagger

```
<dependency>
    <groupId>io.cloud.layer</groupId>
    <artifactId>swagger-spring-boot-starter</artifactId>
</dependency>
```

根据实际项目出发，作的配置。对Controller的扫描规则，是注解，这种方式比包名通用性更强，也更加简便。哪个注解更好呢？无疑就是Api.class了，它正好是使用在Controller上面，如果你需要修改，可以修改：io.cloud.layer.config.SwaggerConfig

```java
@Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2)
            ...
            .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
            ...
    }
```

## Paths(源自官方)
- All Swagger Resources(groups) `http://localhost:8080/springfox/swagger-resources`
- Swagger UI endpoint: `http://localhost:8080/springfox/swagger-ui.html`
- Swagger docs endpoint: `http://localhost:8080/springfox/v2/api-docs`


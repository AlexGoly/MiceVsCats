package ua.micevscats.cats;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springdoc.core.customizers.RouterOperationCustomizer;
import org.springdoc.core.filters.OpenApiMethodFilter;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.providers.SpringDocProviders;
import org.springdoc.core.service.AbstractRequestService;
import org.springdoc.core.service.GenericResponseService;
import org.springdoc.core.service.OpenAPIService;
import org.springdoc.core.service.OperationService;
import org.springdoc.webmvc.api.OpenApiWebMvcResource;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class SwaggerConfigMy extends OpenApiWebMvcResource {

    public SwaggerConfigMy(ObjectFactory<OpenAPIService> openAPIBuilderObjectFactory, AbstractRequestService requestBuilder, GenericResponseService responseBuilder, OperationService operationParser, Optional<List<OperationCustomizer>> operationCustomizers, Optional<List<OpenApiCustomizer>> openApiCustomizers, Optional<List<RouterOperationCustomizer>> routerOperationCustomizers, Optional<List<OpenApiMethodFilter>> methodFilters, SpringDocConfigProperties springDocConfigProperties, SpringDocProviders springDocProviders) {
        super(openAPIBuilderObjectFactory, requestBuilder, responseBuilder, operationParser, operationCustomizers, openApiCustomizers, routerOperationCustomizers, methodFilters, springDocConfigProperties, springDocProviders);
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${application-description}") String appDescription,
                                 @Value("${application-version}") String appVersion) {
        return new OpenAPI().info(new Info().title("Cats vs Mice.Application API")
                        .version(appVersion)
                        .description(appDescription)
//                        .license(new License().name("Apache 2.0")
//                                .url("http://springdoc.org"))
                        .contact(new Contact().name("Oleksandr Maksimov")
                                .email("maxymov.olexandr@gmail.com")))
                .servers(List.of(new Server().url("http://localhost:8080")
                                .description("Dev service"),
                        new Server().url("http://localhost:8082")
                                .description("Beta service")));
    }
}
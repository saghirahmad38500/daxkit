package io.cyangate.daxkit.conf;

import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.TreeMap;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenApiCustomizer sortSchemasAlphabetically() {
        return openApi -> {
            @SuppressWarnings("rawtypes") Map<String, Schema> schemas = openApi.getComponents().getSchemas();
            openApi.getComponents().setSchemas(new TreeMap<>(schemas));
        };
    }

}

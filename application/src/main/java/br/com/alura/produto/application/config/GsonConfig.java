package br.com.alura.produto.application.config;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import org.springframework.boot.gson.autoconfigure.GsonBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.parse;

@Configuration
public class GsonConfig {

    @Bean
    public GsonBuilderCustomizer localDateTimeGsonCustomizer() {
        JsonSerializer<LocalDateTime> serializer = (value, type, context) ->
                new JsonPrimitive(value.toString());
        JsonDeserializer<LocalDateTime> deserializer = (json, type, context) ->
                parse(json.getAsString());

        return builder -> builder.registerTypeAdapter(LocalDateTime.class, serializer)
                .registerTypeAdapter(LocalDateTime.class, deserializer);
    }
}

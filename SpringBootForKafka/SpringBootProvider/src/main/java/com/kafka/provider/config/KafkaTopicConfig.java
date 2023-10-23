package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configuration = new HashMap<>();
        configuration.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //DELETE (Borra mensaje), compact (Mantiene el mas actual)
        configuration.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); // TIEMPO DE RETENCION DE MENSAJE DEFECTO -1
        configuration.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); // Tamahio maximo del segmento - 1GB
        configuration.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); // TAMAJIO MAXIMO DE CADA MENSAJE - DEFECTO

        return TopicBuilder.name("unProgramadorNace-Topic")
                .partitions( 2)
                .replicas( 2)
                .configs(configuration)
                .build();
    }
}

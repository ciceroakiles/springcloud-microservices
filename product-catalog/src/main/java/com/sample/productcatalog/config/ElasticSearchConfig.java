package com.sample.productcatalog.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.sample.productcatalog.repository")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.http.port}")
    private String p1;

    @Value("${elasticsearch.transport.tcp.port}")
    private String p2;

    @Override
    @Bean(destroyMethod = "close")
    public RestHighLevelClient elasticsearchClient() {
        ClientConfiguration cg = ClientConfiguration.builder()
            .connectedTo(host + ":" + p1, host + ":" + p2).build();
        return RestClients.create(cg).rest();
    }

    @Bean
    @Override
    public EntityMapper entityMapper() {
        ElasticsearchEntityMapper em = new ElasticsearchEntityMapper(
            elasticsearchMappingContext(),
            new DefaultConversionService()
        );
        em.setConversions(elasticsearchCustomConversions());
        return em;
    }
}

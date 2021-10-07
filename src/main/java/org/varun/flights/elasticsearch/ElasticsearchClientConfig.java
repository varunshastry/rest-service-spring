package org.varun.flights.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.varun.flights.constants.Constants;

@PropertySource("classpath:elasticsearch/elasticsearch.properties")
@Configuration
@EnableElasticsearchRepositories(basePackages = "org.varun.flights.elasticsearch.repositories")
@ComponentScan(basePackages = { "org.varun.flights.services" })
public class ElasticsearchClientConfig extends AbstractElasticsearchConfiguration {
    @Autowired
    private Environment env;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        String hostAndPort = this.env.getProperty(Constants.ELASTICSEARCH_SERVER_IP) + ":" + this.env.getProperty(Constants.ELASTICSEARCH_SERVER_PORT);
        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(hostAndPort).build();
        return RestClients.create(clientConfiguration).rest();
    }
}

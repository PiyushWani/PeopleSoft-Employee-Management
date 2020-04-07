package com.peoplesoft.employee.config;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
// @EnableElasticsearchRepositories(basePackages = "com.peoplesoft.employee.repository")
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    //@Value("${elasticsearch.host:localhost}")
    //public String host;

    //@Value("${elasticsearch.port:9200}")
    //public int port;

    @Override
    public RestHighLevelClient elasticsearchClient(){
        // System.out.println("host: " + host + "\nport: "+ port);
        return RestClients.create(ClientConfiguration.localhost()).rest();
    }
}

package com.serhatacar.restaurantservice.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * @author Serhat Acar
 */


@Configuration
@EnableSolrRepositories(
        basePackages = "com.serhatacar.restaurantservice"
        , namedQueriesLocation = "classpath:solr-named-queries.properties"
)
@ComponentScan
public class SolrConfig {

    @Value("${isRunningOnDocker}")
    boolean isRunningOnDocker;

    @Bean
    public SolrClient solrClient() {

        if (isRunningOnDocker) {
            return new HttpSolrClient.Builder("http://solr:8983/solr").build();
        }

        return new HttpSolrClient.Builder("http://localhost:8983/solr").build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
}

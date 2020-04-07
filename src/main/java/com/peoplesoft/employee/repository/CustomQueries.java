package com.peoplesoft.employee.repository;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomQueries{

    public SearchRequest findViaEmployeeName(String name) {
        SearchRequest sr = new SearchRequest();
        SearchSourceBuilder ssb = new SearchSourceBuilder();
        MultiMatchQueryBuilder match = QueryBuilders.multiMatchQuery(name).lenient(true);
        ssb.query(match);
        sr.source(ssb);

        try{
            return client.search(sr, RequestOptions.DEFAULT);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
}

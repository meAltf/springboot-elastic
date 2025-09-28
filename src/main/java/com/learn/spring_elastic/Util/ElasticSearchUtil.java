package com.learn.spring_elastic.Util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;

//import static org.springframework.data.elasticsearch.client.elc.Queries.matchAllQuery;

public class ElasticSearchUtil {

    public static Supplier<Query> querySupplier(){
        Supplier<Query> supplier = () -> Query.of(query-> query.matchAll(matchAllQuery()));
        return  supplier;
    }

    public static MatchAllQuery matchAllQuery(){
        val matchAllQuery = new MatchAllQuery.Builder();
        return matchAllQuery.build();
    }
}

package com.learn.spring_elastic.Service;

import co.elastic.clients.elasticsearch.core.SearchResponse;

import java.io.IOException;
import java.util.Map;

public interface ElasticSearchService {

    SearchResponse<Map> matchAllService() throws IOException;
}

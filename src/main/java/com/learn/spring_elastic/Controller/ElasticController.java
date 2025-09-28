package com.learn.spring_elastic.Controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.learn.spring_elastic.Service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/elastic/search")
public class ElasticController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("/matchAll")
    public String matchAll() throws IOException {
        SearchResponse<Map> searchResponse = elasticSearchService.matchAllService();

        System.out.println(searchResponse.hits().hits().toString());
        return searchResponse.hits().hits().toString();
    }
}

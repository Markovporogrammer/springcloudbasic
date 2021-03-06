package com.basic.goodsbusiness.service.impl;

import com.alibaba.fastjson.JSON;
import com.basic.goodsbusiness.service.GoodsService;
import com.basic.pojo.Hero;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Service
public class GoodsServiceImpl implements GoodsService {


    private static final String MUSTNOT = "mustNot";
    private static final String MUST_NOT = "must_not";
    private static final String FILTER = "filter";
    private static final String SHOULD = "should";
    private static final String MUST = "must";

    @Autowired
    RestHighLevelClient client;
    @Override
    public void createIndex() throws IOException {
        IndexRequest request = new IndexRequest("hero");
        request.id("1");
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "??????");
        map.put("country", "???");
        map.put("birthday", "??????155???");
        map.put("longevity", "65");
        request.source(map);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        long version = indexResponse.getVersion();


    }

    public void bulkRequestTest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("hero").id("2")
                .source(XContentType.JSON,"id", "2", "name", "??????", "country", "???", "birthday", "??????161???", "longevity", "61"));
        request.add(new IndexRequest("hero").id("3")
                .source(XContentType.JSON,"id", "3", "name", "??????", "country", "???", "birthday", "??????182???", "longevity", "61"));
        request.add(new IndexRequest("hero").id("4")
                .source(XContentType.JSON,"id", "4", "name", "?????????", "country", "???", "birthday", "??????181???", "longevity", "53"));
        request.add(new IndexRequest("hero").id("5")
                .source(XContentType.JSON,"id", "5", "name", "?????????", "country", "???", "birthday", "??????179???", "longevity", "72"));
        request.add(new IndexRequest("hero").id("6")
                .source(XContentType.JSON,"id", "6", "name", "??????", "country", "???", "birthday", "??????163???", "longevity", "49"));
        request.add(new IndexRequest("hero").id("7")
                .source(XContentType.JSON,"id", "7", "name", "??????", "country", "???", "birthday", "??????160???", "longevity", "60"));
        request.add(new IndexRequest("hero").id("8")
                .source(XContentType.JSON,"id", "8", "name", "??????", "country", "???", "birthday", "??????175???",  "longevity", "35"));
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
    }

    public void updateTest() throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("country", "???");
        UpdateRequest request = new UpdateRequest("hero", "7").doc(jsonMap);
        UpdateResponse updateResponse = client.update(request,  RequestOptions.DEFAULT);
    }
    public void insertOrUpdateOne(){
        Hero hero = new Hero();
        hero.setId(5);
        hero.setName("??????");
        hero.setCountry("???");
        hero.setBirthday("??????187???445651sas");
        hero.setLongevity(39);
        IndexRequest request = new IndexRequest("hero");
        request.id(hero.getId().toString());
        request.source(JSON.toJSONString(hero), XContentType.JSON);
        try {
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);   //  1
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteByIdTest() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("hero");
        deleteRequest.id("1");
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
    }

    public void deleteByQueryRequestTest() throws IOException {
        DeleteByQueryRequest request = new DeleteByQueryRequest("hero");
        request.setConflicts("proceed");
        request.setQuery(new TermQueryBuilder("country", "???"));
        BulkByScrollResponse bulkResponse =
                client.deleteByQuery(request, RequestOptions.DEFAULT);
    }

    public void bulkDiffRequestTest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest("hero", "3"));
        request.add(new UpdateRequest("hero", "7")
                .doc(XContentType.JSON,"longevity", "70"));
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        BulkItemResponse[]  bulkItemResponses = bulkResponse.getItems();
        for (BulkItemResponse item : bulkItemResponses){
            DocWriteResponse itemResponse = item.getResponse();
            switch (item.getOpType()) {
                case UPDATE:
                    UpdateResponse updateResponse = (UpdateResponse) itemResponse;
                    break;
                case DELETE:
                    DeleteResponse deleteResponse = (DeleteResponse) itemResponse;
            }
        }
    }
    //??????????????? + limit
    public void selectByUserTest(){
        SearchRequest request = new SearchRequest("hero");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(new TermQueryBuilder("country", "???"));
        // ?????????mysql?????????limit 1???
        builder.size(1);
        request.source(builder);
        try {
            SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            SearchHit[] hits = response.getHits().getHits();
            List<Hero> herosList = new ArrayList<>(hits.length);
            for (SearchHit hit : hits) {
                herosList.add(JSON.parseObject(hit.getSourceAsString(), Hero.class));
            }
            System.out.println(herosList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //??????????????? + ?????? + ??????
    public void boolQueryTest(){
        SearchRequest request = new SearchRequest("hero");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(prefixQuery("country", "???"));
        boolQueryBuilder.must(rangeQuery("longevity").gte(50));
        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.from(0).size(2);
        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.sort("longevity", SortOrder.DESC);
        request.source(sourceBuilder);
        SearchResponse response = null;
        try {
            response = client.search(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
           // log.error("Query by Condition execution failed: {}", e.getMessage(), e);
        }
        SearchHit[] hits = response.getHits().getHits();
        List<Hero> herosList = new ArrayList<>(hits.length);
        for (SearchHit hit : hits) {
            herosList.add(JSON.parseObject(hit.getSourceAsString(), Hero.class));
        }
        System.out.println(herosList);
       // log.info("print info: {}, size: {}", herosList.toString(), herosList.size());
    }


}

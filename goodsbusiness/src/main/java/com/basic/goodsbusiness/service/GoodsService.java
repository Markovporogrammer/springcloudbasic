package com.basic.goodsbusiness.service;

import java.io.IOException;

/**
 * @author mzp
 * @date 2021/7/15 19:32
 */
public interface GoodsService {

    void createIndex() throws IOException;

    public void bulkRequestTest() throws IOException;

    public void updateTest() throws IOException;

    public void insertOrUpdateOne();

    public void deleteByIdTest() throws IOException;

    public void deleteByQueryRequestTest() throws IOException;

    public void bulkDiffRequestTest() throws IOException;

    public void selectByUserTest();

    public void boolQueryTest();
}

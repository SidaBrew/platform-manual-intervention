package com.zenki.dataplus.pmi.service.impl;

import com.zenki.dataplus.pmi.dao.generated.entity.BlobTest;
import com.zenki.dataplus.pmi.dao.generated.mappper.BlobTestMapper;
import com.zenki.dataplus.pmi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 *  Created by shao.guangze on 2020/5/31
 */
@Service("TestServiceImpl")
public class TestServiceImpl implements TestService {


    @Autowired
    private BlobTestMapper blobTestMapper;

    int insert = 1;
    @Override
    public String method() {
        BlobTest blobTest = new BlobTest();
        blobTest.setId(111267);
        byte[] aByte = {10};
        blobTest.setFileContent(aByte);
        int insert = blobTestMapper.insert(blobTest);
        return insert+"";
    }
}

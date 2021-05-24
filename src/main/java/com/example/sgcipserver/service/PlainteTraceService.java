package com.example.sgcipserver.service;


import com.example.sgcipserver.bean.PlainteTrace;
import com.example.sgcipserver.dao.PlainteTraceDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlainteTraceService {
    public PlainteTrace findByRef(String ref) {
        return plainteTraceDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return plainteTraceDao.deleteByRef(ref);
    }

    public List<PlainteTrace> findAll() {
        return plainteTraceDao.findAll();
    }

    public int save(PlainteTrace plainteTrace) {
        if (findByRef(plainteTrace.getRef()) == null) {
            plainteTraceDao.save(plainteTrace);
            return 1;
        }
        else return -1;
    }

    @Autowired
    PlainteTraceDao plainteTraceDao;
}

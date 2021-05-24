package com.example.sgcipserver.service;


import com.example.sgcipserver.bean.RClasss;
import com.example.sgcipserver.dao.RClasssDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RClasssService {
    public RClasss findByRef(String ref) {
        return rClasssDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return rClasssDao.deleteByRef(ref);
    }

    public List<RClasss> findAll() {
        return rClasssDao.findAll();
    }

    public int save(RClasss rClasss) {
        if (findByRef(rClasss.getRef()) == null) {
            rClasssDao.save(rClasss);
            return 1;
        } else {
            return -1;
        }
    }

    @Autowired
    RClasssDao rClasssDao;
}

package com.example.sgcipserver.service;


import com.example.sgcipserver.bean.Plainte;
import com.example.sgcipserver.dao.PlainteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class PlainteService {

    public Plainte findByRef(String ref) {
        return plainteDao.findByRef(ref);
    }

    public Plainte findByCreatedAt(Date date) {
        return plainteDao.findByCreatedAt(date);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return plainteDao.deleteByRef(ref);
    }

    public List<Plainte> findAll() {
        return plainteDao.findAll();
    }

    public int save(Plainte plainte) {
        if (findByRef(plainte.getRef()) == null) {
            plainteDao.save(plainte);
            return 1;
        } else {
            return -1;
        }
    }
    @Autowired
    PlainteDao plainteDao;
}

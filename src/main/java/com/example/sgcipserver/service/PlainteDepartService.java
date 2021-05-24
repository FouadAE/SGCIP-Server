package com.example.sgcipserver.service;



import com.example.sgcipserver.bean.PlainteDepart;
import com.example.sgcipserver.dao.PlainteDepartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PlainteDepartService {
    public PlainteDepart findByRef(String ref) {
        return plainteDepartDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return plainteDepartDao.deleteByRef(ref);
    }

    public List<PlainteDepart> findAll() {
        return plainteDepartDao.findAll();
    }

    public int save(PlainteDepart plainteDepart) {
        if (findByRef(plainteDepart.getRef()) == null) {
            plainteDepartDao.save(plainteDepart);
            return 1;
        } else {
            return -1;
        }
    }

    @Autowired
    PlainteDepartDao plainteDepartDao;

}

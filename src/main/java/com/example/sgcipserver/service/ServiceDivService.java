package com.example.sgcipserver.service;


import com.example.sgcipserver.bean.ServiceDiv;
import com.example.sgcipserver.dao.ServiceDivDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceDivService {
    public ServiceDiv findByRef(String ref) {
        return serviceDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return serviceDao.deleteByRef(ref);
    }

    public List<ServiceDiv> findAll() {
        return serviceDao.findAll();
    }

    public int save(ServiceDiv serviceDiv) {
        if (findByRef(serviceDiv.getRef()) == null){
            serviceDao.save(serviceDiv);
            return 1;
        }else{
            return -1;
        }
    }

    @Autowired
    ServiceDivDao serviceDao;
}

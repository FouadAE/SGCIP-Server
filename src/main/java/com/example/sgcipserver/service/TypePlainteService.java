package com.example.sgcipserver.service;



import com.example.sgcipserver.bean.TypePlainte;
import com.example.sgcipserver.dao.TypePlainteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypePlainteService {
    public TypePlainte findByRef(String ref) {
        return typePlainteDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return typePlainteDao.deleteByRef(ref);
    }

    public List<TypePlainte> findAll() {
        return typePlainteDao.findAll();
    }

    public int save(TypePlainte typePlainte) {

        if (findByRef(typePlainte.getRef()) == null) {
            typePlainteDao.save(typePlainte);
            return 1;
        } else return -1;
    }

    @Autowired
    TypePlainteDao typePlainteDao;
}

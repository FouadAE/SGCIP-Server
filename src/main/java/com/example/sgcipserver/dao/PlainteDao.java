package com.example.sgcipserver.dao;


import com.example.sgcipserver.bean.Plainte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PlainteDao extends JpaRepository<Plainte, Long> {
    Plainte findByRef(String ref);

    Plainte findByCreatedAt(Date date);

    int deleteByRef(String ref);

}

package com.example.sgcipserver.dao;

import com.example.sgcipserver.bean.PlainteTrace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainteTraceDao extends JpaRepository<PlainteTrace, Long> {
    PlainteTrace findByRef(String ref);

    int deleteByRef(String ref);

}

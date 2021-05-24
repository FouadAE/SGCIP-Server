package com.example.sgcipserver.dao;

import com.example.sgcipserver.bean.ServiceDiv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDivDao extends JpaRepository<ServiceDiv, Long> {
    ServiceDiv findByRef(String ref);

    int deleteByRef(String ref);
}

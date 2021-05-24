package com.example.sgcipserver.dao;


import com.example.sgcipserver.bean.RClasss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RClasssDao extends JpaRepository<RClasss, Long> {
    RClasss findByRef(String ref);

    int deleteByRef(String ref);
}

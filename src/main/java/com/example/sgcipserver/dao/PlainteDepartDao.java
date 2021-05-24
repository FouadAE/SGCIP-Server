package com.example.sgcipserver.dao;


import com.example.sgcipserver.bean.PlainteDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainteDepartDao extends JpaRepository<PlainteDepart, Long> {
    PlainteDepart findByRef(String ref);

    int deleteByRef(String ref);
}

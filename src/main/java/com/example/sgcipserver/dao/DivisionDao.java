package com.example.sgcipserver.dao;


import com.example.sgcipserver.bean.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionDao extends JpaRepository<Division, Long> {
    Division findByRef(String ref);

    int deleteByRef(String ref);

}

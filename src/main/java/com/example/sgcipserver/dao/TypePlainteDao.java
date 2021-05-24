package com.example.sgcipserver.dao;

import com.example.sgcipserver.bean.TypePlainte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePlainteDao extends JpaRepository<TypePlainte, Long> {
    TypePlainte findByRef(String Ref);

    int deleteByRef(String ref);
}

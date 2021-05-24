package com.example.sgcipserver.dao;

import com.example.sgcipserver.bean.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeDao extends JpaRepository<Theme, Long> {
    Theme findByRef(String ref);

    int deleteByRef(String ref);
}

package com.example.sgcipserver.dao;

import com.example.sgcipserver.bean.Plainte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainteDao extends JpaRepository<Plainte, Long> {
	Plainte findByRef(String ref);

	int deleteByRef(String ref);

}

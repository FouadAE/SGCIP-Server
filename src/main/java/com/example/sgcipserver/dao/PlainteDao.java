package com.example.sgcipserver.dao;

import com.example.sgcipserver.bean.Plainte;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainteDao extends JpaRepository<Plainte, Long> {
	Plainte findByRef(String ref);
	
	List<Plainte> findByDivisionRef(String ref);

	List<Plainte> findByThemeRef(String ref);

	List<Plainte> findByStatusStatusName(String statusName);

	Plainte findByNumeroDOrdre(Long numeroDOrdre);

	List<Plainte> findByType(String type);


	List<Plainte> findAllByCreatedAtBetween(Date startDate, Date endDate);

	int deleteByRef(String ref);

}

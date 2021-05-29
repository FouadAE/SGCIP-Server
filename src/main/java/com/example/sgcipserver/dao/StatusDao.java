package com.example.sgcipserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sgcipserver.bean.Status;

@Repository
public interface StatusDao extends JpaRepository<Status, Long> {

	Status findByStatusName(String statusName);

	int deleteByStatusName(String statusName);
}
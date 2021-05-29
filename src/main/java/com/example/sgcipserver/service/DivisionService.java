package com.example.sgcipserver.service;

import com.example.sgcipserver.bean.Division;
import com.example.sgcipserver.bean.ServiceDiv;
import com.example.sgcipserver.dao.DivisionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DivisionService {

	public Division findByRef(String ref) {
		return divisionDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		return divisionDao.deleteByRef(ref);
	}

	public List<Division> findAll() {
		return divisionDao.findAll();
	}

	public int save(Division division) {
		ServiceDiv serviceDiv = serviceDivService.findByRef(division.getDivisionParent().getRef());
		if (findByRef(division.getRef()) != null) {
			return -1;
		} else if (serviceDiv == null) {
			return -2;
		} else {
			division.setDivisionParent(serviceDiv);
			divisionDao.save(division);
			return 1;
		}
	}

	@Autowired
	DivisionDao divisionDao;
	@Autowired
	ServiceDivService serviceDivService;
}

package com.example.sgcipserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sgcipserver.bean.Status;
import com.example.sgcipserver.dao.StatusDao;

@Service
public class StatusService {

	@Autowired
	StatusDao statusDao;

	public Status findByStatusName(String statusName) {
		return statusDao.findByStatusName(statusName);
	}

	@Transactional
	public int deleteByStatusName(String statusName) {
		return statusDao.deleteByStatusName(statusName);
	}

	public List<Status> findAll() {
		return statusDao.findAll();
	}

	public int save(Status status) {

		if (findByStatusName(status.getStatusName()) != null) {
			return -1;
		} else {
			statusDao.save(status);
			return 1;
		}
	}
}

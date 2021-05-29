package com.example.sgcipserver.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String statusName;
	String statusFr;
	String phase;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String status) {
		this.statusName = status;
	}

	public String getStatusFr() {
		return statusFr;
	}

	public void setStatusFr(String statusFr) {
		this.statusFr = statusFr;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}
}

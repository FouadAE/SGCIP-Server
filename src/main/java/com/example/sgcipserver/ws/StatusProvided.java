package com.example.sgcipserver.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sgcipserver.bean.Status;
import com.example.sgcipserver.service.StatusService;

@RestController
@RequestMapping("/api/sgcip/status")
public class StatusProvided {

	@Autowired
	StatusService statusService;

	@GetMapping("/status/{status}")
	public Status findByStatusName(@PathVariable String statusName) {
		return statusService.findByStatusName(statusName);
	}

	@DeleteMapping("/status/{status}")
	public int deleteByStatusName(@PathVariable String statusName) {
		return statusService.deleteByStatusName(statusName);
	}

	@GetMapping("/")
	public List<Status> findAll() {
		return statusService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Status status) {
		return statusService.save(status);
	}
}

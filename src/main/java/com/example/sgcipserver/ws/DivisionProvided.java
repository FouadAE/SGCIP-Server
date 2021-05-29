package com.example.sgcipserver.ws;

import com.example.sgcipserver.bean.Division;
import com.example.sgcipserver.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgcip/division")
public class DivisionProvided {
	@GetMapping("/ref/{ref}")
	public Division findByRef(@PathVariable String ref) {
		return divisionService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return divisionService.deleteByRef(ref);
	}

	@GetMapping("/")
	public List<Division> findAll() {
		return divisionService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Division division) {
		return divisionService.save(division);
	}

	@Autowired
	DivisionService divisionService;

}

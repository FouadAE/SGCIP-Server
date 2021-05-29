package com.example.sgcipserver.ws;

import com.example.sgcipserver.bean.Plainte;
import com.example.sgcipserver.service.PlainteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sgcip/plainte")
public class PlainteProvided {

	@GetMapping("/ref/{ref}")
	public Plainte findByRef(@PathVariable String ref) {
		return plainteService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return plainteService.deleteByRef(ref);
	}

	@GetMapping("/")
	public List<Plainte> findAll() {
		return plainteService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Plainte plainte) {
		return plainteService.save(plainte);
	}

	@Autowired
	PlainteService plainteService;

}

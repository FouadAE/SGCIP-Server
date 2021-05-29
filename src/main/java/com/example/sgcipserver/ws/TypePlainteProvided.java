package com.example.sgcipserver.ws;

import com.example.sgcipserver.bean.TypePlainte;
import com.example.sgcipserver.service.TypePlainteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgcip/typePlainte")
public class TypePlainteProvided {

	@GetMapping("/ref/{ref}")
	public TypePlainte findByRef(@PathVariable String ref) {
		return typePlainteService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return typePlainteService.deleteByRef(ref);
	}

	@GetMapping("/")
	public List<TypePlainte> findAll() {
		return typePlainteService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody TypePlainte typePlainte) {
		return typePlainteService.save(typePlainte);
	}

	@Autowired
	TypePlainteService typePlainteService;
}

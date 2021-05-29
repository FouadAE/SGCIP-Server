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

import com.example.sgcipserver.bean.Dossier;
import com.example.sgcipserver.service.DossierService;

@RestController
@RequestMapping("/sgcip/dossier")
public class DossierProvided {

	@Autowired
	DossierService dossierService;

	@GetMapping("/ref/{ref}")
	public Dossier findByRef(@PathVariable String ref) {
		return dossierService.findByRef(ref);
	}

	@GetMapping("/")
	public List<Dossier> findAll() {
		return dossierService.findAll();
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return dossierService.deleteByRef(ref);
	}

	@PostMapping("/")
	public int save(@RequestBody Dossier dossier) {
		return dossierService.save(dossier);
	}

}

package com.example.sgcipserver.ws;

import com.example.sgcipserver.bean.Instruction;
import com.example.sgcipserver.service.InstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sgcip/instruction")
public class IntructionProvided {
	@GetMapping("/ref/{ref}")
	public Instruction findByRef(@PathVariable String ref) {
		return instructionService.findByRef(ref);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return instructionService.deleteByRef(ref);
	}

	@GetMapping("/")
	public List<Instruction> findAll() {
		return instructionService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Instruction instruction) {
		return instructionService.save(instruction);
	}

	@Autowired
	InstructionService instructionService;
}

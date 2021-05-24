package com.example.sgcipserver.service;


import com.example.sgcipserver.bean.Instruction;
import com.example.sgcipserver.dao.InstructionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InstructionService {
    public Instruction findByRef(String ref) {
        return instructionDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return instructionDao.deleteByRef(ref);
    }

    public List<Instruction> findAll() {
        return instructionDao.findAll();
    }

    public int save(Instruction instruction) {
        if (findByRef(instruction.getRef()) == null) {
            instructionDao.save(instruction);
            return 1;
        } else return -1;
    }

    @Autowired
    InstructionDao instructionDao;
}

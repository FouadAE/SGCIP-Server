package com.example.sgcipserver.dao;


import com.example.sgcipserver.bean.Instruction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionDao extends JpaRepository<Instruction, Long> {
    Instruction findByRef(String ref);

    int deleteByRef(String ref);
}

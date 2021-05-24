package com.example.sgcipserver.ws;


import com.example.sgcipserver.bean.PlainteTrace;
import com.example.sgcipserver.service.PlainteTraceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/sgcip/plainteTrace")
public class PlainteTraceProvided {
    @GetMapping("/ref/{ref}")
    public PlainteTrace findByRef(@PathVariable String ref) {
        return plainteTraceService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return plainteTraceService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<PlainteTrace> findAll() {
        return plainteTraceService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody PlainteTrace plainteTrace) {
        return plainteTraceService.save(plainteTrace);
    }

    @Autowired
    PlainteTraceService plainteTraceService;
}

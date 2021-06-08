package com.example.sgcipserver.ws;


import com.example.sgcipserver.bean.RClasss;
import com.example.sgcipserver.service.RClasssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sgcip/class")
public class RClasssProvided {
    @GetMapping("/ref/{ref}")
    public RClasss findByRef(@PathVariable String ref) {
        return rClasssService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return rClasssService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<RClasss> findAll() {
        return rClasssService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody RClasss rClasss) {
        return rClasssService.save(rClasss);
    }

    @Autowired
    RClasssService rClasssService;

}

package com.example.sgcipserver.ws;


import com.example.sgcipserver.bean.PlainteDepart;
import com.example.sgcipserver.service.PlainteDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgcip/plainteDepart")
public class PlainteDepartProvided {
    @GetMapping("/ref/{ref}")
    public PlainteDepart findByRef(@PathVariable String ref) {
        return plainteDepartService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return plainteDepartService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<PlainteDepart> findAll() {
        return plainteDepartService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody PlainteDepart plainteDepart) {
        return plainteDepartService.save(plainteDepart);
    }

    @Autowired
    PlainteDepartService plainteDepartService;

}

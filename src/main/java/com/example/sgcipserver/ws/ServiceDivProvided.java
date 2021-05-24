package com.example.sgcipserver.ws;


import com.example.sgcipserver.bean.ServiceDiv;
import com.example.sgcipserver.service.ServiceDivService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sgcip/ServiceDiv")
public class ServiceDivProvided {
    @GetMapping("/ref/{ref}")
    public ServiceDiv findByRef(@PathVariable String ref) {
        return serviceDivService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return serviceDivService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<ServiceDiv> findAll() {
        return serviceDivService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody ServiceDiv serviceDiv) {
        return serviceDivService.save(serviceDiv);
    }

    @Autowired
    ServiceDivService serviceDivService;

}

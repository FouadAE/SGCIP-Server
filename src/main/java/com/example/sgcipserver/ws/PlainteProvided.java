package com.example.sgcipserver.ws;

import com.example.sgcipserver.bean.Plainte;
import com.example.sgcipserver.service.PlainteService;
import com.example.sgcipserver.vo.PlainteVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/sgcip/plainte")
public class PlainteProvided {

    @GetMapping("/ref/{ref}")
    public Plainte findByRef(@PathVariable String ref) {
        return plainteService.findByRef(ref);
    }

    @DeleteMapping("/numeroDOrdre/{numeroDOrdre}")
    public int deleteByNumeroDOrdre(@PathVariable long numeroDOrdre) {
        return plainteService.deleteByNumeroDOrdre(numeroDOrdre);
    }


    @GetMapping("/")
    public List<Plainte> findAll() {
        return plainteService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Plainte plainte) {
        return plainteService.save(plainte);
    }

    @GetMapping("/division/ref/{ref}")
    public List<Plainte> findByDivisionRef(@PathVariable String ref) {
        return plainteService.findByDivisionRef(ref);
    }

    @GetMapping("/createdatbetween")
    public List<Plainte> findAllByCreatedAtBetween(
            @RequestParam("startdate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {
        return plainteService.findAllByCreatedAtBetween(startDate, endDate);
    }

    @GetMapping("/theme/ref/{ref}")
    public List<Plainte> findByThemeRef(String ref) {
        return plainteService.findByThemeRef(ref);
    }

    @PostMapping("/critere")
    public List<Plainte> findByCritere(@RequestBody PlainteVo plainteVo) {
        return plainteService.findByCritere(plainteVo);
    }

    @GetMapping("/status/statusName/{statusName}")
    public List<Plainte> findByStatusStatusName(@PathVariable String statusName) {
        return plainteService.findByStatusStatusName(statusName);
    }

    @GetMapping("/numeroDOrdre/{numeroDOrdre}")
    public Plainte findByNumeroDOrdre(@PathVariable Long numeroDOrdre) {
        return plainteService.findByNumeroDOrdre(numeroDOrdre);
    }

    @GetMapping("/type/{type}")
    public List<Plainte> findByType(@PathVariable String type) {
        return plainteService.findByType(type);
    }

    @PutMapping("/")
    public int modifyPlainte(@RequestBody Plainte plainte) {
        return plainteService.modifyPlainte(plainte);
    }

    @Autowired
    PlainteService plainteService;

}

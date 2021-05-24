package com.example.sgcipserver.ws;

import com.example.sgcipserver.bean.Theme;
import com.example.sgcipserver.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("sgcip/theme")
public class ThemeProvided {
    @GetMapping("/ref/{ref}")
    public Theme findByRef(@PathVariable String ref) {
        return themeService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return themeService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<Theme> findAll() {
        return themeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Theme theme) {
        return themeService.save(theme);
    }

    @Autowired
    ThemeService themeService;

}

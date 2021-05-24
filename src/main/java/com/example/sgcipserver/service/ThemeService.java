package com.example.sgcipserver.service;

import com.example.sgcipserver.bean.Theme;
import com.example.sgcipserver.dao.ThemeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ThemeService {
    public Theme findByRef(String ref) {
        return themeDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return themeDao.deleteByRef(ref);
    }

    public List<Theme> findAll() {
        return themeDao.findAll();
    }

    public int save(Theme theme) {
        if (findByRef(theme.getTheme()) == null) {

            themeDao.save(theme);
            return 1;
        } else return -1;
    }

    @Autowired
    ThemeDao themeDao;

}

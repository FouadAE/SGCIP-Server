package com.example.sgcipserver.service;

import com.example.sgcipserver.bean.Division;
import com.example.sgcipserver.bean.Dossier;
import com.example.sgcipserver.bean.Instruction;
import com.example.sgcipserver.bean.Plainte;
import com.example.sgcipserver.bean.PlainteDepart;
import com.example.sgcipserver.bean.RClasss;
import com.example.sgcipserver.bean.Status;
import com.example.sgcipserver.bean.Theme;
import com.example.sgcipserver.dao.PlainteDao;
import com.example.sgcipserver.vo.PlainteVo;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PlainteService {

    public Plainte findByRef(String ref) {
        return plainteDao.findByRef(ref);
    }


    public List<Plainte> findAll() {
        return plainteDao.findAll();
    }

    public List<Plainte> findByDivisionRef(String ref) {
        return plainteDao.findByDivisionRef(ref);
    }

    public List<Plainte> findAllByCreatedAtBetween(Date startDate, Date endDate) {
        return plainteDao.findAllByCreatedAtBetween(startDate, endDate);
    }

    public List<Plainte> findByThemeRef(String ref) {
        return plainteDao.findByThemeRef(ref);
    }

    public List<Plainte> findByStatusStatusName(String statusName) {
        return plainteDao.findByStatusStatusName(statusName);

    }

    @Transactional
    public int deleteByNumeroDOrdre(long numeroDOrdre) {
        return plainteDao.deleteByNumeroDOrdre(numeroDOrdre);
    }

    public Plainte findByNumeroDOrdre(Long numeroDOrdre) {
        return plainteDao.findByNumeroDOrdre(numeroDOrdre);
    }

    public List<Plainte> findByType(String type) {
        return plainteDao.findByType(type);
    }


    public int modifyPlainte(Plainte plainte) {
        Plainte p = findByNumeroDOrdre(plainte.getNumeroDOrdre());
        if (p == null) return -1;
        else {
            System.out.println(plainte.getDossier().getNom());
            p.setNumeroDOrdre(plainte.getNumeroDOrdre());
            p.setDatePlainte(plainte.getDatePlainte());
            p.setCreatedAt(plainte.getCreatedAt());
            p.setDateEnvoi(plainte.getDateEnvoi());
            p.setDivision(plainte.getDivision());
            p.setDossier(dossierService.findByNom(plainte.getDossier().getNom()));
            p.setRef(plainte.getRef());
            p.setObjet(plainte.getObjet());
            p.setPublie(plainte.getPublie());
            p.setNumeroEnvoi(plainte.getNumeroEnvoi());
            p.setObservation(plainte.getObservation());
            p.setSource(plainte.getSource());
            p.setType(plainte.getType());
            p.setVisa(plainte.getVisa());
            p.setExpediteur(plainte.getExpediteur());
            p.setDivision(plainte.getDivision());
            p.setInstruction(plainte.getInstruction());
            p.setPlainteDepart(plainte.getPlainteDepart());
            p.setTheme(plainte.getTheme());
            p.setStatus(plainte.getStatus());
            p.setpClasse(plainte.getpClasse());
            plainteDao.save(p);
            return 1;
        }
    }

    public int save(Plainte plainte) {
        Division division = divisionService.findByRef(plainte.getDivision().getRef());
        Instruction instruction = instructionService.findByRef(plainte.getInstruction().getRef());
        PlainteDepart plainteDepart = plainteDepartService.findByRef(plainte.getPlainteDepart().getRef());
        Theme theme = themeService.findByRef(plainte.getTheme().getRef());
        Dossier dossier = dossierService.findByNom(plainte.getDossier().getNom());
        Status status = statusService.findByStatusName(plainte.getStatus().getStatusName());
        RClasss pClasse = rClasssService.findByRef(plainte.getpClasse().getRef());
        plainte.setDivision(division);
        plainte.setPlainteDepart(plainteDepart);
        plainte.setTheme(theme);
        plainte.setStatus(status);
        plainte.setpClasse(pClasse);
        plainte.setInstruction(instruction);
        System.out.println(plainte);
        if (dossier == null) {
            Dossier newDossier = new Dossier();
            newDossier.setNom(plainte.getDossier().getNom());
            dossierService.save(newDossier);
            plainte.setDossier(newDossier);
        } else {
            plainte.setDossier(dossier);
        }
        if (findByNumeroDOrdre(plainte.getNumeroDOrdre()) != null) {
            return -1;
        } else if (division == null && plainteDepart == null && theme == null && status == null && pClasse == null
                && instruction == null) {
            return -2;
        } else {
            plainteDao.save(plainte);
            return 1;
        }
    }

    public List<Plainte> findByCritere(PlainteVo plainteVo) {
        String query = "SELECT p FROM Plainte p where 1=1";
        if (plainteVo.getNumeroDOrdre() != null && !plainteVo.getNumeroDOrdre().isEmpty())
            query += "AND p.numeroDOrdre ='" + plainteVo.getNumeroDOrdre() + "'";
        if (plainteVo.getStatus() != null && !plainteVo.getStatus().isEmpty())
            query += "AND p.status.statusName ='" + plainteVo.getStatus() + "'";
        if (plainteVo.getType() != null && !plainteVo.getType().isEmpty())
            query += "AND p.type ='" + plainteVo.getType() + "'";
        if (plainteVo.getEndDate() != null && !plainteVo.getEndDate().isEmpty())
            query += "AND p.datePlainte <='" + plainteVo.getEndDate() + "'";
        if (plainteVo.getStartDate() != null && !plainteVo.getStartDate().isEmpty())
            query += "AND p.datePlainte >='" + plainteVo.getStartDate() + "'";

        return entityManager.createQuery(query).getResultList();
    }

    @Autowired
    PlainteDao plainteDao;
    @Autowired
    DivisionService divisionService;
    @Autowired
    InstructionService instructionService;
    @Autowired
    PlainteDepartService plainteDepartService;
    @Autowired
    ThemeService themeService;
    @Autowired
    DossierService dossierService;
    @Autowired
    StatusService statusService;
    @Autowired
    RClasssService rClasssService;
    @Autowired
    EntityManager entityManager;
}

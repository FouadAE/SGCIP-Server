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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PlainteService {

	public Plainte findByRef(String ref) {
		return plainteDao.findByRef(ref);
	}

	@Transactional
	public int deleteByRef(String ref) {
		return plainteDao.deleteByRef(ref);
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

	public int save(Plainte plainte) {
		Division division = divisionService.findByRef(plainte.getDivision().getRef());
		Instruction instruction = instructionService.findByRef(plainte.getInstruction().getRef());
		PlainteDepart plainteDepart = plainteDepartService.findByRef(plainte.getPlainteDepart().getRef());
		Theme theme = themeService.findByRef(plainte.getTheme().getRef());
		Dossier dossier = dossierService.findByRef(plainte.getDossier().getRef());
		Status status = statusService.findByStatusName(plainte.getStatus().getStatusName());
		RClasss pClasse = rClasssService.findByRef(plainte.getpClasse().getRef());
		plainte.setDivision(division);
		plainte.setPlainteDepart(plainteDepart);
		plainte.setTheme(theme);
		plainte.setStatus(status);
		plainte.setpClasse(pClasse);
		plainte.setInstruction(instruction);
		if (dossier == null) {
			Dossier newDossier = new Dossier();
			newDossier.setRef(plainte.getDossier().getRef());
			dossierService.save(newDossier);
			plainte.setDossier(newDossier);
		} else {
			plainte.setDossier(dossier);
		}
		if (findByRef(plainte.getRef()) != null) {
			return -1;
		} else if (division == null && plainteDepart == null && theme == null && status == null && pClasse == null
				&& instruction == null) {
			return -2;
		} else {
			plainteDao.save(plainte);
			return 1;
		}
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
}

package com.schms.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schms.dao.ProfessorDao;
import com.schms.domain.Professor;
import com.schms.service.ProfessorService;


@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	
	@Autowired
	private ProfessorDao professorDao;

	@Override
	public Professor findById(Long id) {
		return professorDao.findOne(id);
	}

	@Override
	public Professor findByName(String name) {
		return professorDao.findByName(name);
	}

	@Override
	public Professor findByEmail(String email) {
		return professorDao.findByEmail(email);
	}

	@Override
	public void save(Professor professor) {
		professorDao.save(professor);
	}

	@Override
	public void delete(Long id) {
		professorDao.delete(id);
	}

	@Override
	public List<Professor> getProfessors() {
		return (List<Professor>)professorDao.findAll();
	}

}

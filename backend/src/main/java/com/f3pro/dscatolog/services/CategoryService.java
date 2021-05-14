package com.f3pro.dscatolog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f3pro.dscatolog.entities.Category;
import com.f3pro.dscatolog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	//listar todas as categorias no banco de dado.
	public List<Category> findAll() {
		return repository.findAll();

	}

}

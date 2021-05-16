package com.f3pro.dscatolog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.f3pro.dscatolog.dto.CategoryDTO;
import com.f3pro.dscatolog.entities.Category;
import com.f3pro.dscatolog.repositories.CategoryRepository;
import com.f3pro.dscatolog.services.exceptions.EntityNotFoundExeption;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	// listar todas as categorias no banco de dado.

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {

		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()-> new EntityNotFoundExeption("Objeto não encontrado "));
		return new CategoryDTO(entity);
	}
	@Transactional(readOnly = true)
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity =repository.save(entity);
		return new CategoryDTO(entity);
	}

}

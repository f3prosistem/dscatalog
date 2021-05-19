package com.f3pro.dscatolog.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.f3pro.dscatolog.dto.ProductDTO;
import com.f3pro.dscatolog.entities.Product;
import com.f3pro.dscatolog.repositories.ProductRepository;
import com.f3pro.dscatolog.services.exceptions.DatabaseExeption;
import com.f3pro.dscatolog.services.exceptions.ResourceNotFoundExeption;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	// listar todas as categorias no banco de dado.

	@Transactional(readOnly = true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {
		Page<Product> list = repository.findAll(pageRequest);
		return list.map(x -> new ProductDTO(x));

	}

	@Transactional(readOnly = true)
	public ProductDTO findById(Long id) {

		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundExeption("Objeto não encontrado "));
		return new ProductDTO(entity, entity.getCategories());
	}

	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		//entity.setName(dto.getName());
		entity = repository.save(entity);
		return new ProductDTO(entity);
	}

	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = repository.getOne(id);
		//	entity.setName(dto.getName());
			entity = repository.save(entity);
			return new ProductDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExeption("Não encontrado Id: " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundExeption("Não encontrado Id: " + id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseExeption("Violação de integridade");
		}
	}

}

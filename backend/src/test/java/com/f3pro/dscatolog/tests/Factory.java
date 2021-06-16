package com.f3pro.dscatolog.tests;

import java.time.Instant;

import com.f3pro.dscatolog.dto.ProductDTO;
import com.f3pro.dscatolog.entities.Category;
import com.f3pro.dscatolog.entities.Product;

public class Factory {

	public static Product createProduct() {
		Product product = new Product(1L, "Phone", "Goog phone", 800.0, "http://img.teste",
				Instant.parse("2021-03-14T10:00:00Z"));
		product.getCategories().add(createCategory());
		return product;
	}

	public static ProductDTO createProductDTO() {
		Product product = createProduct();
		return new ProductDTO(product, product.getCategories());
	}
	public static Category createCategory(){
		return new Category(1L,"Eletronics");
	}
}

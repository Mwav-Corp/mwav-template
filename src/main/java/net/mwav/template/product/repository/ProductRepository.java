package net.mwav.template.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.mwav.template.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByIdAndIsActive(long id, boolean isActive);
	
}

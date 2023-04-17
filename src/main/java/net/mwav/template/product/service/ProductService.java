package net.mwav.template.product.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.mwav.template.product.entity.Product;
import net.mwav.template.product.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public List<Product> findProducts(List<Long> items) {
		List<Product> products = productRepository.findAllById(items);
		return products;
	}

	@Transactional(rollbackFor = Exception.class)
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

}

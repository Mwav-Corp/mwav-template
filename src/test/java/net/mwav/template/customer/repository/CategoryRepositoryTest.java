package net.mwav.template.customer.repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import net.mwav.template.product.entity.Category;
import net.mwav.template.product.repository.CategoryRepository;

@DataJpaTest
@Slf4j
class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	void jpqlTest() {
		Category category = categoryRepository.findById(Long.valueOf(1)).orElseThrow(EntityNotFoundException::new);
		log.debug(category.getCategoryProducts().toString());
	}

	@Test
	void jpaTest() {
		List<Category> category = categoryRepository.findAll();
		log.debug(category.get(0).getCategoryProducts().toString());
	}
}

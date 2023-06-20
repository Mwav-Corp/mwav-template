package net.mwav.template.customer.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import lombok.extern.slf4j.Slf4j;
import net.mwav.template.global.config.QueryDslConfig;
import net.mwav.template.product.entity.Category;
import net.mwav.template.product.repository.CategoryRepositoryCustom;

@DataJpaTest
@Import({ CategoryRepositoryCustom.class, QueryDslConfig.class })
@Slf4j
class CategoryRepositoryCustomTest {

	@Autowired
	private CategoryRepositoryCustom categoryRepositoryCustom;

	@Test
	void test() {
		Category category = categoryRepositoryCustom.findById(Long.valueOf(1));
		log.debug(category.toString());
	}

}

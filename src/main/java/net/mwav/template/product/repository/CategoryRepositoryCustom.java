package net.mwav.template.product.repository;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import net.mwav.template.product.entity.Category;
import static net.mwav.template.product.entity.QCategory.*;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	public Category findById(Long id) {
		return queryFactory.select(category)
			.from(category)
			.leftJoin(category.categoryProducts)
			.fetchJoin()
			.where((category.id.eq(id)))
			.fetchOne();
	}

}

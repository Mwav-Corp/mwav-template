package net.mwav.template.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import net.mwav.template.product.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	List<Category> findAllByIsActive(boolean isActive);

	@Query("SELECT DISTINCT c FROM Category c JOIN FETCH c.products WHERE c.id = :id")
	Optional<Category> findById(@Param("id") Long id);

}

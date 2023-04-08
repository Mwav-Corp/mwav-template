package net.mwav.template.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import net.mwav.template.product.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findAllByIsActive(boolean isActive);

}

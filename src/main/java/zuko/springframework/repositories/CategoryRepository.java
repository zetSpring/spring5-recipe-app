package zuko.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import zuko.springframework.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository <Category, Long> {

    Optional<Category> findByCategoryName(String categoryName);
}

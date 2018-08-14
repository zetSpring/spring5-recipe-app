package zuko.springframework.repositories;

import org.springframework.data.repository.CrudRepository;
import zuko.springframework.domain.Recipe;

public interface RecipeRepository extends CrudRepository <Recipe, Long> {

}

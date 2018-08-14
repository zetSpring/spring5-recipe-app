package zuko.springframework.bootstrap;

import lombok.Data;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import zuko.springframework.domain.*;
import zuko.springframework.repositories.CategoryRepository;
import zuko.springframework.repositories.RecipeRepository;
import zuko.springframework.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Data
public class RecipeBootstrap implements ApplicationListener <ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent (ContextRefreshedEvent contextRefreshedEvent)
    {
        recipeRepository.saveAll(getRecipes());
    }


    private List<Recipe> getRecipes(){
        List <Recipe> recipes = new ArrayList<>(2);

        Optional <UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByUom("Each");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM Not found each");
        }

        Optional <UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByUom("Tablespoon");

        if (!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found table");
        }

        Optional <UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByUom("Teaspoon");

        if (!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found tea");
        }

        Optional <UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByUom("Dunce");

        if (!dashUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found dunce");
        }

        Optional <UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByUom("Pinch");

        if (!pintUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found pinch");
        }

        Optional <UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByUom("Cup");

        if (!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found cup");
        }

        //get optionals

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaspoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = pintUomOptional.get();
        UnitOfMeasure cupUom = cupUomOptional.get();

        //get Categories

        Optional <Category> americanCategoryOptional = categoryRepository.findByCategoryName("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found");
        }

        Optional <Category> mexicanCategoryOptional = categoryRepository.findByCategoryName("Mexican");

        if(!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected Category Not Found");
        }

        //get categories

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(0);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirection("TBC");

        //add notes
        Notes guacNotes = new Notes();
        guacNotes.setNotes("TBC");

        //guacNotes.setRecipe(guacRecipe);

        //setNotes
        guacRecipe.setNotes(guacNotes);

        //set ingredients
        guacRecipe.addIngredients(new Ingredient("Ripe Avocados", new BigDecimal(2), eachUom));
        guacRecipe.addIngredients(new Ingredient("Kosher salt", new BigDecimal(5), teaspoonUom));
        guacRecipe.addIngredients(new Ingredient("Fresh lime juice or lemon juice", new BigDecimal(2), tableUom));
        guacRecipe.addIngredients(new Ingredient("Minced red onion or thinly sliced green onion", new BigDecimal(3), tableUom));
        guacRecipe.addIngredients(new Ingredient("Serrano chiles, stems, and seeds removed, minced", new BigDecimal(2), tableUom));
        guacRecipe.addIngredients(new Ingredient("Cilantro", new BigDecimal(2), tableUom));
        guacRecipe.addIngredients(new Ingredient("Freshly grated black pepper", new BigDecimal(2), tableUom));
        guacRecipe.addIngredients(new Ingredient("Ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), tableUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        recipes.add(guacRecipe);


        return recipes;

    }




}

package zuko.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setCategory(){
        category = new Category();
    }

    @Test
    public void getId() {
        Long setID = 5L;

        category.setId(setID);
        assertEquals(setID, category.getId());
    }

    @Test
    public void getCategoryName() {
        String setCatName = "Dobolo";
        //String setCatName2 = "African";

        category.setCategoryName(setCatName);
        assertEquals(setCatName, category.getCategoryName());
    }

    @Test
    public void getRecipes() {
    }
}
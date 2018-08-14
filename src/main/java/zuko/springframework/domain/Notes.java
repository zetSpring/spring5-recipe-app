package zuko.springframework.domain;

import javax.persistence.*;


@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String notes;

    @OneToOne
    private Recipe recipe;

    public Notes() {
    }

    public long getId() {
        return this.id;
    }

    public String getNotes() {
        return this.notes;
    }

    public Recipe getRecipe() {
        return this.recipe;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}

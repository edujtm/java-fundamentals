package exercises.lesson3;


import java.io.Serializable;

public class Recipe implements Serializable {

    private String name;
    private int ingredients;
    private int steps;

    public Recipe(String name, int ingredients, int steps) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIngredients() {
        return ingredients;
    }

    public void setIngredients(int ingredients) {
        this.ingredients = ingredients;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

}


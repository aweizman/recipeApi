package us.weizman.adam.recipeApi.db;

import java.util.List;
import java.util.UUID;

public interface RecipeDao {
  List<DbRecipe> listRecipes();

  class DbRecipe {
    public UUID recipeId;
    public String name;
    public String description;
    public String makes;
    public List<DbIngredient> ingredients;
    public List<DbDirection> directions;
  }

  class DbIngredient {
    public UUID ingredientId;
    public String name;
    public List<DbCategory> categories;
  }

  class DbCategory {
    public UUID categoryId;
    public String name;
  }

  class DbDirection {
    public Integer ordinal;
    public String directions;
  }
}

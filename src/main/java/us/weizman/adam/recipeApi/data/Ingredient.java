package us.weizman.adam.recipeApi.data;

import java.util.UUID;
import us.weizman.adam.recipeApi.db.RecipeDao.DbIngredient;

public record Ingredient(
    UUID ingredientId,
    String name
) {
  public Ingredient(DbIngredient dbIngredient) {
    this(dbIngredient.ingredientId, dbIngredient.name);
  }
}

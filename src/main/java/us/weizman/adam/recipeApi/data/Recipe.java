package us.weizman.adam.recipeApi.data;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import us.weizman.adam.recipeApi.db.RecipeDao.DbRecipe;

public record Recipe(
    UUID recipeId,
    String name,
    String description,
    String makes,
    List<Ingredient> ingredients
) {
  public Recipe(DbRecipe dbRecipe) {
    var dbIngredients = Optional.ofNullable(dbRecipe.ingredients).orElseGet(Collections::emptyList);
    var ingredients = dbIngredients.stream().map(Ingredient::new).toList();
    this(dbRecipe.recipeId, dbRecipe.name, dbRecipe.description, dbRecipe.makes, ingredients);
  }
}

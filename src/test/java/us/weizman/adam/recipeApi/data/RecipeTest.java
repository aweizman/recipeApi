package us.weizman.adam.recipeApi.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import us.weizman.adam.recipeApi.db.RecipeDao.DbRecipe;

class RecipeTest {
  @Test
  void recipeConstructorHandlesNullDbIngredients() {
    var dbRecipe = new DbRecipe();
    dbRecipe.name = "test";
    var result = new Recipe(dbRecipe);
    Assertions.assertNotNull(result.ingredients());
  }
}

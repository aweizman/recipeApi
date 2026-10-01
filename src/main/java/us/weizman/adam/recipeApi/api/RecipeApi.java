package us.weizman.adam.recipeApi.api;

import java.util.List;
import us.weizman.adam.recipeApi.data.Recipe;

public interface RecipeApi {

  Recipe get();

  RecipeListResponse list();

  record RecipeListResponse(List<Recipe> recipes) {
  }
}

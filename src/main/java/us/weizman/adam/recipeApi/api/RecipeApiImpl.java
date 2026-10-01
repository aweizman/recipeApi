package us.weizman.adam.recipeApi.api;

import com.google.inject.Inject;
import java.util.Objects;
import org.apache.commons.lang3.NotImplementedException;
import us.weizman.adam.recipeApi.data.Recipe;
import us.weizman.adam.recipeApi.db.RecipeDao;

public class RecipeApiImpl implements RecipeApi {

  private final RecipeDao recipeDao;

  @Inject
  public RecipeApiImpl(RecipeDao recipeDao) {
    this.recipeDao = recipeDao;
  }

  @Override
  public Recipe get() {
    throw new NotImplementedException("Not implemented yet");
  }

  @Override
  public RecipeListResponse list() {
    var dbRecipes = recipeDao.listRecipes();
    var mappedRecipes = dbRecipes.stream().filter(Objects::nonNull).map(Recipe::new).toList();

    return new RecipeListResponse(mappedRecipes);
  }
}

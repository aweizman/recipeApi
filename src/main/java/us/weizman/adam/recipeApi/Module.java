package us.weizman.adam.recipeApi;

import com.google.inject.AbstractModule;
import us.weizman.adam.recipeApi.api.RecipeApi;
import us.weizman.adam.recipeApi.api.RecipeApiImpl;
import us.weizman.adam.recipeApi.db.RecipeDao;
import us.weizman.adam.recipeApi.db.RecipeDaoImpl;

public class Module extends AbstractModule {
  @Override
  protected void configure() {
    bind(RecipeApi.class).to(RecipeApiImpl.class);
    bind(RecipeDao.class).to(RecipeDaoImpl.class);
  }
}

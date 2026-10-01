package us.weizman.adam.recipeApi.routegroup;

import static io.github.manusant.ss.descriptor.EndpointDescriptor.endpointPath;

import com.google.inject.Inject;
import io.github.manusant.ss.SparkSwagger;
import io.github.manusant.ss.descriptor.MethodDescriptor;
import io.github.manusant.ss.rest.Endpoint;
import us.weizman.adam.recipeApi.api.RecipeApi;
import us.weizman.adam.recipeApi.api.RecipeApi.RecipeListResponse;
import us.weizman.adam.recipeApi.data.Recipe;
import us.weizman.adam.recipeApi.util.JsonTransformer;

public class RecipeRouteGroup implements Endpoint {
  private static final String NAMESPACE = "/recipe";

  private final RecipeApi recipeApi;

  @Inject
  public RecipeRouteGroup(RecipeApi recipeApi) {
    this.recipeApi = recipeApi;
  }

  @Override
  public void bind(final SparkSwagger restApi) {
    restApi.endpoint(endpointPath(NAMESPACE).withDescription("Recipe Endpoints"))
        .get(MethodDescriptor.path("/list")
            .withDescription("Lists Recipes")
            .withResponseType(RecipeListResponse.class),
            (_, _) -> recipeApi.list(),
            new JsonTransformer()
        )
        .get(MethodDescriptor.path("/:recipeId")
            .withDescription("Gets a recipe")
            .withResponseType(Recipe.class),
            (_, _) -> recipeApi.get(),
            new JsonTransformer());
  }
}

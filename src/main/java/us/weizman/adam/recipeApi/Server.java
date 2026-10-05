package us.weizman.adam.recipeApi;

import com.google.inject.Inject;
import io.github.manusant.ss.SparkSwagger;
import io.github.manusant.ss.conf.Options;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import spark.Service;
import us.weizman.adam.recipeApi.routegroup.RecipeRouteGroup;

public final class Server {

  private static final String VERSION = "version";

  private final RecipeRouteGroup recipeRouteGroup;

  @Inject
  Server(RecipeRouteGroup recipeRouteGroup) {
    this.recipeRouteGroup = recipeRouteGroup;
  }

  public void start() throws IOException {
    var versionProperties = loadVersionProperties();
    var version = versionProperties.getProperty(VERSION);

    var spark = Service.ignite().port(8080);
    SparkSwagger.of(spark, Options.defaultOptions().version(version).build())
        .endpoints(() -> List.of(recipeRouteGroup))
        .generateDoc();
  }

  private Properties loadVersionProperties() throws IOException {
    var properties = new Properties();
    properties.load(this.getClass().getClassLoader().getResourceAsStream("version.properties"));
    return properties;
  }
}

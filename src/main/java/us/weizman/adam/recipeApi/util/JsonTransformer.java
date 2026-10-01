package us.weizman.adam.recipeApi.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {
  private final Gson gson;

  public JsonTransformer() {
    this.gson = new GsonBuilder().create();
  }

  @Override
  public String render(Object model) {
    return gson.toJson(model);
  }
}

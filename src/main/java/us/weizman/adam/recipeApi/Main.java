package us.weizman.adam.recipeApi;

import com.google.inject.Guice;
import java.io.IOException;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import us.weizman.adam.recipeApi.util.MyBatisModule;

public final class Main {
  private Main() {
    throw new UnsupportedOperationException();
  }

  static void main() throws IOException {
    var injector = Guice.createInjector(new Module(), new MyBatisModule(), JdbcHelper.PostgreSQL);
    injector.getInstance(Server.class).start();
  }
}

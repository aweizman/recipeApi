package us.weizman.adam.recipeApi.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.mybatis.guice.XMLMyBatisModule;

public class MyBatisModule extends XMLMyBatisModule {
  @Override
  protected void initialize() {
    setClassPathResource("us/weizman/adam/recipeApi/mybatis-config.xml");

    Properties props = null;
    try {
      props = readSecretPropertiesFile();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    addProperties(props);
  }

  private Properties readSecretPropertiesFile() throws FileNotFoundException {
    var props = new Properties();
    var userHome = System.getProperty("user.home");
    try (var fis = new FileInputStream(userHome + "/.recipeApi/secret.properties")) {
      props.load(fis);
    } catch (IOException _) {
      throw new FileNotFoundException("secret properties file not found");
    }
    return props;
  }
}

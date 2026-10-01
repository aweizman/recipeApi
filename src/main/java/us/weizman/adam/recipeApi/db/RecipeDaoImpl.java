package us.weizman.adam.recipeApi.db;

import com.google.inject.Inject;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class RecipeDaoImpl implements RecipeDao {
  private static final String NAMESPACE = "RecipeDao";

  private final SqlSession sqlSession;

  @Inject
  public RecipeDaoImpl(SqlSession sqlSession) {
    this.sqlSession = sqlSession;
  }

  @Override
  public List<DbRecipe> listRecipes() {
    return sqlSession.selectList(NAMESPACE + ".listRecipes");
  }
}

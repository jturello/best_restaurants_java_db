import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

public class CuisineTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
      assertEquals(Cuisine.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfTypesAreTheSame() {
    Cuisine firstCuisine = new Cuisine("American");
    Cuisine secondCuisine = new Cuisine("American");
    assertTrue(firstCuisine.equals(secondCuisine));
  }

  @Test
  public void equals_savesIntoDatabase_true() {
    Cuisine newCuisine = new Cuisine("Nepali");
    newCuisine.save();
    assertTrue(newCuisine.all().get(0).equals(newCuisine));
  }

  @Test
  public void find_findCuisineInDatabase_true() {
    Cuisine newCuisine = new Cuisine("Nepali");
    newCuisine.save();
    assertTrue(newCuisine.all().get(0).equals(newCuisine));
  }

}

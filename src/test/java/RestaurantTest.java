import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class RestaurantTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
      assertEquals(Restaurant.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfTNamesAndCuisineIdsAreTheSame() {
    Restaurant firstRestaurant = new Restaurant("SameName", 1);
    Restaurant secondRestaurant = new Restaurant("SameName", 1);
    assertTrue(firstRestaurant.equals(secondRestaurant));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Restaurant myRestaurant = new Restaurant("someName", 1);
    myRestaurant.save();
    assert(Restaurant.all().get(0).equals(myRestaurant));
  }

  public void find_findsRestaurantInDatabase_true() {
    Restaurant myRestaurant = new Restaurant("someName", 1);
    myRestaurant.save();
    Restaurant savedRestaurant = Restaurant.find(myRestaurant.getId());
    assertEquals(savedRestaurant, myRestaurant);
  }


}

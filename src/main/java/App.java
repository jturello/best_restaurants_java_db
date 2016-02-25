import java.util.*;

import java.util.Map;
import java.util.HashMap;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      List<Restaurant> restaurants = Restaurant.all();

      if (restaurants == null) {
        restaurants = new ArrayList<Restaurant>();
        request.session().attribute("restaurants", restaurants);
      }

      model.put("restaurants", restaurants);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    /******************************************************
    Students: TODO: Create page to add a new restaurant
    *******************************************************/
    get("/restaurants/new", (request, reponse) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      List<Cuisine> cuisines = Cuisine.all();

      if (cuisines == null) {
        cuisines = new ArrayList<Cuisine>();
        request.session().attribute("cuisines", cuisines);
      }

      model.put("cuisines", cuisines);
      model.put("template", "templates/newrestaurant.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    /******************************************************
    STUDENTS:
    TODO: Create page to display information about the selected restaurant
    TODO: Create page to display restaurants by cuisine type
    *******************************************************/

  }
}

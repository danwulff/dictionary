import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

  public static void main (String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/word/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Word newWord = new Word(word);
      model.put("template", "templates/word-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());




    get("word/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("word/:id/definition/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word-definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/tasks", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));
    //
    //   String description = request.queryParams("description");
    //   Task newTask = new Task(description);
    //
    //   category.addTask(newTask);
    //
    //   model.put("category", category);
    //   model.put("template", "templates/category-tasks-success.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

  }
}

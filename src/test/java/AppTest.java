import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void categoryIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#name").with("Word");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void categoryIsDisplayedTest() {
    goTo("http://localhost:4567/word/new");
    fill("#name").with("Word");
    submit(".btn");
    click("a", withText("View Words"));
    assertThat(pageSource()).contains("Word");
  }

  @Test
  public void categoryShowPageDisplaysName() {
    goTo("http://localhost:4567/word/new");
    fill("#name").with("Word");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Word"));
    assertThat(pageSource()).contains("Word");
  }

  @Test
  public void categoryTasksFormIsDisplayed() {
    goTo("http://localhost:4567/word/new");
    fill("#name").with("Word");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Word"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to Word");
  }

  @Test
  public void tasksIsAddedAndDisplayed() {
    goTo("http://localhost:4567/word/new");
    fill("#name").with("Word");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Word"));
    click("a", withText("Add a new definition"));
    fill("#description").with("a single distinct meaningful element of speech or writing");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Word"));
    assertThat(pageSource()).contains("a single distinct meaningful element of speech or writing");
  }

}

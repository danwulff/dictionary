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
  public void wordIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("Something");
    submit(".btn");
    assertThat(pageSource()).contains("Your word has been saved.");
  }

  @Test
  public void wordIsDisplayedTest() {
    goTo("http://localhost:4567/word/new");
    fill("#word").with("Something");
    submit(".btn");
    click("a", withText("View Words"));
    assertThat(pageSource()).contains("Something");
  }

  @Test
  public void wordsShowPageDisplaysWord() {
    goTo("http://localhost:4567/word/new");
    fill("#word").with("Something");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Something"));    //somehow fluentlenium doesn't like this line. Strange since above test passed
    assertThat(pageSource()).contains("definitions:");
  }

  @Test
  public void wordDefinitionFormIsDisplayed() {
    goTo("http://localhost:4567/word/new");
    fill("#word").with("Something");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Something"));
    click("a", withText("Add a new definition"));
    assertThat(pageSource()).contains("Add a definition to Something");
  }

  @Test
  public void definitionIsAddedAndDisplayed() {
    goTo("http://localhost:4567/word/new");
    fill("#word").with("Something");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Something"));
    click("a", withText("Add a new definition"));
    fill("#definition").with("a single distinct meaningful element of speech or writing");
    submit(".btn");
    click("a", withText("View Words"));
    click("a", withText("Something"));
    assertThat(pageSource()).contains("a single distinct meaningful element of speech or writing");
  }

}

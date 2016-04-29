import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @After
  public void tearDown() {
    //to be added
  }

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("To state or set forth meaning");
    assertEquals(true, myDefinition instanceof Definition);
  }
}

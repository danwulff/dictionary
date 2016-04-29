import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  @After
  public void tearDown() {
    Definition.clear();
  }

  @Test
  public void Definition_instantiatesCorrectly_true() {
    Definition myDefinition = new Definition("To state or set forth meaning");
    assertEquals(true, myDefinition instanceof Definition);
  }

  @Test
  public void getDefinition_instantiatesWithDescription_String() {
    Definition myDefinition = new Definition("To state or set forth meaning");
    assertEquals("To state or set forth meaning", myDefinition.getDefinition());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_True() {
    Definition.clear();
    Definition testDefinition1 = new Definition("To state or set forth meaning");
    Definition testDefinition2 = new Definition("An explanation of the meaning of words");
    assertTrue(Definition.all().contains(testDefinition1));
    assertTrue(Definition.all().contains(testDefinition2));
  }

  @Test
  public void clear_emptiesAllDefinitionsFromArrayList_0() {
    Definition testDefinition1 = new Definition("To state or set forth meaning");
    Definition testDefinition2 = new Definition("An explanation of the meaning of words");
    Definition.clear();
    assertEquals(0, (Definition.all()).size());
  }
}

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {

  }

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("To state or set forth meaning");
    assertEquals(true, myWord instanceof Word);
  }

}

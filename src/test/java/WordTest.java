import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {

  }

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("word");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void getWord_instantiatesWithWord_String() {
    Word myWord = new Word("word");
    assertEquals("word", myWord.getWord());
  }

  @Test
  public void all_returnsAllInstancesOfWord_ArrayList() {
    Word testWord1 = new Word("word");
    Word testWord2 = new Word("another");
    assertTrue(Word.all().contains(testWord1));
    assertTrue(Word.all().contains(testWord2));
  }

  @Test
  public void clear_emptiesAllWordsFromArrayList_0() {
    Word testWord1 = new Word("word");
    Word testWord2 = new Word("another");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

}

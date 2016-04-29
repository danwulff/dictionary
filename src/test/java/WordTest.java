import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.clear();
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

  @Test public void getId_wordsInstantiateWithAnId_1() {
    Word testWord = new Word("word");
    assertEquals(1, testWord.getId());
  }

  @Test public void find_returnsWordWithSameId_secondWord () {
    Word firstWord = new Word("word");
    Word secondWord = new Word("another");
    assertEquals(secondWord, Word.find(secondWord.getId()));
  }

  @Test
  public void find_returnsNullWhenNoCategoryFound_null() {
    assertEquals(null, Word.find(999));
  }



  //tests with definition logic

  @Test public void getDefinitions_initiallyReturnsEmptyList_0() {
    Word testWord = new Word("word");
    assertEquals(0, testWord.getDefinitions().size());
  }


  @Test public void addDefinition_addsDefinitionToList_true() {
    Word testWord = new Word("word");
    Definition testDefinition = new Definition("a single distinct meaningful element of speech or writing");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

}

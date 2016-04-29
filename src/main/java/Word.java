import java.util.ArrayList;

public class Word {
  private String mWord;
  private static ArrayList<Word> instances = new ArrayList<Word>();

  public Word(String word) {
    mWord = word;
    instances.add(this);
  }

  public String getWord() {
    return mWord;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}

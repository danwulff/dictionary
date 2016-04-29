import java.util.ArrayList;

public class Word {
  private String mWord;
  private ArrayList<Definition> mDefinitions = new ArrayList<Definition>();
  private static ArrayList<Word> instances = new ArrayList<Word>();

  public Word(String word) {
    mWord = word;
    instances.add(this);
  }

  public String getWord() {
    return mWord;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public ArrayList<Definition> getDefinitions() {
    return mDefinitions;
  }

  public static ArrayList<Word> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

}

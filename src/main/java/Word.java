import java.util.ArrayList;

public class Word {
  private String mWord;
  private int mId;
  private ArrayList<Definition> mDefinitions = new ArrayList<Definition>();
  private static ArrayList<Word> instances = new ArrayList<Word>();

  public Word(String word) {
    mWord = word;
    instances.add(this);
    mId = instances.size();
  }

  public String getWord() {
    return mWord;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public int getId() {
    return mId;
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

  public static Word find(int id) {
    try {
      return instances.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }

  }

}

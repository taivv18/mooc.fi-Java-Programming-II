import java.util.ArrayList;
import java.util.HashMap;

public class Program {

  public static void main(String[] args) {
    // Test your program here!
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("f.e", "for example");
    hashMap.put("etc.", "and so on");
    hashMap.put("i.e", "more precisely");

    System.out.println("---");
    printKeys(hashMap);
    System.out.println("---");
    printKeysWhere(hashMap, "i");
    System.out.println("---");
    printValuesOfKeysWhere(hashMap, ".e");
  }

  public static void printKeys(HashMap<String, String> hashMap) {
    ArrayList<String> key = new ArrayList<>();
    for (String abb : hashMap.keySet()) {
      key.add(abb);
    }

    for (int i = key.size() - 1; i >= 0; --i) {
      System.out.println(key.get(i));
    }
  }

  public static void printKeysWhere(HashMap<String, String> hashMap, String word) {
    for (String abb : hashMap.keySet()) {
      if (abb.contains(word)) {
        System.out.println(abb);
      }
    }
  }

  public static void printValuesOfKeysWhere(HashMap<String, String> hashMap, String text) {
    ArrayList<String> key = new ArrayList<>();
    for (String abb : hashMap.keySet()) {
      if (abb.contains(text)) {
        key.add(hashMap.get(abb));
      }
    }

    for (int i = key.size() - 1; i >= 0; --i) {
      System.out.println(key.get(i));
    }
  }
}

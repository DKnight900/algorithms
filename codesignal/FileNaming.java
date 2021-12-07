package codesignal;

import java.util.*;

public class FileNaming {
  public static void main(String[] args) {

    String[] names = {"doc", "doc", "image", "doc(1)", "doc"};
//    String[] names = {"a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"};
    Arrays
      .stream(fileNaming(names))
      .forEach(System.out::println);
  }

  private static String[] fileNaming(String[] names) {
    Map<String, Integer> fileNames = new LinkedHashMap<>();
    for (int i  = 0; i < names.length; i++) {
      if (fileNames.containsKey(names[i])) {
        for (int j = fileNames.get(names[i]); j <= i; j++) {
          if (!fileNames.containsKey(names[i] + "(" + j + ")")) {
            fileNames.put(names[i] + "(" + j + ")", 1);
            break;
          }
        }
      }
      else {
        fileNames.put(names[i], 1);
      }
    }

    return fileNames
      .keySet()
      .stream()
      .toArray(String[]::new);
  }
}

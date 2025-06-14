import java.util.Scanner;
import java.util.HashMap;

public class ScoresHashMap {
  public static void main(String[] args) {
    // HashMap holds key-value pairs. 
    // The key (user ID) is a String (case sensitive).
    // The value (score) is an Integer (int)
    HashMap<String, Integer> scores = new HashMap<>();
    scores.put("ssmith", 88);
        scores.put("tlang01", 100);
    scores.put("glewis03", 99);
    System.out.println("Scores: " + scores.toString());

    java.util.Scanner input = new Scanner(System.in);

    System.out.print("Enter an ID: ");
    String id = input.nextLine();
    // Check if the HashMap contains the key (id)
    if (scores.containsKey(id)) {
    // Only safe to use get() to retrieve value if key exists in HashMap
      int score = scores.get(id);
      System.out.println(id + " has a score of " + score + ".");
    }
    else {
      System.out.println("There is no score for " + id + ".");
    }
  }
}
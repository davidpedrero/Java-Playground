import java.util.ArrayList;

class ArrayListScores {
  public static void main(String[] args) {
    ArrayList<Integer> scores = new ArrayList<>();
    scores.add(99);
    scores.add(88);
    scores.add(100);
    scores.add(85);
    System.out.println("First score: " + scores.get(0));
    int listLength = scores.size();
    System.out.println("Last scores: " + scores.get(listLength - 1));
  }
}
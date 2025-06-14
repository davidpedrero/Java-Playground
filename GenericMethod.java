import java.util.Arrays;

public class GenericMethod {
  public static <T> T getMidPointItem(T[] array) {
    return array[array.length / 2];
  }

  public static void main(String[] args) {
    String[] names = {"Ann", "George", "Kim", "Pat", "Steve"};
    String midPointName = getMidPointItem(names);
    System.out.print("The middle item in the array " + Arrays.toString(names));
    System.out.println(" is: " + midPointName + ".");

    Character[] letters = {'a', 'b', 'c'};
    char midPointLetter = getMidPointItem(letters);
    System.out.print("The middle item in the array " + Arrays.toString(letters));
    System.out.println(" is: " + midPointLetter + ".");
  }
}
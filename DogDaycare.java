import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DogDaycare {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    // Displaying menu options
    System.out.println("Hi, Welcome to Lucky Daycare!");
    System.out.println("How can we help you today?");
    System.out.println("1. Check in new dog");
    System.out.println("2. Check in returning dog");
    System.out.println("3. Check out dog");
    System.out.println("4. Get dog data");

    // Initilializing option and isValid variables with default values
    int option = 0;
    boolean isValid = false;

    // While loop that checks if user input is valid
    // User input is valid if it is between 1 and 4 and an integer
    while (!isValid) {
      try {
        System.out.print("Select an option from the menu: ");
        option = input.nextInt();

        // If user is between 1 and 4, exit while loop
        // Else print error message and prompt user to try again
        if (1 <= option && option <= 4) {
          isValid = true;
        } 
        else {
          System.out.println("Invalid input. Please enter a number between 1 and 4:");
        }
      } 
      catch (InputMismatchException ex) {
        System.out.println("Error reading input: " + ex.getMessage());
        input.nextLine(); // Clear input buffer
        System.out.println("Invald integer entered.");
      }
    }

    // Logic that calls the appropriate method based on user input
    if (option == 1) {
      checkInNewDog();
    } 
    else if (option == 2) {
      checkinReturningDog();
    } 
    else if (option == 3) {
      checkOutDog();
    }
    else if (option == 4) {
      getDogData();
    }
  }

  // Method that checks in a new dog
  public static void checkInNewDog() {
    System.out.println("You selected check in new dog.");

    // Creating scanner object to read user input
    Scanner input = new Scanner(System.in);

    // Prompting the user to input dog's name
    System.out.print("Enter dog's name: ");
    String name = input.nextLine();

    // Prompting the user to input dog's breed
    System.out.print("Enter dog's breed: ");
    String breed = input.nextLine();

    // Initializing age variable
    int age = 0;
    
    // Initializing while condition variable
    boolean isValid = false;

    // While loop that checks if user inputed dog age is valid
    while (!isValid) {
      try {
      // Prompting the user to input dog's age
        System.out.print("Enter dog's age: ");
        age = input.nextInt();

        // If input value does not error out, exit while loop
        isValid = true;
      } 
      catch (InputMismatchException ex) {
        System.out.println("Error reading input: " + ex.getMessage());
        input.nextLine(); // Clear input buffer
        System.out.println("Invald integer entered.");
      }
    }
    
    // New dog's id variable is one more than the length of rows
    String id = getNewDogId();

    // Instantiating new Dog object for this dog
    Dog newDog = new Dog(id, name, breed, age);

    // Inserting new dog profile into dog profiles database
    writeDogProfile(newDog);

    // Inserting new visit record into dog daycare logs
    writeDaycareLog(newDog, "CHECKED IN");

    // Print success message
    System.out.println("Successfully checked in " + newDog.getName() +"!");

    // Print dog's id
    System.out.println("Record this dog id for future use: " + newDog.getId());
  }

  // Method that checks in a dog that already exists in our database
  public static void checkinReturningDog() {
    System.out.println("You selected check in returning dog.");

    Scanner input = new Scanner(System.in);

    // Initiating dog id variable
    String id = "";

    // Initializing while loop condition
    boolean isValid = false;

    while (!isValid) {
      // Prompting the user for input (dog id)
      System.out.print("Enter dog's id: ");
      id = input.nextLine();
        
      // Looking up dog id in dog profiles file
      // If dog id exists, return true
      isValid = lookupDogId(id);
      
      if (!isValid) {
        System.out.println("Invald dog id entered.");
        input.nextLine(); // Clear input buffer
      }
    }

    // Getting an array of strings containing the desired dog's profile details
    String[] dogProfile = getDogProfile(id);

    // Instantiating new Dog object for this dog
    Dog returningDog = new Dog(id, dogProfile[1], dogProfile[2], Integer.parseInt(dogProfile[3]));
    
    // Inserting new visit record into dog daycare logs
    writeDaycareLog(returningDog, "CHECKED IN");

    // Print success message
    System.out.println("Successfully checked in " + returningDog.getName() + "!");
  }

  // Method that checks out a dog
  public static void checkOutDog() {
    System.out.println("You selected check out dog.");
    
    Scanner input = new Scanner(System.in);

    // Initiating dog id variable
    String id = "";

    // Initializing while loop condition
    boolean isValid = false;

    while (!isValid) {
        // Prompting the user for input (dog id)
        System.out.print("Enter dog's id: ");
        id = input.nextLine();

        // Looking up dog id in dog profiles file
        // If dog id exists, return true
        isValid = lookupDogId(id);

        if (!isValid) {
          System.out.println("Invald dog id entered.");
          input.nextLine(); // Clear input buffer
        }
    }

    // Getting an array of strings containing the desired dog's profile details
    String[] dogProfile = getDogProfile(id);

    Dog returningDog = new Dog(id, dogProfile[1], dogProfile[2], Integer.parseInt(dogProfile[3]));

    // Inserting new visit record into dog daycare logs
    writeDaycareLog(returningDog, "CHECKED OUT");

    // Print success message
    System.out.println("Successfully checked out " + returningDog.getName() + "!");
  }

  // Method that gets a dog's profile
  public static void getDogData() {
    System.out.println("You selected get dog data.");

    Scanner input = new Scanner(System.in);

    // Initiating dog id variable
    String id = "";

    // Initializing while loop condition
    boolean isValid = false;

    while (!isValid) {
        // Prompting the user for input (dog id)
        System.out.print("Enter dog's id: ");
        id = input.nextLine();

        // Looking up dog id in dog profiles file
        // If dog id exists, return true
        isValid = lookupDogId(id);

        if (!isValid) {
          System.out.println("Invald dog id entered.");
          input.nextLine(); // Clear input buffer
        }
    }

    // Getting an array of strings containing the desired dog's profile details
    String[] dogProfile = getDogProfile(id);

    // Printing dog profile
    System.out.println("Dog name: " + dogProfile[1]);
    System.out.println("Dog breed: " + dogProfile[2]);
    System.out.println("Dog age: " + dogProfile[3]);
  }

  // Method that checks if a dog id exists in our dog profiles database
  public static boolean lookupDogId(String id) {
    // Initializing a list of strings where we will insert csv rows
    List<String> rows = new ArrayList<>();

    File file = new File("dog_profiles.csv");

    try {
    // Getting returning dog's profile from database
      rows = Files.readAllLines(file.toPath());
    } 
    catch (IOException ex) {
      System.out.println("Error accessing file: " + ex.getMessage());
    }

    // Initializing return value
    boolean idFound = false;

    // Loop through list to check if dog id exists in file
    for (String row : rows) {
      // Look for dog id
      if (row.contains(id)) {
        // If dog id is found, return true
          idFound = true;
      }
      // Else return false
    }

    return idFound;
  }

  // Method that generates a new unique dog id
  public static String getNewDogId() {
    int count = 0;

    try {
      File file = new File("dog_profiles.csv");

      // Getting a list of strings from the csv file
      List<String> rows = Files.readAllLines(file.toPath());

      // Iterating through the list of strings to get the number of rows
      for (int i = 0; i < rows.size(); i++) {
        count++;
      }
    } 
    catch (IOException ex) {
      System.out.println("Error accessing file: " + ex.getMessage());
    }

    // Adding 1 to the count to get the next dog id
    count += 1;

    return "d_" + count;
  }

  // Method that gets the desired dog's profile dog profiles database
  public static String[] getDogProfile(String id) {
    String[] dogProfile = {""};

    // Initializing a list of strings where we will insert csv rows
    List<String> rows = new ArrayList<>();

    try {
      File file = new File("dog_profiles.csv");

      // Getting a list of strings from the csv file
      rows = Files.readAllLines(file.toPath());
    } 
    catch (IOException ex) {
      System.out.println("Error accessing file: " + ex.getMessage());
    }

    // Loop through list to find dog profile
    for (String row : rows) {
      if (row.contains(id)) {
        // Split row into array of strings
        dogProfile = row.split(",");
      }
    }

    return dogProfile;
  }

  // Method that adds a new record to dog profiles database
  public static void writeDogProfile(Dog dog) {
    ArrayList<String> newDogProfile = new ArrayList<String>();

    // Concatinating dog properties into comma seperated string
    String row = dog.getId() + "," + dog.getName() + "," + dog.getBreed() + "," + dog.getAge();

    // Adding row string into newDogProfile arraylist
    newDogProfile.add(row);

    File file = new File("dog_profiles.csv");

    try {
      // Writing new dog profile into csv file
      Files.write(file.toPath(), newDogProfile, StandardOpenOption.APPEND);
    } 
    catch (IOException ex) {
      System.out.println("Error writing to file: " + ex.getMessage());
    }
  }

  // Method that adds a new record to dog daycare logs
  public static void writeDaycareLog(Dog dog, String action) {
    ArrayList<String> newDaycareLog = new ArrayList<String>();

    // Initializing check in time variable and setting it equal to formatted timestamp
    DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
    String newTimeStamp = dateTimeFormat.format(LocalDateTime.now());

    // Concatinating dog properties into comma seperated string
    String row = dog.getId() + "," + dog.getName() + "," + newTimeStamp + "," + action;

    File file = new File("daycare_logs.csv");

    // Adding row string into newDaycareLog arraylist
    newDaycareLog.add(row);

    try {
      // Writing new visit record to dog daycare logs
      Files.write(file.toPath(), newDaycareLog, StandardOpenOption.APPEND);
    } 
    catch (IOException ex) {
      System.out.println("Error writing to file: " + ex.getMessage());
    }
  }
}
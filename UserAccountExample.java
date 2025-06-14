// class UserAccountExample {
//   public static void main(String[] args) {
//     UserAccount account = new UserAccount("sophia", "hello123");

//     System.out.println("User name: " + account.getUserName());
//     System.out.println("Is active user: " + account.getActiveUser());
//     System.out.println("Date joined: " + account.getDateJoined());
//   }
// }

public class UserAccountExample {
  public static void main(String[] args) {
    UserAccount account = new UserAccount("Sophia2", "TestTest123");
    System.out.println("Results from calling account.toString()");
    System.out.println(account.toString());
  }
}
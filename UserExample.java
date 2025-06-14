class UserExample {
  public static void main(String[] args) {
    User account = new User("sophia", "mypass");
    System.out.println("Account created for " + account.getUserName());
  }
}
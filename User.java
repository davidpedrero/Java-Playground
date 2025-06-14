public class User extends Member {
  public User(String firstName, String lastName) {
    super(firstName, lastName);
  }

  @Override
  public String getStatus() { 
    return getFirstName() + " " + getLastName() + " is an User."; 
  }
}
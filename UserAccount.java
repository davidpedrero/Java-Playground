import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserAccount {
  private String userName;
  private String password;
  private LocalDate dateJoined = LocalDate.now();
  private boolean activeUser = true;

  public UserAccount(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public LocalDate getDateJoined() {
    return dateJoined;
  }

  public boolean isActiveUser() {
    return activeUser;
  }

  public void setActiveUser(boolean activeUser) {
    this.activeUser = activeUser;
  }

  public boolean checkCredentials(String userName, String password) {
    return this.userName.equals(userName) && this.password.equals(password);
  }

  public String toString() {
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/YYYY");
    String state = "UserName: " + userName + "\n";
    state += "password: " + password + "\n";
    state += "dateJoined: " + dateFormat.format(dateJoined) + "\n";
    state += "activeUser: " + activeUser + "\n";
    return state;
  } 
}
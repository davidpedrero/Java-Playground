import java.time.LocalDate;

public class Admin extends Member {
  private int expiryDays = 100 * 365;
  private LocalDate expiryDate;
  private String secret;
  
  public Admin(String firstName, String lastName, String secret) {
    super(firstName, lastName);
    expiryDate = LocalDate.now().plusDays(expiryDays);
    this.secret = secret;
  }

  @Override
  public LocalDate getExpiryDate() {
    return expiryDate;
  }

  public String getSecret() {
    return secret;
  }

  @Override
  public String getStatus() {
    return getFirstName() + " " + getLastName() + " is an Admin.";
  }
}
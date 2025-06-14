public class Dog {
  private String id;
  private String name;
  private String breed;
  private int age;

  public Dog(String id, String name, String breed, int age) {
    this.id = id;
    this.name = name;
    this.breed = breed;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
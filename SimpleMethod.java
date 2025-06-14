class SimpleMethod {
  static String sayHello(String name) {
    return "Hello " + name;
  }

  public static void main(String[] args) {
    String person = "David";

    String greeting = sayHello(person);

    System.out.println(greeting);
  }
}
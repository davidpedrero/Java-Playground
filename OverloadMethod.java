class OverloadMethod {
  public static void main(String[] args) {
    System.out.println("Method call with string: ");
    String result = sayHello("Sophia");
    System.out.println(result);

    System.out.println("Method call with int: ");
    result = sayHello("Sophia", 3);
    System.out.println(result + "\n");
  }

  static String sayHello(String name) {
    return "Hello, " + name;
  }

  static String sayHello(String name, int count) {
    String greeting = "";
    
    for(int i = 0; i < count; i++) {
      greeting += "Hello, " + name + "\n";
    }
    
    return greeting;
  }
}
class CompositionExample {
  public static void main(String[] args) {
    Coffee darkRoastCoffee = new Coffee("dark roast", 20, false, 2.59);
    Tea blackTea = new Tea("black", 16, false, 2.00);

    System.out.println(darkRoastCoffee);
    System.out.println(blackTea);
  }
}
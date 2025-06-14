class InterfaceExample {
  public static void main(String[] args) {
    // Create order and drinks
    DrinkOrder toGoOrder = new DrinkOrder();
    Coffee coffee = new Coffee("dark roast", 20, false, 2.09);
    toGoOrder.add(coffee);
    Tea greenTea = new Tea("green", 16, false, 1.59);
    toGoOrder.add(greenTea);
    Tea blackTea = new Tea("black", 8, true, 1.29);
    toGoOrder.add(blackTea);

    // Number to use for numbered list of drinks in order
    int itemNumber = 1;
    System.out.println("Here's your order: ");
    // getOrder() returns ArrayList<Beverage>
    for(Beverage bev : toGoOrder.getOrder()) {
        System.out.println("\t" + itemNumber++ + ". " + bev);
    }

    System.out.println("\nOrder Total: " + 
    // Note how Beverage.PriceFormat can be used here, too
    Beverage.PriceFormat.format(toGoOrder.getTotalPrice()));
  }
}
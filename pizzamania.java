package ProjectPizzaApp;

import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat.Type;


abstract class pizzaOrder {

    private int price;
    private boolean extraCheese = false;
    private boolean extraToppings = false;
    private boolean takeAway = false;
    private int total;

    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public boolean getExtraCheese(){
        return extraCheese;
    }
    public void setExtraCheese(boolean extraCheese){
        this.extraCheese = extraCheese;
    }

    public boolean getExtraToppings(){
        return extraToppings;
    }
    public void setExtraToppings(boolean extraToppings){
        this.extraToppings = extraToppings;
    }

    public boolean getTakeAway(){
        return takeAway;
    }
    public void setTakeAway(boolean takeAway){
        this.takeAway = takeAway;
    }

    public int getTotal(){
        return total;
    }
    public void setTotal(int total){
        this.total = total;
    }

    abstract void billing();

}

class vegPizza extends pizzaOrder {

    vegPizza(boolean extraCheese, boolean extraToppings, boolean takeAway){
        this.setPrice(300);
        this.setExtraCheese(extraCheese);
        this.setExtraToppings(extraToppings);
        this.setTakeAway(takeAway);
    }

    void billing(){
        int sum = this.getPrice();

        if (this.getExtraCheese()) {
            sum += 100;
        }
        if (this.getExtraToppings()) {
            sum += 150;
        }
        if (this.getTakeAway()) {
            sum += 20;
        }

        this.setTotal(sum);
    }
}

class nonVegPizza extends pizzaOrder {

    nonVegPizza(boolean extraCheese, boolean extraToppings, boolean takeAway){
        this.setPrice(400);
        this.setExtraCheese(extraCheese);
        this.setExtraToppings(extraToppings);
        this.setTakeAway(takeAway);
    }

    void billing(){
        int sum = this.getPrice();

        if (this.getExtraCheese()) {
            sum += 100;
        }
        if (this.getExtraToppings()) {
            sum += 150;
        }
        if (this.getTakeAway()) {
            sum += 20;
        }

        this.setTotal(sum);
    }
}

class deluxVegPizza extends pizzaOrder {

    deluxVegPizza(boolean takeAway){
        this.setPrice(550);
        this.setTakeAway(takeAway);
    }

    void billing(){
        int sum = this.getPrice();

        if (this.getTakeAway()) {
            sum += 20;
        }

        this.setTotal(sum);
    }
}

class deluxNonVegPizza extends pizzaOrder {

    deluxNonVegPizza(boolean takeAway){
        this.setPrice(650);
        this.setTakeAway(takeAway);
    }

    void billing(){
        int sum = this.getPrice();

        if (this.getTakeAway()) {
            sum += 20;
        }

        this.setTotal(sum);
    }
}



public class pizzamania {

    
    
    public static void main(String[] args){

        int choice;
        boolean toppings = false;
        boolean cheese = false;
        boolean takeAway = false;

        System.out.println("------------------------Welcome to Pizzamania----------------------");
        System.out.println("*Please choose your order*\nMenu: (1. Veg Pizza  2. Non-veg Pizza  3. Delux Veg Pizza  4. Delux Non-veg Pizza)");

        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();

        if (choice == 1 || choice == 2) {
            System.out.println("Do you want extra Toppings? (True | False)");
            toppings = sc.nextBoolean();
            System.out.println("Do you want extra Cheese? (True | False)");
            cheese = sc.nextBoolean();
            System.out.println("Do you want take away order? (True | False)");
            takeAway = sc.nextBoolean();
        }else if(choice == 3 || choice == 4){
            System.out.println("Do you want take away order? (True | False)");
            takeAway = sc.nextBoolean();
        }else{
            System.out.println("There was an error selecting the item from given input. Please choose from the available options correctly...");
            System.exit(0);
        }

        switch (choice) {
            case 1:
                vegPizza order1 = new vegPizza(cheese, toppings, takeAway);
                order1.billing();
                System.out.println("\n\nPizza: "+order1.getPrice());
                if (order1.getExtraToppings()) {
                    System.out.println("Extra Toppings: 150");
                }
                if (order1.getExtraCheese()) {
                    System.out.println("Extra Cheese: 100");
                }
                if (order1.getTakeAway()) {
                    System.out.println("Take away: 20");
                }
                System.out.println("\n\nTotal bill: "+order1.getTotal());
                break;

            case 2:
                nonVegPizza order2 = new nonVegPizza(cheese, toppings, takeAway);
                order2.billing();
                System.out.println("\n\nPizza: "+order2.getPrice());
                if (order2.getExtraToppings()) {
                    System.out.println("Extra Toppings: 150");
                }
                if (order2.getExtraCheese()) {
                    System.out.println("Extra Cheese: 100");
                }
                if (order2.getTakeAway()) {
                    System.out.println("Take away: 20");
                }
                System.out.println("\n\nTotal bill: "+order2.getTotal());
                break;

            case 3:
                deluxVegPizza order3 = new deluxVegPizza(takeAway);
                order3.billing();
                System.out.println("\n\nPizza: "+order3.getPrice());
                if (order3.getTakeAway()) {
                    System.out.println("Take away: 20");
                }
                System.out.println("\n\nTotal bill: "+order3.getTotal());
                break;

            case 4:
                deluxNonVegPizza order4 = new deluxNonVegPizza(takeAway);
                order4.billing();
                System.out.println("\n\nPizza: "+order4.getPrice());
                if (order4.getTakeAway()) {
                    System.out.println("Take away: 20");
                }
                System.out.println("\n\nTotal bill: "+order4.getTotal());
                break;
        
            default:
                System.out.println("There was an error selecting the item from given input. Please choose from the available options correctly...");
                break;
        }

        System.out.println("\n\nThankyou for visiting. See you again!");

    }
}
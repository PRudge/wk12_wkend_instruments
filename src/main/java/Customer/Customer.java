package Customer;

import Interfaces.ISell;

import java.util.ArrayList;


public class Customer {

    private String firstName;
    private String lastName;
    protected double wallet;
    private ArrayList<ISell> shoppingBasket;


    public Customer(String firstName, String lastName, double wallet){
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = wallet;
        this.shoppingBasket = new ArrayList<>();

    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public double getWallet(){
        return this.wallet;
    }

    public int countItemsInBasket(){
        return shoppingBasket.size();
    }

    public void addItemToBasket(ISell basketItem){
        this.shoppingBasket.add(basketItem);
    }

    public void removeItemFromBasket(ISell basketItem){
        if (shoppingBasket.size() > 0) {
            this.shoppingBasket.remove(basketItem);
        }
    }

    public ArrayList<ISell> getShoppingBasket(){
        return this.shoppingBasket;

    }

    public boolean checkWallet(int bill)  {

        return (this.wallet > bill)? true:false;

    }

    public void payBill(int bill) {
        this.wallet -= bill;
        this.shoppingBasket.clear();
    }

}


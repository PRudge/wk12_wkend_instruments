package Shop;

import Customer.Customer;
import Interfaces.ISell;

import java.util.ArrayList;

public class Shop {

    private String shopName;
    private ArrayList<ISell> stock;
    private Customer customer;
    private double till;


    public Shop(String shopName, Customer customer, double till){
        this.shopName = shopName;
        this.stock = new ArrayList<>();
        this.customer = customer;
        this.till = till;

    }

    public String getShopName(){
        return this.shopName;
    }

    public ArrayList<ISell> getStock() {
        return this.stock;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public double getTill() {
        return this.till;
    }


    public int countStock(){
        return stock.size();
    }

    public void addItem(ISell stockItem){
        this.stock.add(stockItem);
    }

    public void removeItem(ISell stockItem){
        if (this.stock.size() > 0) {
            this.stock.remove(stockItem);
        }
    }

    public double calculateProfit(){
        double profit = 0;
        for (ISell stockItem : this.stock){
            profit += stockItem.calculateMarkUp(); //calculateMarkUp is the interface method common to all the stock
        }
        return profit;
    }

    public void checkOut(){
        int total;

        ArrayList<ISell> basket = customer.getShoppingBasket();
        total = this.totUpBill(basket);

        if (customer.checkWallet(total)){
            customer.payBill(total); // this empties their shopping basket too
            this.addToTill(total);
            for (ISell item : basket){ // only removes items if enough money to pay
                this.removeItem(item);
            }
        }
    }

    public int totUpBill(ArrayList<ISell> basket){
        int bill = 0;

        for (ISell item : basket){
            bill += item.getSalesPrice();

        }
        return bill;
    }

    public void addToTill(int total){
        this.till += total;
    }
}

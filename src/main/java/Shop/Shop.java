package Shop;

import Customer.Customer;
import Interfaces.ISell;

import java.util.ArrayList;

public class Shop {

    private String shopName;
    private Customer customer;
    private double till;

    private ArrayList<ISell> stock;

    public Shop(String shopName, Customer customer, double till){
        this.shopName = shopName;
        this.customer = customer;
        this.till = till;

        this.stock = new ArrayList<>();
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
            profit += stockItem.calculateMarkUp(); //calculateMarkUp in interface ISell
        }
        return profit;
    }

    public void checkOut(){
        int total;

        ArrayList<ISell> basket = customer.getShoppingBasket();
        total = this.totUpBill(basket);

        if (customer.checkWallet(total)){
            for (ISell item : basket){ // remove item from stock as customer is going to buy
                this.removeItem(item);
            }
            customer.payBill(total); // this empties the customer shopping basket too
            this.addToTill(total);
            for (ISell item : basket){ // only removes items if enough money to pay
                this.removeItem(item);
            }
        }
    }

    public int totUpBill(ArrayList<ISell> basket){
        int bill = 0;

        for (ISell item : basket){
            bill += item.getSalesPrice(); //getSalesPrice in ISell/StockItem

        }
        return bill;
    }

    public void addToTill(int total){
        this.till += total;
    }
}

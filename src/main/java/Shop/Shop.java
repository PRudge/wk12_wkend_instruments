package Shop;

import Customer.Customer;
import Interfaces.ISell;

import java.util.ArrayList;

public class Shop {

    private String shopName;
    private Customer customer;
    private double till;

    private ArrayList<ISell> stock;
    private ArrayList<Customer> customers;

    public Shop(String shopName, int till){
        this.shopName = shopName;
        this.customers = new ArrayList<Customer>();
        this.till = till;

        this.stock = new ArrayList<>();
    }

    public String getShopName(){
        return this.shopName;
    }

    public ArrayList<ISell> getStock() {
        return this.stock;
    }


    public double getTill() { return this.till;
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

    // customer interaction

    public int countCustomers(){
        return this.customers.size();
    }

    public void addCustomer(Customer customer){ //customer enters shop
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer){ //customer leaves after shopping, or not
        this.customers.remove(customer);

    }


    // checkout all the customers - closing time

    public void checkOutQueue(){
        for (Customer customer : this.customers) {
            checkOut(customer);
        }
    }

    public void checkOut(Customer customer){
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

package Shop;

import Interfaces.ISell;

import java.util.ArrayList;

public class Shop {

    private String shopName;
    private ArrayList<ISell> stock;


    public Shop(String shopName){
        this.shopName = shopName;
        this.stock = new ArrayList<>();

    }

    public String getShopName(){
        return this.shopName;
    }

    public int countStock(){
        return stock.size();
    }

    public void addItem(ISell stockItem){
        this.stock.add(stockItem);
    }

    public void removeItem(ISell stockItem){
        if (stock.size() > 0) {
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

}

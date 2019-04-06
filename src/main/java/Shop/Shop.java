package Shop;

import Interfaces.ISell;

import java.util.ArrayList;

public class Shop {

    private String shopName;
    private ArrayList<ISell> stock;
    private ISell stockItem;


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
        this.stock.remove(stockItem);
    }


}

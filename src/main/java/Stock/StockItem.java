package Stock;

import Interfaces.ISell;

public class StockItem implements ISell {

    private String description;
    private double buyPrice;
    private double sellPrice;

    public StockItem(String description, double buyPrice, double sellPrice) {
        this.description = description;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }


    public String getDescription() {
        return description;
    }


    public double getBuyPrice() {
        return buyPrice;
    }


    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double calculateMarkUp(){

        return getSellPrice() - getBuyPrice();

    }
}

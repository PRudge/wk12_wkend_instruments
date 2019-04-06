package Stock.Instruments;

import Interfaces.IPlay;

public class Guitar extends Instrument implements IPlay {

    private int numStrings;

    public Guitar(String description, double buyPrice, double sellPrice, String colour,
                  String material, InstrumentFamily instrumentFamily, int numStrings) {
        super(description, buyPrice, sellPrice, colour, material, instrumentFamily);

        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return this.numStrings;
    }
    public String play(String sound) {
        return "Guitar sound: " + sound;
    }

    public double calculateSalesPrice(){
        double salePriceDiscount = getSellPrice()/5;
        return getSellPrice() - salePriceDiscount - getBuyPrice();
    }


}

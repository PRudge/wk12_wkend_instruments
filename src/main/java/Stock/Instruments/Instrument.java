package Stock.Instruments;

import Interfaces.IPlay;
import Stock.StockItem;

public abstract class Instrument extends StockItem implements IPlay {

    private String colour;
    private String material;
    private String instrumentType;

    public Instrument(String description, double buyPrice, double sellPrice,
                      String colour, String material, String instrumentType ){
        super(description,buyPrice,sellPrice);

        this.material = material;
        this.colour = colour;
        this.instrumentType = instrumentType;
    }

    public String getColour() {
        return this.colour;
    }

    public String getMaterial() {
        return this.material;
    }

    public String getInstrumentType() {
        return this.instrumentType;
    }

}
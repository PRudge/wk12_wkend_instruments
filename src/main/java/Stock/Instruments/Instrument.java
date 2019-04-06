package Stock.Instruments;

import Interfaces.IPlay;
import Stock.StockItem;

public abstract class Instrument extends StockItem implements IPlay {

    private String colour;
    private String material;

    private InstrumentFamily instrumentFamily;

    public Instrument(String description, double buyPrice, double sellPrice,
                      String colour, String material, InstrumentFamily instrumentFamily){
        super(description,buyPrice,sellPrice);

        this.material = material;
        this.colour = colour;
        this.instrumentFamily = instrumentFamily;
    }

    public String getColour() {
        return this.colour;
    }

    public String getMaterial() {
        return this.material;
    }

    public InstrumentFamily getInstrumentType() {
        return this.instrumentFamily;
    }

}
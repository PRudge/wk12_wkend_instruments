package Stock.Instruments;

import Interfaces.IPlay;

public class Guitar extends Instrument implements IPlay {

    private int numStrings;

    public Guitar(String description, double buyPrice, double sellPrice, String colour,
                  String material, String instrumentType, int numStrings) {
        super(description, buyPrice, sellPrice, colour, material, instrumentType);

        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return this.numStrings;
    }
    public String play(String sound) {
        return "Guitar sound: " + sound;
    }

}

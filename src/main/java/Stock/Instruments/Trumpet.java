package Stock.Instruments;

public class Trumpet extends Instrument {

    private int numValves;

    public Trumpet(String description, double buyPrice, double sellPrice, String colour,
                 String material, InstrumentFamily instrumentFamily, int numValves) {

        super(description, buyPrice, sellPrice, colour, material, instrumentFamily);

        this.numValves = numValves;

    }

    public int getNumValves() {
        return this.numValves;
    }

    public String play(String sound){
        return "Trumpet sound: " + sound;
    }

}
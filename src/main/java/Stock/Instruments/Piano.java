package Stock.Instruments;

public class Piano extends Instrument {

    private String make;

    public Piano(String description, double buyPrice, double sellPrice, String colour,
                 String material, String instrumentType, String make) {

        super(description, buyPrice, sellPrice, colour, material, instrumentType);

        this.make = make;

    }

    public String getMake() {
        return this.make;
    }

    public String play(String sound){
        return "Piano sound: " + sound;
    }

}
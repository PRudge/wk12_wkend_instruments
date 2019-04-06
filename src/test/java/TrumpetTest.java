import Stock.Instruments.InstrumentFamily;
import Stock.Instruments.Trumpet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrumpetTest {
    private Trumpet trumpet;

    @Before
    public void before(){
        trumpet = new Trumpet("C Trumpet", 134.00, 295.00,
                "Gold", "Brass", InstrumentFamily.BRASS, 9);
    }

    @Test
    public void canGetDescription(){
        assertEquals("C Trumpet", trumpet.getDescription());

    }

    @Test
    public void canGetBuyPrice(){
        assertEquals(134.00, trumpet.getBuyPrice(),.1);

    }

    @Test
    public void canGetSellPrice(){
        assertEquals(295.00, trumpet.getSellPrice(),.1);

    }

    @Test
    public void canSetSellPrice(){
        trumpet.setSellPrice(240.00);
        assertEquals(240.00, trumpet.getSellPrice(),.1);

    }

    @Test
    public void canGetColour(){
        assertEquals("Gold", trumpet.getColour());

    }

    @Test
    public void canGetMaterial(){
        assertEquals("Brass", trumpet.getMaterial());

    }

    @Test
    public void canGetInstrumentType(){
        assertEquals(InstrumentFamily.BRASS, trumpet.getInstrumentType());

    }

    //specific to trumpet check number of valves

    @Test
    public void canGetNumValves(){
        assertEquals(9, trumpet.getNumValves());

    }

    // markup in StockItem - grandparent class

    @Test
    public void canGetMarkUp(){
        assertEquals(161.00, trumpet.calculateMarkUp(), .1);
    }


    // added get sales price (10% off)

    @Test
    public void canGetSalesPrice(){
        assertEquals(131.50, trumpet.calculateSalesPrice(), .1);
    }

    // sound in Instrument - parent class

    @Test
    public void canMakeSound(){
        assertEquals("Trumpet sound: tarantara, tarantara", trumpet.play("tarantara, tarantara"));
    }


}

import Stock.Instruments.InstrumentFamily;
import Stock.Instruments.Piano;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PianoTest {
    private Piano piano;

    @Before
    public void before(){
        piano = new Piano("Baby Grand", 3400.00, 9500.00,
                "Black", "Mahogany", InstrumentFamily.PERCUSSION, "Yamaha");
    }


    @Test
    public void canGetDescription(){
        assertEquals("Baby Grand", piano.getDescription());

    }

    @Test
    public void canGetBuyPrice(){
        assertEquals(3400.00, piano.getBuyPrice(),.1);

    }

    @Test
    public void canGetSellPrice(){
        assertEquals(9500.00, piano.getSellPrice(),.1);

    }

    @Test
    public void canSetSellPrice(){
        piano.setSellPrice(4500.00);
        assertEquals(4500.00, piano.getSellPrice(),.1);

    }

    @Test
    public void canGetColour(){
        assertEquals("Black", piano.getColour());

    }

    @Test
    public void canGetMaterial(){
        assertEquals("Mahogany", piano.getMaterial());

    }

    @Test
    public void canGetInstrumentType(){
        assertEquals(InstrumentFamily.PERCUSSION, piano.getInstrumentType());

    }

    //specific to piano - check make

    @Test
    public void canGetMake(){
        assertEquals("Yamaha", piano.getMake());

    }

    // markup in StockItem - grandparent class

    @Test
    public void canGetMarkUp(){
        assertEquals(6100.00, piano.calculateMarkUp(), .1);
    }

    // added get sales price (10% off)

    @Test
    public void canGetSalesPrice(){
        assertEquals(5150.00, piano.calculateSalesPrice(), .1);
    }

    // sound in Instrument - parent class

    @Test
    public void canMakeSound(){
        assertEquals("Piano sound: plink, plonk", piano.play("plink, plonk"));
    }


}

import Stock.Instruments.Guitar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuitarTest {
    private Guitar guitar;

    @Before
    public void before(){
        guitar = new Guitar("Gibson", 340.00, 950.00,
                "Purple", "Wood", "String", 9 );
    }


    @Test
    public void canGetDescription(){
        assertEquals("Gibson", guitar.getDescription());

    }

    @Test
    public void canGetBuyPrice(){
        assertEquals(340.00, guitar.getBuyPrice(),.1);

    }

    @Test
    public void canGetSellPrice(){
        assertEquals(950.00, guitar.getSellPrice(),.1);

    }

    @Test
    public void canSetSellPrice(){
        guitar.setSellPrice(500.00);
        assertEquals(500.00, guitar.getSellPrice(),.1);

    }

    @Test
    public void canGetColour(){
        assertEquals("Purple", guitar.getColour());

    }

    @Test
    public void canGetMaterial(){
        assertEquals("Wood", guitar.getMaterial());

    }

    @Test
    public void canGetInstrumentType(){
        assertEquals("String", guitar.getInstrumentType());

    }

    //specific to guitar - check number of strings

    @Test
    public void canGetNumStrings(){
        assertEquals(9, guitar.getNumStrings());

    }

    // markup in StockItem - grandparent class

    @Test
    public void canGetMarkUp(){
        assertEquals(610.00, guitar.calculateMarkUp(), .1);
    }

    // sound in Instrument - parent class

    @Test
    public void canMakeSound(){
        assertEquals("Guitar sound: strum", guitar.play("strum"));
    }


}

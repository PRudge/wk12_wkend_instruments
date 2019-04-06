import Stock.Instruments.Piano;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PianoTest {
    private Piano piano;

    @Before
    public void before(){
        piano = new Piano("Baby Grand", 34.00, 95.00,
                "Black", "Mahogany", "Keyboard", 9 , "Yamaha");
    }



    @Test
    public void canGetDescription(){
        assertEquals("Baby Grand", piano.getDescription());

    }

    @Test
    public void canGetbuyPrice(){
        assertEquals(34.00, piano.getBuyPrice(),.1);

    }

    @Test
    public void canGetsellPrice(){
        assertEquals(95.00, piano.getSellPrice(),.1);

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
        assertEquals("Keyboard", piano.getInstrumentType());

    }

    //specific to guitar - check number of strings

    @Test
    public void canGetMake(){
        assertEquals("Yamaha", piano.getMake());

    }

    // markup in StockItem - grandparent class

    @Test
    public void canGetMarkUp(){
        assertEquals(61.00, piano.calculateMarkUp(), .1);
    }

    // sound in Instrument - parent class

    @Test
    public void canMakeSound(){
        assertEquals("Piano sound: plink, plonk", piano.play("plink, plonk"));
    }


}

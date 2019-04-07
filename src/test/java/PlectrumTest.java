import Stock.Accessories.Plectrum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlectrumTest {
    private Plectrum plectrum;

    @Before
    public void before(){
        plectrum = new Plectrum("Dunlop 47P3S Jazz III", 00.50, 4.99);

    }

    @Test
    public void canGetDescription(){
        assertEquals("Dunlop 47P3S Jazz III", plectrum.getDescription());

    }

    @Test
    public void canGetBuyPrice(){
        assertEquals(00.50, plectrum.getBuyPrice(),.1);

    }

    @Test
    public void canGetSellPrice(){
        assertEquals(4.99, plectrum.getSellPrice(),.1);

    }

    @Test
    public void canSetSellPrice(){
        plectrum.setSellPrice(2.50);
        assertEquals(2.50, plectrum.getSellPrice(),.1);

    }


    // markup in StockItem - parent class

    @Test
    public void canGetMarkUp(){
        assertEquals(4.49, plectrum.calculateMarkUp(), .01);
    }

    // added get sales price (10% off)

    @Test
    public void canGetSalesPrice(){
        assertEquals(4.49, plectrum.getSalesPrice(), .1);
    }
}

import Stock.Accessories.CornetMute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CornetMuteTest {
    private CornetMute cornetMute;

    @Before
    public void before(){
        cornetMute = new CornetMute("The Denis Wick Adjustable Cup Mute", 20.00, 44.99);

    }

    @Test
    public void canGetDescription(){
        assertEquals("The Denis Wick Adjustable Cup Mute", cornetMute.getDescription());

    }

    @Test
    public void canGetBuyPrice(){
        assertEquals(20.00, cornetMute.getBuyPrice(),.1);

    }

    @Test
    public void canGetSellPrice(){
        assertEquals(44.99, cornetMute.getSellPrice(),.1);

    }

    @Test
    public void canSetSellPrice(){
        cornetMute.setSellPrice(6.00);
        assertEquals(6.00, cornetMute.getSellPrice(),.1);

    }

    // markup in StockItem - parent class

    @Test
    public void canGetMarkUp(){
        assertEquals(24.99, cornetMute.calculateMarkUp(), .01);
    }


    // added get sales price (10% off)

    @Test
    public void canGetSalesPrice(){
        assertEquals(20.49, cornetMute.calculateSalesPrice(), .1);
    }


}

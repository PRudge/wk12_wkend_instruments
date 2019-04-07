import Stock.Accessories.DrumSticks;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrumSticksTest {

    private DrumSticks drumSticks;

    @Before
    public void before(){
        drumSticks = new DrumSticks("Pro Mark Classic 5A", 2.00, 11.99);

    }

    @Test
    public void canGetDescription(){
        assertEquals("Pro Mark Classic 5A", drumSticks.getDescription());

    }

    @Test
    public void canGetBuyPrice(){
        assertEquals(2.00, drumSticks.getBuyPrice(),.1);

    }

    @Test
    public void canGetSellPrice(){
        assertEquals(11.99, drumSticks.getSellPrice(),.1);

    }

    @Test
    public void canSetSellPrice(){
        drumSticks.setSellPrice(6.00);
        assertEquals(6.00, drumSticks.getSellPrice(),.1);

    }


    // markup in StockItem - parent class

    @Test
    public void canGetMarkUp(){
        assertEquals(9.99, drumSticks.calculateMarkUp(), .01);
    }

    // added get sales price (10% off)

    @Test
    public void canGetSalesPrice(){
        assertEquals(10.79, drumSticks.getSalesPrice(), .1);
    }



}

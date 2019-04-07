import Stock.Accessories.SheetMusic;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SheetMusicTest {
    private SheetMusic sheetMusic;

    @Before
    public void before(){
        sheetMusic = new SheetMusic("Albinoni's Adagio", 2.00, 4.99);

    }

    @Test
    public void canGetDescription(){
        assertEquals("Albinoni's Adagio", sheetMusic.getDescription());

    }

    @Test
    public void canGetBuyPrice(){
        assertEquals(2.00, sheetMusic.getBuyPrice(),.1);

    }

    @Test
    public void canGetSellPrice(){
        assertEquals(4.99, sheetMusic.getSellPrice(),.1);

    }

    @Test
    public void canSetSellPrice(){
        sheetMusic.setSellPrice(3.99);
        assertEquals(3.99, sheetMusic.getSellPrice(),.1);

    }


    // markup in StockItem - parent class

    @Test
    public void canGetMarkUp(){
        assertEquals(2.99, sheetMusic.calculateMarkUp(), .01);
    }

    // added get sales price (10% off)

    @Test
    public void canGetSalesPrice(){
        assertEquals(4.49, sheetMusic.getSalesPrice(), .1);
    }
}

import Interfaces.ISell;

import Shop.Shop;
import Stock.Accessories.SheetMusic;
import Stock.Instruments.Guitar;
import Stock.Instruments.InstrumentFamily;
import Stock.Instruments.Piano;
import Stock.Instruments.Trumpet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;

    private ArrayList<ISell> stock;
    private ISell iSell;

    private Guitar guitar;
    private Piano piano;
    private SheetMusic sheetMusic;
    private Trumpet trumpet;

    @Before
    public void before(){

        shop = new Shop("Sound and Vision");

        stock = new ArrayList<>();

        guitar = new Guitar("Gibson", 340.00, 950.00,
                "Purple", "Wood", InstrumentFamily.STRINGS, 9 );
        piano = new Piano("Baby Grand", 3400.00, 9500.00,
                "Black", "Mahogany", InstrumentFamily.PERCUSSION, "Yamaha");
        sheetMusic = new SheetMusic("Albinoni's Adagio", 2.00, 4.99);
        trumpet = new Trumpet("C Trumpet", 134.00, 295.00,
                "Gold", "Brass", InstrumentFamily.BRASS, 9);

    }

    @Test
    public void canGetName(){
        assertEquals("Sound and Vision", shop.getShopName());
    }

    @Test
    public void canGetStockCount(){
        assertEquals(0, shop.countStock());
    }


    // polymorphism, the guitar is being added to an array of ISell objects
    @Test
    public void canAddStock(){
        shop.addItem(guitar);

        assertEquals(1, shop.countStock());
    }

    @Test
    public void canRemoveStock(){
        shop.addItem(guitar);
        shop.addItem(guitar);
        shop.addItem(piano);
        shop.addItem(sheetMusic);
        shop.addItem(sheetMusic);
        shop.addItem(trumpet);

        assertEquals(6, shop.countStock());

        shop.removeItem(sheetMusic);
        assertEquals(5, shop.countStock());
    }

    @Test
    public void canCalculateProfit() {
        shop.addItem(guitar);
        shop.addItem(piano);
        shop.addItem(sheetMusic);
        shop.addItem(sheetMusic);

        assertEquals(6715.98, shop.calculateProfit(), .1);
    }

}

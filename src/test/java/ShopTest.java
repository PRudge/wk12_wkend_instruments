import Interfaces.ISell;

import Shop.Shop;
import Customer.Customer;
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
    private Customer customer;

    private ArrayList<ISell> stock;
    private ISell iSell;

    private Guitar guitar;
    private Piano piano;
    private SheetMusic sheetMusic;
    private Trumpet trumpet;

    @Before
    public void before(){

        customer = new Customer("Phil", "Collins", 600);
        shop = new Shop("Sound and Vision", customer, 5000);

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
    public void canGetCustomer(){
        assertEquals("Phil", shop.getCustomer().getFirstName());
    }

    @Test
    public void canGetTill(){
        assertEquals(5000, shop.getTill(), .1);
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
    public void canGetStock(){
        shop.addItem(guitar);
        assertEquals(950, shop.getStock().get(0).getSellPrice(), .1);
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

    @Test
    public void canTotUpBill(){
        customer.addItemToBasket(guitar); // 950
        customer.addItemToBasket(guitar); // 950
        customer.addItemToBasket(piano); // 9500
        customer.addItemToBasket(sheetMusic); // 4.99
        customer.addItemToBasket(sheetMusic); // 4.99
        customer.addItemToBasket(trumpet); // 2.95


        int bill = shop.totUpBill(customer.getShoppingBasket());
        assertEquals(10343.00, bill, .1);

    }

    @Test
    public void canAddToTill(){
        customer.addItemToBasket(guitar); // 950 - 190(20% override in guitar class sale)
        customer.addItemToBasket(guitar); // 950 - 190
        customer.addItemToBasket(piano); // 9500 - 950(10% default)
        customer.addItemToBasket(sheetMusic); // 4.99 - .49
        customer.addItemToBasket(sheetMusic); // 4.99 - .49
        customer.addItemToBasket(trumpet); // 2.95 - .295

        int bill = shop.totUpBill(customer.getShoppingBasket());

        shop.addToTill(bill);
        assertEquals(15343, shop.getTill(), .1); // this takes into account the sales price
    }

    @Test
    public void canMakeTransaction(){
        // stock shop
        shop.addItem(guitar);
        shop.addItem(guitar);
        shop.addItem(piano);
        shop.addItem(sheetMusic);
        shop.addItem(sheetMusic);
        shop.addItem(trumpet);

        assertEquals(6, shop.countStock());

        // customer does some shopping
        customer.addItemToBasket(sheetMusic); // 4.99 - items are 10% off
        customer.addItemToBasket(sheetMusic); // 4.99

        shop.checkOut();

        // check all things that should be updated

        assertEquals(592.00, customer.getWallet(), .1); // £8 deducted for sheet music
        assertEquals(0, customer.countItemsInBasket()); // basket is empty

        assertEquals(5008, shop.getTill(), .1); // till updated by £8
        assertEquals(4, shop.countStock());


    }



}

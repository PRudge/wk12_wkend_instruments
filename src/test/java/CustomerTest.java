import Interfaces.ISell;
import Customer.Customer;
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

public class CustomerTest {

    private Shop shop;
    private Customer customer;

    private ArrayList<ISell> basket;
    private ISell iSell;

    private Guitar guitar;
    private Piano piano;
    private SheetMusic sheetMusic;
    private Trumpet trumpet;

    @Before
    public void before(){

        customer = new Customer("David", "Bowie", 500);

        basket = new ArrayList<>();

        guitar = new Guitar("Gibson", 340.00, 950.00,
                "Purple", "Wood", InstrumentFamily.STRINGS, 9 );
        piano = new Piano("Baby Grand", 3400.00, 9500.00,
                "Black", "Mahogany", InstrumentFamily.PERCUSSION, "Yamaha");
        sheetMusic = new SheetMusic("Albinoni's Adagio", 2.00, 4.99);
        trumpet = new Trumpet("C Trumpet", 134.00, 295.00,
                "Gold", "Brass", InstrumentFamily.BRASS, 9);

    }

    @Test
    public void canGetFirstName(){
        assertEquals("David", customer.getFirstName());
    }

    @Test
    public void canGetLastName(){
        assertEquals("Bowie", customer.getLastName());
    }

    @Test
    public void canGetWallet(){
        assertEquals(500, customer.getWallet(), .1);
    }

    @Test
    public void canGetStockCount(){
        assertEquals(0, customer.countItemsInBasket());
    }


    @Test
    public void canAddToBasket(){
        customer.addItemToBasket(guitar);

        assertEquals(1, customer.countItemsInBasket());
    }

    @Test
    public void canGetShoppingBasket(){
        customer.addItemToBasket(guitar);
        customer.addItemToBasket(piano);
        customer.addItemToBasket(trumpet);

        assertEquals(3, customer.countItemsInBasket());


       assertEquals(9500, customer.getShoppingBasket().get(1).getSellPrice(), .1);
    }

    @Test
    public void canRemoveFromBasket(){
        customer.addItemToBasket(guitar);
        customer.addItemToBasket(guitar);
        customer.addItemToBasket(piano);
        customer.addItemToBasket(sheetMusic);
        customer.addItemToBasket(sheetMusic);
        customer.addItemToBasket(trumpet);

        assertEquals(6, customer.countItemsInBasket());

        customer.removeItemFromBasket(sheetMusic);
        assertEquals(5, customer.countItemsInBasket());
    }

    @Test
    public void canCheckEnoughMoneyTrue(){
        int bill = 400;
        assertEquals(true, customer.checkWallet(bill));
    }

    @Test
    public void canCheckEnoughMoneyFalse(){
        int bill = 600;
        assertEquals(false, customer.checkWallet(bill));
    }

    @Test
    public void canPayBill(){
        int bill = 400;
        customer.payBill(bill);
        assertEquals(100, customer.getWallet(), .1);
        // check that basket is empty

        assertEquals(0, customer.countItemsInBasket());

    }

}

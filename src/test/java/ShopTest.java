import Interfaces.ISell;

import Shop.Shop;
import Customer.Customer;
import Stock.Accessories.DrumSticks;
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
    private Customer customer1;
    private Customer customer2;
    private Customer customer3;

    private ArrayList<Customer>customers;

    private ArrayList<ISell> stock;
    private ISell iSell;

    private DrumSticks drumSticks;
    private Guitar guitar;
    private Piano piano;
    private SheetMusic sheetMusic;
    private Trumpet trumpet;

    @Before
    public void before(){
        shop = new Shop("Sound and Vision", 5000);

        stock = new ArrayList<>();


        drumSticks = new DrumSticks("Pro Mark Classic 5A", 2.00, 11.99);

        guitar = new Guitar("Gibson", 340.00, 950.00,
                "Purple", "Wood", InstrumentFamily.STRINGS, 9 );
        piano = new Piano("Baby Grand", 3400.00, 9500.00,
                "Black", "Mahogany", InstrumentFamily.PERCUSSION, "Yamaha");
        sheetMusic = new SheetMusic("Albinoni's Adagio", 2.00, 4.99);
        trumpet = new Trumpet("C Trumpet", 134.00, 295.00,
                "Gold", "Brass", InstrumentFamily.BRASS, 9);


        // customers

        customer = new Customer("Phil", "Collins", 1600);
        customer1 = new Customer("Peter", "Gabriel", 300);
        customer2 = new Customer("Mike", "Rutherford", 200);
        customer3 = new Customer("Steve", "Hacket", 950);


    }

    @Test
    public void canGetName(){
        assertEquals("Sound and Vision", shop.getShopName());
    }


    @Test
    public void canGetTill(){
        assertEquals(5000, shop.getTill(), .1); // empty to start with
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

    /* customers
    - adding customers (they enter shop)
    - removing customers (they leave shop)
    - counting customers

    - does transaction with a customer
    */


    @Test
    public void canCountCustomers(){
        assertEquals(0, shop.countCustomers());

    }

    @Test
    public void canAddCustomers(){
        shop.addCustomer(customer);
        assertEquals(1, shop.countCustomers());
    }

    @Test
    public void canRemoveCustomers(){
        shop.addCustomer(customer1);
        shop.addCustomer(customer2);
        shop.addCustomer(customer3);
        assertEquals(3, shop.countCustomers());

        shop.removeCustomer(customer1);
        assertEquals(2, shop.countCustomers());


    }

    @Test
    public void canMakeTransactionTrue(){ //for a specific customer
        // stock shop
        shop.addItem(guitar);
        shop.addItem(guitar);
        shop.addItem(piano);
        shop.addItem(sheetMusic);
        shop.addItem(sheetMusic);
        shop.addItem(trumpet);

        assertEquals(6, shop.countStock());


        // customer adds some things to basket
        customer.addItemToBasket(sheetMusic); // 4.99 - items are 10% off
        customer.addItemToBasket(sheetMusic); // 4.99


        // check everything is as expected
        assertEquals(1600.00, customer.getWallet(), .1);
        assertEquals(2, customer.countItemsInBasket());

        assertEquals(5000, shop.getTill(), .1);
        assertEquals(6, shop.countStock());

        shop.checkOut(customer);

        // check all things that should be updated
        assertEquals(1592.00, customer.getWallet(), .1); // £8 deducted for sheet music
        assertEquals(0, customer.countItemsInBasket()); // basket is empty

        assertEquals(5008, shop.getTill(), .1); // till updated by £8
        assertEquals(4, shop.countStock());

    }

    @Test
    public void canMakeTransactionFalse(){ //for a specific customer
        // stock shop
        shop.addItem(guitar);
        shop.addItem(guitar);
        shop.addItem(piano);
        shop.addItem(sheetMusic);
        shop.addItem(sheetMusic);
        shop.addItem(trumpet);

        assertEquals(6, shop.countStock());


        // customer adds some things to basket
        customer3.addItemToBasket(piano);
        customer3.addItemToBasket(guitar);


        // check everything is as expected
        assertEquals(950, customer3.getWallet(), .1);
        assertEquals(2, customer3.countItemsInBasket());

        assertEquals(5000, shop.getTill(), .1);
        assertEquals(6, shop.countStock());

        shop.checkOut(customer3);

        // check all things that should be updated
        assertEquals(950, customer3.getWallet(), .1); // £8 deducted for sheet music
        assertEquals(2, customer3.countItemsInBasket());

        assertEquals(5000, shop.getTill(), .1); // till updated by £8
        assertEquals(6, shop.countStock());

    }

    @Test
    public void canTotUpBill(){
        customer.addItemToBasket(guitar); // 950
        customer.addItemToBasket(guitar); // 950
        customer.addItemToBasket(piano); // 9500
        customer.addItemToBasket(sheetMusic); // 4.99
        customer.addItemToBasket(sheetMusic); // 4.99
        customer.addItemToBasket(trumpet); // 295

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
        customer.addItemToBasket(trumpet); // 295 - 29.50

        int bill = shop.totUpBill(customer.getShoppingBasket());

        shop.addToTill(bill);
        assertEquals(15343, shop.getTill(), .1); // this takes into account the sales price
    }

    @Test
    public void canDealWithAQueueOfCustomers(){
        // set up stock in the shop
        shop.addItem(guitar);
        shop.addItem(guitar);
        shop.addItem(guitar);
        shop.addItem(guitar);
        shop.addItem(piano);
        shop.addItem(piano);
        shop.addItem(sheetMusic);
        shop.addItem(sheetMusic);
        shop.addItem(trumpet);
        shop.addItem(drumSticks);

        // set up customers and baskets
        shop.addCustomer(customer);
        customer.addItemToBasket(guitar); // 950 - 190(20% override in guitar class sale)
        customer.addItemToBasket(sheetMusic); //4.99

        shop.addCustomer(customer1);
        customer1.addItemToBasket(sheetMusic); // 4.99 - .49
        customer1.addItemToBasket(trumpet); // 295 - 29.50

        shop.addCustomer(customer2);
        customer2.addItemToBasket(drumSticks);


        // check everything is as expected

        assertEquals(3, shop.countCustomers());


        assertEquals(5000, shop.getTill(), .1);
        assertEquals(10, shop.countStock());

        shop.checkOutQueue();

        assertEquals(6043, shop.getTill(), .1); // till updated by £8
        assertEquals(5, shop.countStock());
    }

}

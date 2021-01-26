import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class InstockTest {

    private static final String PRODUCT_LABEL = "test_label";

    private ProductStock stock;
    private Product testProduct;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.testProduct = new Product(PRODUCT_LABEL, 10, 1);
    }

    @Test
    public void testAddShouldSaveProduct() {
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));

    }


    @Test
    public void testContainsShouldReturnFalseWhenProductIsNotPresent() {
        assertFalse(stock.contains(testProduct));
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    //

    @Test
    public void testCountShouldReturnOneForSingleProduct() {
        stock.add(testProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testCountShouldReturnTenForTenProducts() {
        int expectedProductCount = 10;
        addProductsToStock(expectedProductCount);
        assertEquals(10, stock.getCount());
    }

    @Test
    public void testCountShouldReturnZeroWhenEmpty() {

        assertEquals(0, stock.getCount());
    }

    //this test will work only if we add remove operation
    //The only thing you have to add is the remove method call

    @Ignore
    @Test
    public void testCountShouldFiveWhenFirstAddTenThenRemoveFiveProducts() {
        int expectedProductCount = 10;
        addProductsToStock(expectedProductCount);
        assertEquals(0, stock.getCount());
        // TODO add remove of five products here
        assertEquals(5,stock.getCount());
    }

    private void addProductsToStock(int count) {
        for (int i = 0; i < count; i++) {
            stock.add(new Product("" + i, i + 10, i));
        }
    }
}

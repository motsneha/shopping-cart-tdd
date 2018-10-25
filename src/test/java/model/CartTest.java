package model;

import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.*;
import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class CartTest {

    @Test
    public void testCreateAnEmptyCart() {
        //arrange

        //act
        Cart cart = new Cart();
        //assert
        assertThat(cart).isNotNull();
        assertTrue(cart.isEmpty());
    }

    @Test
    public void testAddAProductToCart() {
        //arrange
        Cart cart = new Cart();
        Product doveSoap = new Product("Dove Soap", 30);
        //act
        cart.addProduct(doveSoap, 1);
        //assert
        assertFalse(cart.isEmpty());
        List<Product> products = cart.getProducts();
        assertEquals(1, cart.getNumberOfProducts());
        for (Product p : products) {
            assertEquals(p.getName(), "Dove Soap");
            assertEquals(p.getPrice(), 30);
        }
        assertEquals(30, cart.getTotalPrice());
    }

    @Test
    public void testAddMoreProductsToCart() {
        //arrange
        Cart cart = new Cart();
        Product doveSoap = new Product("Dove Soap", 30);
        //act
        cart.addProduct(doveSoap, 5);
        //assert
        assertFalse(cart.isEmpty());
        assertEquals(5, cart.getNumberOfProducts());
        List<Product> products = cart.getProducts();

        for (Product p : products) {
            assertEquals(p.getName(), "Dove Soap");
            assertEquals(p.getPrice(), 30);
        }
        assertEquals(150, cart.getTotalPrice());
    }

    @Test
    public void testAddProductWithQuantitySpecifiedToACart() {

        //arrange
        Cart cart = new Cart();
        Product doveSoap = new Product("Dove Soap", 30);

        //act
        cart.addProduct(doveSoap, 5);
        cart.addProduct(doveSoap, 3);
        //assert

        assertEquals(8, cart.getNumberOfProducts());
        assertEquals(240, cart.getTotalPrice());

        List<Product> products = cart.getProducts();
        for (Product p : products) {
            assertEquals(p.getName(), "Dove Soap");
            assertEquals(p.getPrice(), 30);
        }
    }

    @Test(expected = RuntimeException.class)
    public void testAddProductWithZeroQuantityShouldFailAndThrowException()  {
        //arrange
        Cart cart = new Cart();
        Product doveSoap = new Product("Dove Soap", 30);

        //act
        cart.addProduct(doveSoap, 0);

        //assert
        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getNumberOfProducts());
    }

}
package work.demotask.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import work.demotask.response.Response;
import work.demotask.service.CartService;
import work.demotask.service.StoreService;

@RunWith(MockitoJUnitRunner.class)
public class DefaultStoreTest {
	
	@Mock
	private StoreService storeService;
	
	@Mock
	private CartService cartService;
	
	private Store underTest;
	
	private static final String ITEM_IN_STORE = "Item1";
	private static final String ITEM_NOT_IN_STORE = "Item2";
	private static final String ITEM_TWO_IN_STORE = "Item3";
	
	@Before
	public void setUp() {
		underTest = new DefaultStore(storeService, cartService);
		when(cartService.addItemToCart(ITEM_IN_STORE, 1)).thenReturn(Response.SUCCESS_ADD);
		when(cartService.addItemToCart(ITEM_NOT_IN_STORE, 1)).thenReturn(Response.ITEM_NOT_FOUND);
		when(cartService.getCartItems()).thenReturn(getCartItems());
	}
	
	@Test
	public void testAddValidItem() {
		underTest.addItemToCart(ITEM_IN_STORE, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddInvalidItem() {
		underTest.addItemToCart(ITEM_NOT_IN_STORE, 1);
	}
	
	@Test
	public void testAddItemToStore() {
		underTest.addItemToStore(ITEM_IN_STORE, 2.2);
	}
	
	@Test
	public void testGetCartItems() {
		assertEquals(2, underTest.getCartItems().length);
	}
	
	@Test
	public void testCartTotal() {
		assertEquals(15, underTest.getCartTotal(), 0);
	}
	
	private List<LineItem> getCartItems(){
		List<LineItem> lineItems = new ArrayList<LineItem>();
		StoreItem storeItem1 = new StoreItem(ITEM_IN_STORE, 2.2);
		StoreItem storeItem2 = new StoreItem(ITEM_TWO_IN_STORE, 4);
		lineItems.add(new DefaultLineItem(storeItem1, 5));
		lineItems.add(new DefaultLineItem(storeItem2, 1));
		return lineItems;
	}

}

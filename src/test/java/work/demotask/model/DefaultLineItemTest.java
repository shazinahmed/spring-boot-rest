package work.demotask.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultLineItemTest {

	private LineItem underTest;
	private static final String ITEM_IN_STORE = "Item1";
	
	@Before
	public void setUp() {
		StoreItem storeItem = new StoreItem(ITEM_IN_STORE, 5);
		underTest = new DefaultLineItem(storeItem, 1);
	}
	
	@Test
	public void testIncrement() {
		underTest.incrementQuantity(2);
		underTest.incrementQuantity(-2);
		assertEquals(1, underTest.getQuantity());
	}
}

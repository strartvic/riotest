package str.model;

import org.junit.Assert;
import org.junit.Test;

public class BillTest {

	@Test
	public void testBillStringArray() {
		try {
			Bill bill = new Bill(new String[] { "1", "Сбербанк" });
			Assert.assertNotNull(bill);
		} catch (Exception e) {
			Assert.fail("Конструктор счета вернул исключение! Превышено кол-во параметров!");
			e.printStackTrace();
		}
	}

}

package str.model;

import org.junit.Assert;
import org.junit.Test;

public class IndicatorTest {

	@Test
	public void testIndicatorIntIntIntIntIntIntIntIntIntIntIntInt() {
		Indicator ind = new Indicator(1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0);
		Assert.assertNotNull(ind);
		Assert.assertNull(ind.getBill());
		Assert.assertNull(ind.getCreditOrg());
	}

	@Test
	public void testIndicatorStringArray() {
		try {
			Indicator ind = new Indicator(new String[] { "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1" });
			Assert.assertNotNull(ind);
			Assert.assertNull(ind.getBill());
			Assert.assertNull(ind.getCreditOrg());
		} catch (Exception e) {
			Assert.fail("Конструктор индикатора вернул исключение! Превышено кол-во параметров!");
			e.printStackTrace();
		}
	}

}

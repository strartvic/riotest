package str.model;

import org.junit.Assert;
import org.junit.Test;

public class CreditOrgTest {

	@Test
	public void testCreditOrgStringArray() {
		try {
			CreditOrg org = new CreditOrg(new String[] { "1", "Сбербанк" });
			Assert.assertNotNull(org);
		} catch (Exception e) {
			Assert.fail("Конструктор организации вернул исключение! Превышено кол-во параметров!");
			e.printStackTrace();
		}
	}

}

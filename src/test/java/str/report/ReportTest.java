package str.report;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportTest {

	private static String xlsPath;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File xls = File.createTempFile("temp", ".xls");
		xlsPath = xls.getAbsolutePath();
		xls.delete();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		new File(xlsPath).delete();
	}

	@Test
	public void testReport() {
		try {
			Report rep = new Report(xlsPath); // Создание
			rep.write();
			Assert.assertNotNull(rep);
			rep = new Report(xlsPath); // Чтение
			Assert.assertNotNull(rep);
		} catch (Exception e) {
			Assert.fail("Тест вернул исключение!");
			e.printStackTrace();
		}
	}

	@Test
	public void testAddGetRows() {
		try {
			Report rep = new Report(xlsPath); // Создание
			LinkedList<String[]> list = new LinkedList<String[]>();
			list.add(new String[] { "1", "2", "3" });
			rep.addRows(list);
			rep.write();

			rep = new Report(xlsPath); // Чтение
			LinkedList<String[]> list2 = new LinkedList<String[]>();
			list2 = rep.getRows();

			if (list.size() != list2.size()) {
				Assert.assertTrue(false);
			}
			Iterator<String[]> iter = list2.iterator();
			for (String[] props : list) {
				String[] props2 = iter.next();
				Assert.assertArrayEquals(props, props2);
			}
		} catch (Exception e) {
			Assert.fail("Тест вернул исключение!");
			e.printStackTrace();
		}
	}

}

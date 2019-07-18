package str.report;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReportXTest {

	private static String xlsxPath;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		File xlsx = File.createTempFile("temp", ".xlsx");
		xlsxPath = xlsx.getAbsolutePath();
		xlsx.delete();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		new File(xlsxPath).delete();
	}

	@Test
	public void testReportX() {
		try {
			Report rep = new Report(xlsxPath); // Создание
			rep.write();
			Assert.assertNotNull(rep);
			rep = new Report(xlsxPath); // Чтение
			Assert.assertNotNull(rep);
		} catch (Exception e) {
			Assert.fail("Тест вернул исключение!");
			e.printStackTrace();
		}
	}

	@Test
	public void testAddGetRows() {
		try {
			Report rep = new Report(xlsxPath); // Создание
			LinkedList<String[]> list = new LinkedList<String[]>();
			list.add(new String[] { "1", "2", "3" });
			rep.addRows(list);
			rep.write();

			rep = new Report(xlsxPath); // Чтение
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

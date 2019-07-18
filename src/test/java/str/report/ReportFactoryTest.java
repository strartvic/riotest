package str.report;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class ReportFactoryTest {

	@Test
	public void testGetReport() {
		try {
			File xls = File.createTempFile("temp", ".xls");
			File xlsx = File.createTempFile("temp", ".xlsx");
			File temp = File.createTempFile("temp", ".x");
			String xlsPath = xls.getAbsolutePath();
			String xlsxPath = xlsx.getAbsolutePath();
			String tempPath = temp.getAbsolutePath();
			xls.delete();
			xlsx.delete();
			temp.delete();

			IReport rep = ReportFactory.getReport(xlsPath);
			Assert.assertNotNull(rep);
			rep = ReportFactory.getReport(xlsxPath);
			Assert.assertNotNull(rep);
			rep = ReportFactory.getReport(tempPath);
			Assert.assertNull(rep);
		} catch (IOException e) {
			Assert.fail("Тест вернул исключение!");
			e.printStackTrace();
		}

	}

}

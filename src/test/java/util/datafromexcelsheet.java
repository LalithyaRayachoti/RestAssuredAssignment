package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datafromexcelsheet {
	public static Object[][] gettestdata() throws IOException  {
		FileInputStream fis = new FileInputStream("C:\\Users\\RayachotiLalithya\\Desktop\\DatasheetSDET\\TestSample2.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);

		int totalrows = sheet.getLastRowNum();
		System.out.println("Total Rows:" + totalrows);
		
		Row row = sheet.getRow(1);
		int totalcolumn = row.getLastCellNum();
		
		System.out.println("Total column:" + totalcolumn);
		
		Object[][] data = new Object[totalrows+1][totalcolumn];

		for (int i = 0; i < totalrows+1; i++) {

			for (int j = 0; j < totalcolumn; j++) {

				try {
					data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.println(data[i][j]);

				}

				catch (NullPointerException ex)

				{
					System.out.println(ex.getMessage());
				}
			}

		}
		workbook.close();
		return data;

		

	}


}

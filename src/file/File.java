package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import triangle.*;

public class File {
	public ArrayList<TemplateTestTriangle> readExcel(String path) throws IOException {
		FileInputStream file = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		ArrayList<TemplateTestTriangle> arr1 = new ArrayList<TemplateTestTriangle>();

		FormulaEvaluator fomula = wb.getCreationHelper().createFormulaEvaluator();
		for (Row row : sheet) {
			if (row.getRowNum() != 0) {
				double[] tmp = new double[4];
				int index = 0;
				for (Cell cell : row) {
					if (fomula.evaluate(cell) != null) {
						switch (fomula.evaluate(cell).getCellType()) {
						case STRING:
//			  	          System.out.println(cell.getStringCellValue());
							break;
						case NUMERIC:
//			  	          System.out.println(cell.getNumericCellValue());
							tmp[index] = cell.getNumericCellValue();
							index++;
							break;
						}
					}
				}
				arr1.add(new TemplateTestTriangle(tmp[0], tmp[1], tmp[2], (int) tmp[3]));
			}

		}
		wb.close();
		file.close();
		return arr1;
	}

	public void writeATestCase(XSSFRow row, TemplateTestTriangle t1) {

		String data[] = t1.convertArrayString(row.getRowNum() + 1);
		for (int i = 0; i < data.length; i++) {
			XSSFCell Cell = row.createCell(i);
			Cell.setCellValue(data[i]);
		}

	}

	public void writeExcel(String path, ArrayList<TemplateTestTriangle> arr) throws IOException {
		FileOutputStream file = new FileOutputStream(path);
		if(file == null) {
			System.out.println("Please check path file output");
			return;
		}
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet workSheet = workbook.createSheet("results");
		XSSFRow row1 = workSheet.createRow(0);

		row1.createCell(0).setCellValue("TC");
		row1.createCell(1).setCellValue("a");
		row1.createCell(2).setCellValue("b");
		row1.createCell(3).setCellValue("c");
		row1.createCell(4).setCellValue("Expected Result");
		row1.createCell(5).setCellValue("Actual");
		row1.createCell(6).setCellValue("Result");

		for (int i = 1; i < arr.size() + 1; i++) {
			XSSFRow row = workSheet.createRow((short) i);
			writeATestCase(row, arr.get(i - 1));
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("Write complete!");
	}

}

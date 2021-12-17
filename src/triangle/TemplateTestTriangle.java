package triangle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import file.File;

public class TemplateTestTriangle extends Triangle {
	private int expectedResult;
	private int actual;
	private String result;

	public TemplateTestTriangle(double a, double b, double c, int expectedResult, int actual, String result) {
		super(a, b, c);
		this.expectedResult = expectedResult;
		this.actual = actual;
		this.result = result;
	}

	public TemplateTestTriangle(double a, double b, double c, int expectedResult) {
		super(a, b, c);
		this.expectedResult = expectedResult;
	}

	public int getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(int expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String[] convertArrayString(int index) {
		String arr[] = { "TC" + index, super.getA() + "", super.getB() + "", super.getC() + "", expectedResult + "",
				actual + "", result };
		return arr;
	}

	public double[] arrayParams() {
		double arr[] = { super.getA(), super.getB(), super.getC(), expectedResult };
		return arr;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

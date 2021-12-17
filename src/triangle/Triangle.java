package triangle;

import java.io.*;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import file.File;

public class Triangle {
	private double a, b, c;

	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
		a = 0;
		b = 0;
		c = 0;
	}

	public int CheckTriangle() {
		boolean isTriangle = false;
		if (a < b + c && b < a + c && c < a + b) {
			isTriangle = true;
		}
		if (isTriangle) {
			if (a == b && b == c) {
				return 2;
			} else if (a != b && b != c && a != c)
				return 0;
			else
				return 1;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + " ]";
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

}
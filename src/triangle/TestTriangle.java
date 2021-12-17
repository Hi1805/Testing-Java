/**
 * 
 */
package triangle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import file.File;

/**
 * @author ripker
 *
 */
@RunWith(Parameterized.class)

class TestTriangle {
	private static ArrayList<TemplateTestTriangle> TestCases;
	private static File f1 = new File();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		try {
			TestCases = f1.readExcel("E:\\my_workspace\\java\\Testing11\\src\\data\\testcaseTriangle.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @throws java.lang.Exception
	 */

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			f1.writeExcel("E:\\my_workspace\\java\\Testing11\\src\\data\\testcaseResult.xlsx", TestCases);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ParameterizedTest
	@MethodSource("provideForTestcase")
	void testTestIsTriangle(int result, int expect) {
		assertEquals(result, expect);
	}

	private static Stream<Arguments> provideForTestcase() {
		return TestCases.stream().map(item -> Arguments.of(item.CheckTriangle(), item.getExpectedResult()));
	}

	@AfterEach
	void addDataResult() {
		for (TemplateTestTriangle testcase : TestCases) {
			testcase.setActual(testcase.CheckTriangle());
			testcase.setResult(testcase.getActual() == testcase.getExpectedResult() ? "Pass" : "Fail");
		}
	}

}

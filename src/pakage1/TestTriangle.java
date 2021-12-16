/**
 * 
 */
package pakage1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import file.File;

/**
 * @author ripker
 *
 */

class TestTriangle {
	 private static ArrayList<TemplateTestTriangle> TestCases ;
	 private static File f1 = new File();

	 /**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 try {
			TestCases =  f1.readExcel("E:\\my_workspace\\java\\Testing11\\src\\test.xlsx");
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
		System.out.println("run write file");
		try {
			f1.writeExcel("E:\\my_workspace\\java\\Testing11\\src\\test2.xlsx",TestCases);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	   
	 @SuppressWarnings("WeakerAccess")
	    @Parameterized.Parameter(value = 0)
	    public int number;
	 @SuppressWarnings("WeakerAccess")
	    @Parameterized.Parameter(value = 1)
	    public int expected;
	    // The name attribute is optional, provide an unique name for test

//	 @Parameterized.Parameters(name = "{index}: testEDI({0}, {1})")
//	    public static Collection<Object[]> data() {
//	    	System.out.println("run params");
//	        return Arrays.asList(new Object[][]{
//	                {0, 2},
//	                {1, 3},
//	        });
//	    }
//	  @Test
//		void test() {
//			System.out.println("run");
//			assertEquals(expected,number);
//		}
	@AfterEach
	void addDataResult () {
		for(TemplateTestTriangle testcase : TestCases) {
			testcase.setActual(testcase.CheckTriangle());
			testcase.setResult(testcase.getActual() == testcase.getExpectedResult() ? "Pass" : "Fail");
		}
	}

}

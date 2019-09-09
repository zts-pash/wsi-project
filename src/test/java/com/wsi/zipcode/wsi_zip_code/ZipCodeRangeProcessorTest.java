package com.wsi.zipcode.wsi_zip_code;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.wsi.zipcode.service.ZipCodeRangeProcessorService;

/**
 * 
 * @author Pash
 *
 */

public class ZipCodeRangeProcessorTest {
	
	private ZipCodeRangeProcessorService service;
	
	@Before
    public void init() {
        service = new ZipCodeRangeProcessorService();
    }
   
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1Success() throws Exception {
		String input = "[94133,94133] [94200,94299] [94600,94699] [94698,94799]";
		String output = service.processZipCodeRangeList(input);
		assertEquals("[94133,94133] [94200,94299] [94600,94799]", output);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2Success() throws Exception {
		String input = "[94133,94134] [94200,94299] [94600,94699]";
		String output = service.processZipCodeRangeList(input);
		assertEquals("[94133,94133] [94200,94299] [94600,94699]", output);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3Success() throws Exception {
		String input = "[94133,94133] [94200,94299] [94226,94399] ";
		String output = service.processZipCodeRangeList(input);
		assertEquals("[94133,94133] [94200,94399]", output);
	}

	/**
	 * 
	 * @throws Exception
	 */
	@Test (expected = IllegalArgumentException.class)
	public void test4Failure() throws Exception {
		String input = "";
		String output = service.processZipCodeRangeList(input);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
    public void test5Failure() throws Exception  {
		service.processZipCodeRangeList("[95691] [4548,6775]");
    }
}

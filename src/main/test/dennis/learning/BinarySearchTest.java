package dennis.learning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
	int[] array;
	
	BinarySearch binarySearch = new BinarySearch();
	
	@Before
	public void setUp() throws Exception {
		array = new int[] {0,1,2,3,4,5,6,7,8,9};
	}
	//Iterative
	@Test
	public void testSearch() {
		int index = binarySearch.search(array, 3);
		Assert.assertEquals(3, index);
	}
	@Test
	public void testSearchMid() {
		int index = binarySearch.search(array, 5);
		Assert.assertEquals(5, index);
	}
	@Test
	public void testSearchMax() {
		int index = binarySearch.search(array, 9);
		Assert.assertEquals(9, index);
	}

	@Test
	public void testSearchMin() {
		int index = binarySearch.search(array, 0);
		Assert.assertEquals(0, index);
	}
	
	@Test
	public void testSearchNotFoundHigh() {
		int index = binarySearch.search(array, 10);
		Assert.assertEquals(-1, index);
	}
	
	@Test
	public void testSearchNotFoundMid() {
		array = new int[] {0,1,2,3,4,6,7,8,9,10};
		int index = binarySearch.search(array, 5);
		Assert.assertEquals(-1, index);
	}
	
	@Test
	public void testSearchEmpty() {
		array = new int[] {};
		int index = binarySearch.search(array, 5);
		Assert.assertEquals(-1, index);
	}
	//Recursive
	@Test
	public void testSearchRecursive() {
		int index = binarySearch.searchRecursive(array, 3, 0, array.length-1);
		Assert.assertEquals(3, index);
	}
	
	//Recursive
	@Test
	public void testSearchRecursiveMid() {
		int index = binarySearch.searchRecursive(array, 5, 0, array.length-1);
		Assert.assertEquals(5, index);
	}
	
	@Test
	public void testSearchMaxRecursive() {
		int index = binarySearch.searchRecursive(array, 9, 0, array.length-1);
		Assert.assertEquals(9, index);
	}

	@Test
	public void testSearchMinRecursive() {
		int index = binarySearch.searchRecursive(array, 0, 0, array.length-1);
		Assert.assertEquals(0, index);
	}
	
	@Test
	public void testSearchNotFoundHighRecursive() {
		int index = binarySearch.searchRecursive(array, 10, 0, array.length-1);
		Assert.assertEquals(-1, index);
	}
	
	@Test
	public void testSearchNotFoundMidRecursive() {
		array = new int[] {0,1,2,3,4,6,7,8,9,10};
		int index = binarySearch.searchRecursive(array, 5, 0, array.length-1);
		Assert.assertEquals(-1, index);
	}
	@Test
	public void testSearchEmptyMid() {
		array = new int[] {};
		int index = binarySearch.searchRecursive(array, 5, 0, array.length-1);
		Assert.assertEquals(-1, index);
	}
}

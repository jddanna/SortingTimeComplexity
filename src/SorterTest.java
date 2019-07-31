import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Jdanna
 *
 */
public class SorterTest {
	

	private Record[] records;
	Sorter sorter = new Sorter();

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		records = sorter.makeRecords();
	}

	@Test
	public void testSorts() {
		Record[] temp;
		
		//bubble
		temp = sorter.deepCopy(records);
		sorter.bubbleSort(temp);
		boolean check = true;
		
		for (int i = 0; i < temp.length - 1;i++) {
			if (temp[i].compareTo(temp[i+1]) > 0) {
				check = false;
			}
		}
		assertTrue(check);
		
		//insertion
		temp = sorter.deepCopy(records);
		sorter.insertionSort(temp);
		
		for (int i = 0; i < temp.length - 1;i++) {
			if (temp[i].compareTo(temp[i+1]) > 0) {
				check = false;
			}
		}
		assertTrue(check);
		
		//selection
		temp = sorter.deepCopy(records);
		sorter.selectionSort(temp);
		
		for (int i = 0; i < temp.length - 1;i++) {
			if (temp[i].compareTo(temp[i+1]) > 0) {
				check = false;
			}
		}
		assertTrue(check);
		
		//shell
		temp = sorter.deepCopy(records);
		sorter.shellSort(temp);
		
		for (int i = 0; i < temp.length - 1;i++) {
			if (temp[i].compareTo(temp[i+1]) > 0) {
				check = false;
			}
		}
		assertTrue(check);
		
		//heap
		temp = sorter.deepCopy(records);
		sorter.heapSort(temp);
		
		for (int i = 0; i < temp.length - 1;i++) {
			if (temp[i].compareTo(temp[i+1]) > 0) {
				check = false;
			}
		}
		assertTrue(check);
		
		//quick
		temp = sorter.deepCopy(records);
		sorter.quickSort(temp);
		
		for (int i = 0; i < temp.length - 1;i++) {
			if (temp[i].compareTo(temp[i+1]) > 0) {
				check = false;
			}
		}
		assertTrue(check);
		
		
		
		
		
	}

}

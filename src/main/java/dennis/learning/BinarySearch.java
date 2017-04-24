package dennis.learning;

/**
 * Log N run time because it will half the problem set continually. The gains
 * from halving the set diminish towards the end of the set, indicating the
 * logarithmic pattern.
 * 
 * @author Dennis
 * 
 */
public class BinarySearch {
	/**
	 * Iterative solution
	 * 
	 * @param data
	 * @param value the value to search for
	 * @return
	 */
	public int search(int[] data, int value) {
		int lowIndex = 0;
		int highIndex = data.length;
		while (lowIndex < highIndex) {
			int midIndex = lowIndex + (highIndex - lowIndex) / 2;
			int midValue = data[midIndex];
			if (midValue == value) {
				return midIndex;
			} else if (midValue < value) {
				lowIndex = midIndex + 1;
			} else { // if (midValue > value)
				highIndex = midIndex - 1;
			}
		}
		return -1;
	}

	public int searchRecursive(int[] data, int value, int lowIndex, int highIndex) {
		if (lowIndex > highIndex) {
			return -1;
		}
		int midIndex = (lowIndex + highIndex) / 2;
		int midValue = data[midIndex];
		if (midValue == value) {
			return midIndex;
		} else if (midValue < value) {
			return searchRecursive(data, value, midIndex + 1, highIndex);
		} else { // if (midValue > value)
			return searchRecursive(data, value, lowIndex, midIndex - 1);
		}
	}
}

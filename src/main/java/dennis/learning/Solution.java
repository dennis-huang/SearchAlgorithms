package dennis.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * For Facebook
 * Identify the largest and smallest possible outcome of the game. All values in
 * between the two extremes in theory have a chance to be picked.
 * 
 * @author Dennis Huang
 * 
 */
public class Solution {
	public static void main(String args[]) throws Exception {
			Scanner input = new Scanner(System.in);
			int numTestCases = input.nextInt();
			// Loop for the number of test cases
			for (int testCaseCount = 0; testCaseCount < numTestCases; testCaseCount++) {
				List<Integer> totalNumberList = new ArrayList<Integer>();
				List<Integer> largestPossibleList = new ArrayList<Integer>();
				List<Integer> smallestPossibleList = new ArrayList<Integer>();
				int nFriends = input.nextInt();
				int kLargest = input.nextInt();
				// Loop to read each line of a friend (a line of the N total
				// lines)
				for (int count = 0; count < nFriends && input.hasNextInt(); count++) {
					int a_iNumPerLine = input.nextInt();
					List<Integer> a_iValueList = new ArrayList<Integer>();
					// Loop to parse and obtain each individual value within a
					// line
					for (int a_iCount = 0; a_iCount < a_iNumPerLine; a_iCount++) {
						int a_iValue = input.nextInt();
						a_iValueList.add(a_iValue);
						totalNumberList.add(a_iValue);
					}
					Collections.sort(a_iValueList);
					// Get the largest and smallest values of a friend, and
					// store them in lists
					int largestInFriend = a_iValueList.get(0);
					int smallestInFriend = a_iValueList.get(a_iValueList.size() - 1);
					largestPossibleList.add(largestInFriend);
					smallestPossibleList.add(smallestInFriend);
				}
				Collections.sort(largestPossibleList);
				Collections.sort(smallestPossibleList);
				// Get the smallest and largest possible k-ith elements and then
				// find them in the list of all numbers
				int largestPossibleKValue = largestPossibleList.get(kLargest - 1);
				int smallestPossibleKValue = smallestPossibleList.get(kLargest - 1);
				Collections.sort(totalNumberList);
				int indexOfLargest = totalNumberList.indexOf(largestPossibleKValue);
				int indexOfSmallest = totalNumberList.indexOf(smallestPossibleKValue);
				List<Integer> outputList = totalNumberList.subList(indexOfLargest, indexOfSmallest + 1);
				System.out.println("" + outputList.size());
			}
			input.close();
	}
}
package arrays.repeatAndMissingNumberArray;

import java.util.ArrayList;
import java.util.List;

/**
 * There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
 * This is one of those problems.
 * Please take extra care to make sure that you are type-casting your ints to long properly and at all places.
 * Try to verify if your solution works if number of elements is as large as 105
 * For example, if you need to calculate n! / k! where n! is factorial(n),
 * one approach is to calculate factorial(n), factorial(k) and then divide them.
 * Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
 * Obviously approach 1 is more susceptible to overflows.
 *
 * You are given a read only array of n integers from 1 to n.
 * Each integer appears exactly once except A which appears twice and B which is missing.
 * Return A and B.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Note that in your output A should precede B.
 * Example:
 * Input:[3 1 2 5 3]
 * Output:[3, 4]
 * A = 3, B = 4
 *
 */
public class RepeatAndMissingNumberArray {

	// DO NOT MODIFY THE LIST
	public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		long sum = 0;
		long squareSum = 0;
		long temp;
		for(Integer i = 0; i < a.size(); i++){
			temp = a.get(i).longValue();
			sum = sum + temp;
			sum = sum - (i + 1);// this will give us A - B at end.
			squareSum = squareSum + temp * temp;
			squareSum = squareSum - (i.longValue()+1)*(i.longValue()+1); // this will give us A^2 - B^2
		}

		squareSum = squareSum / sum; //(A-B)(A+B)/(A-B) = (A+B)
		int X = (int) (squareSum + sum) / 2;
		int Y = (int) squareSum - X;
		result.add(X);
		result.add(Y);
		return result;
	}

	public static void main(String[] args) {

		ArrayList<Integer> X = new ArrayList<Integer>();
		for(int i =0; i < Math.pow(10, 5)-1; i++) {
		X.add(i+1);
		}

		int size =(int) Math.pow(10, 5);

		X.add(size-1,1);


		RepeatAndMissingNumberArray repeatAndMissingNumberArray = new RepeatAndMissingNumberArray();

		System.out.println(repeatAndMissingNumberArray.repeatedNumber(X));
	}

}

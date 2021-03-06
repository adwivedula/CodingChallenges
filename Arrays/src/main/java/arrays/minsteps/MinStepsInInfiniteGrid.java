package arrays.minsteps;

import java.util.ArrayList;

/**
 * Problem statement :
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 * (x,y) to
 * (x+1, y),
 * (x - 1, y),
 * (x, y+1),
 * (x, y-1),
 * (x-1, y-1),
 * (x+1,y+1),
 * (x-1,y+1),
 * (x+1,y-1)
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 * Example :
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 * It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 * This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 * Hint :
 * Note that because the order of covering the points is already defined,
 * the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).
 * Can you think of a formula for calculating the distance in O(1) ?
 * Note that because the order of covering the points is already defined,
 * the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).
 * Note that what only matters is X = abs(A-C) and Y = abs(B-D).
 * While X and Y are positive, you will move along the diagonal and X and Y would both reduce by 1.
 * When one of them becomes 0, you would move so that in each step the remaining number reduces by 1.
 * In other words, the total number of steps would correspond to max(X, Y).
 */
public class MinStepsInInfiniteGrid {

	private int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {

		int numSteps = 0;
		for (int i = 1; i < X.size(); i++) {
			numSteps += Math.max(Math.abs(X.get(i) - X.get(i - 1)), Math.abs(Y.get(i) - Y.get(i - 1)));
		}
		return numSteps;
	}

	public static void main(String[] args) {
		ArrayList<Integer> X = new ArrayList<Integer>(3);
		ArrayList<Integer> Y = new ArrayList<Integer>(3);

		X.add(0);X.add(1);X.add(1);
		Y.add(0);Y.add(1);Y.add(2);

		MinStepsInInfiniteGrid minStepsInInfiniteGrid = new MinStepsInInfiniteGrid();

		System.out.println(minStepsInInfiniteGrid.coverPoints(X, Y));
	}

}

package paper_roll;

import java.util.ArrayList;

/**
 * Interface for the implementation of the Bottom Up DP solution.
 * 
 * @author Richard Szilagyi R00198735
 */
public interface PaperRollCutting {
    /**
     * Adds price to a paper roll.
     * 
     * @param price Price of paper roll
     */
    public void addPrice(double price);

    /**
     * Gets the `prices` Array List.
     * 
     * @return Array List holding the prices of each paper length
     */
    public ArrayList<Double> getPrices();

    /**
     * Gets the `cuts` array.
     * 
     * @return Array holding the positions of each cut
     */
    public int[] getCuts();

    /**
     * Computes the best revenue of cutting the roll into several roll-pieces.
     * 
     * @param n Size of the desired paper roll.
     * @return Optimal price after cutting the roll into pieces.
     */
    public double cutRoll(int n);

    /**
     * Prints out the best price and the cut for each paper roll length.
     */
    public void printResults();
}

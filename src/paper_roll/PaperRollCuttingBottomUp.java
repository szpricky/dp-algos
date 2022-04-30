package paper_roll;

import java.util.ArrayList;

/**
 * Bottom Up DP solution for cutting a paper roll into pieces to obtain the
 * optimal price for best revenue.
 * 
 * @author Richard Szilagyi R00198735
 */
public class PaperRollCuttingBottomUp {
    /** Class Attributes */
    private final ArrayList<Double> prices; // holds prices of each paper length
    private int[] cuts; // holds positions of each cut
    private double[] optimalPrices; // holds optimal prices of each paper length
    int size;

    /**
     * Default constructor
     */
    public PaperRollCuttingBottomUp() {
        this.prices = new ArrayList<>();
    }

    /**
     * Adds price to a paper roll.
     * 
     * @param price Price of paper roll
     */
    public void addPrice(double price) {
        this.prices.add(price);
    }

    /**
     * Gets the `prices` Array List.
     * 
     * @return Array List holding the prices of each paper length
     */
    public ArrayList<Double> getPrices() {
        return prices;
    }

    /**
     * Gets the `cuts` array.
     * 
     * @return Array holding the positions of each cut
     */
    public int[] getCuts() {
        return this.cuts;
    }

    /**
     * Computes the best revenue of cutting the roll into several roll-pieces.
     * 
     * @param n Size of the desired paper roll.
     * @return Optimal price after cutting the roll into pieces.
     */
    public double cutRoll(int n) {
        /* Exit the function if invalid parameter is provided */
        if (n < 1) {
            System.out.println("Size must be greater than 0.");
            return 0;
        }

        /* Initialise instance variables */
        this.cuts = new int[n + 1];
        this.optimalPrices = new double[n + 1];
        this.optimalPrices[0] = 0;
        this.size = n;

        for (int i = 1; i < this.cuts.length; i++) {
            double bestPrice = Double.MIN_VALUE; // holds the value of best price
            for (int j = 1; j <= this.prices.size(); j++) {
                if (i - j >= 0) {
                    if (bestPrice < this.prices.get(j - 1) + this.optimalPrices[i - j]) {
                        bestPrice = this.prices.get(j - 1) + this.optimalPrices[i - j];
                        this.cuts[i] = j; // Add to cuts
                    }
                }
                this.optimalPrices[i] = bestPrice;
            }
        }

        /* Return the optimal price */
        return optimalPrices[n];
    }

    /**
     * Prints out the best price and the cut for each paper roll length.
     */
    public void printResults() {
        System.out.println("Rod length: " + this.size);

        /* Print the best price for each roll length */
        for (int i = 1; i < this.optimalPrices.length; i++) {
            System.out.printf("Best price for roll of length %d: \u20ac%.2f%n", i, this.optimalPrices[i]);
        }

        /* Print the cuts */
        int length = this.size;
        for (int i = 1; length > 0; i++) { // while loop to print out all cuts for given 'position'
            System.out.printf("Cut %d: %d%n", i, this.getCuts()[length]);
            length -= this.getCuts()[length]; // position minus its first cut
        }
    }

    public static void main(String[] args) {
        /* Create instance of PaperRollCuttingBottomUp */
        PaperRollCuttingBottomUp paperRoll = new PaperRollCuttingBottomUp();

        /* Add the prices */
        paperRoll.addPrice(1.2);
        paperRoll.addPrice(3);
        paperRoll.addPrice(5.8);
        paperRoll.addPrice(10.1);

        /* Output */
        for (int size = 1; size <= paperRoll.getPrices().size(); size++) {
            double optimalRevenue = paperRoll.cutRoll(size);
            paperRoll.printResults();
            System.out.printf("Optimal revenue: \u20ac%.1f%n%n", optimalRevenue);
        }
    }
}

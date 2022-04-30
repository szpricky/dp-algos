package paper_roll;

import java.util.ArrayList;

/**
 * Bottom Up DP solution for cutting a paper roll into pieces to obtain the
 * optimal price for best revenue.
 * 
 * @author Richard Szilagyi R00198735
 */
public class PaperRollCuttingBottomUp implements PaperRollCutting {
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

    public void addPrice(double price) {
        this.prices.add(price);
    }

    public ArrayList<Double> getPrices() {
        return prices;
    }

    public int[] getCuts() {
        return this.cuts;
    }

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

}

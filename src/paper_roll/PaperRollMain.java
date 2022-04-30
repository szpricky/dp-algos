package paper_roll;

/**
 * Main file for Paper Roll Cutting
 * 
 * @author Richard Szilagyi R00198735
 */
public class PaperRollMain {
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

package robot;

/**
 * Bottom Up DP solution for moving a robot through a path with minimum energy
 * cost in a matrix.
 * 
 * @author Patrik Richard Szilagyi R00198735
 */
public class RobotMoving {
    /* Class Attributes */
    private double[][] totalCost, moves;
    private double[] moveCosts;
    private int size;

    /**
     * Constructor
     * 
     * @param costs Array holding energy costs
     */
    public RobotMoving(double[] costs) {
        this.moveCosts = costs;
    }

    /**
     * Computes the path with minimum energy cost.
     * 
     * @param n Size of matrix
     * @return Minimum energy cost of navigating through matrix
     */
    public double moveOnShortestPath(int n) {
        /* Exit the function if invalid parameter is provided */
        if (n < 1) {
            System.out.println("Size must be greater than 0.");
            return 0;
        }

        /* Initialise instance variables */
        this.totalCost = new double[n + 1][n + 1];
        this.moves = new double[n + 1][n + 1];
        this.size = n;

        for (int i = 0; i < this.totalCost.length; i++) {
            for (int j = 0; j < this.totalCost.length; j++) {
                double minCost = Double.MAX_VALUE; // holds the value of minimum energy cost

                /* Robot at starting position */
                if (i == 0 && j == 0) {
                    this.totalCost[j][i] = 0;
                    this.moves[j][i] = 0;
                    minCost = 0;
                }

                /* Robot moving right */
                if ((i - 1) >= 0) {
                    if (minCost > this.moveCosts[0] + this.totalCost[j][i - 1]) {
                        minCost = this.totalCost[j][i - 1] + this.moveCosts[0];
                        this.moves[j][i] = this.moveCosts[0];
                    }
                }

                /* Robot moving down */
                if ((j - 1) >= 0) {
                    if (minCost > this.moveCosts[1] + this.totalCost[j - 1][i]) {
                        minCost = this.totalCost[j - 1][i] + this.moveCosts[1];
                        this.moves[j][i] = this.moveCosts[1];
                    }
                }

                /* Robot moving diagonally */
                if ((j - 1) >= 0 && (i - 1) >= 0) {
                    if (minCost > this.moveCosts[2] + this.totalCost[j - 1][i - 1]) {
                        minCost = this.totalCost[j - 1][i - 1] + this.moveCosts[2];
                        this.moves[j][i] = this.moveCosts[2];
                    }
                }

                /* Set the total cost */
                this.totalCost[j][i] = minCost;
                System.out.println("Energy cost so far: " + this.totalCost[j][i]);
            }
        }

        return totalCost[n][n];
    }

    /**
     * Prints out the movements of the robot taken through the matrix.
     */
    public void printResults() {
        int row = this.size, column = this.size;

        System.out.print("Path taken: ");
        while (row != 0 || column != 0) {
            if (this.moves[row][column] == this.moveCosts[0]) {
                System.out.print("Right ");
                column--;
            }

            if (this.moves[row][column] == this.moveCosts[1]) {
                System.out.print("Down ");
                row--;
            }

            if (this.moves[row][column] == this.moveCosts[2]) {
                System.out.print("Right-down ");
                row--;
                column--;
            }
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        double[] c1 = { 1.1, 1.3, 2.5 }, c2 = { 1.5, 1.2, 2.3 };
        int size = 4;

        /* Robot with energy costs c1 */
        RobotMoving robot1 = new RobotMoving(c1);
        double totalCost1 = robot1.moveOnShortestPath(size);
        System.out.printf("Minimum energy cost: \u20ac%.2f%n", totalCost1);
        robot1.printResults();

        /* Robot with energy costs c2 */
        RobotMoving robot2 = new RobotMoving(c2);
        double totalCost2 = robot2.moveOnShortestPath(size);
        System.out.printf("Minimum energy cost: \u20ac%.2f%n", totalCost2);
        robot2.printResults();
    }
}

package robot;

public class RobotMain {
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

package robot;

public interface RobotMovement {
    /**
     * Computes the path with minimum energy cost.
     * 
     * @param n Size of matrix
     * @return Minimum energy cost of navigating through matrix
     */
    public double moveOnShortestPath(int n);

    /**
     * Prints out the movements of the robot taken through the matrix.
     */
    public void printResults();
}

package paper_roll;

/**
 * Paper Roll Cutting interface
 * 
 * @author Richard Szilagyi R00198735
 */
public interface PaperRollCutting {
    /**
     * Computes the best revenue of cutting the roll into several roll-pieces.
     * 
     * @param size Size of the desired paper roll.
     * @return Optimal value for the revenue after cutting the roll into pieces.
     */
    public double cut(int size);

    public void printArrays();
}

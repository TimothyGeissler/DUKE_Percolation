public class PercolationDFSFast extends PercolationDFS {

    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n) {
        super(n);
    }

    @Override
    protected void updateOnOpen(int row, int col) {
        boolean doDFS = false;
        if (row == 0) {
            doDFS = true;
        }
        try {
            if (isFull(row, col + 1)) {
                doDFS = true;
            }
        } catch (IndexOutOfBoundsException ex) {
            //System.out.println("On edge");
        }
        try {
            if (isFull(row, col - 1)) {
                doDFS = true;
            }
        } catch (IndexOutOfBoundsException ex) {
            //System.out.println("On edge");
        }
        try {
            if (isFull(row - 1, col)) {
                doDFS = true;
            }
        } catch (IndexOutOfBoundsException ex) {
            //System.out.println("On edge");
        }
        try {
            if (isFull(row + 1, col)) {
                doDFS = true;
            }
        } catch (IndexOutOfBoundsException ex) {
            //System.out.println("On edge");
        }
        /*try {
            if (row == 0 || isFull(row, col + 1) || isFull(row, col - 1) || isFull(row - 1, col) || isFull(row + 1, col)) {
                dfs(row, col);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("On edge");
        }*/
        if (doDFS) {
            dfs(row, col);
        }
    }
}

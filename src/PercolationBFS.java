import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast{
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {
        super(n);
    }

    @Override
    protected void dfs(int row, int col) {
        Queue<int []> queue = new LinkedList<>();
        myGrid[row][col] = FULL;
        queue.add(new int[]{row, col});

        while (queue.size() != 0) {
            int [] p = queue.remove();
            try {
                if (!isFull(p[0], p[1] + 1) && isOpen(p[0], p[1] + 1)) {
                    myGrid[p[0]][p[1] + 1] = FULL;
                    queue.add(new int[] {p[0], p[1] + 1});
                }
            } catch (IndexOutOfBoundsException ex) { }
            try {
                if (!isFull(p[0], p[1] - 1) && isOpen(p[0], p[1] - 1)) {
                    myGrid[p[0]][p[1] - 1] = FULL;
                    queue.add(new int[] {p[0], p[1] - 1});
                }
            } catch (IndexOutOfBoundsException ex) { }
            try {
                if (!isFull(p[0] - 1, p[1]) && isOpen(p[0] - 1, p[1])) {
                    myGrid[p[0] - 1][p[1]] = FULL;
                    queue.add(new int[] {p[0] - 1, p[1]});
                }
            } catch (IndexOutOfBoundsException ex) { }
            try {
                if (!isFull(p[0] + 1, p[1]) && isOpen(p[0] + 1, p[1])) {
                    myGrid[p[0] + 1][p[1]] = FULL;
                    queue.add(new int[] {p[0] + 1, p[1]});
                }
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("On edge");
            }
        }

        //super.dfs(row, col);
    }
}

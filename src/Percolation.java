public class Percolation {
    private boolean[][] opened;
    private int top = 0;
    private int bottom;
    private int size;
    private WeightedQuickUnionUF wquf;

    public Percolation(int N) {
        size = N;
        bottom = size * size + 1;
        wquf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
    }

    public void open(int i, int j) {
        opened[i - 1][j - 1] = true;
        if (i == 1) {
            wquf.union(getWQUFIndex(i, j), top);
        }
        if (i == size) {
            wquf.union(getWQUFIndex(i, j), bottom);
        }

        if (j > 1 && isOpen(i, j - 1)) {
            wquf.union(getWQUFIndex(i, j), getWQUFIndex(i, j - 1));
        }
        if (j < size && isOpen(i, j + 1)) {
            wquf.union(getWQUFIndex(i, j), getWQUFIndex(i, j + 1));
        }
        if (i > 1 && isOpen(i - 1, j)) {
            wquf.union(getWQUFIndex(i, j), getWQUFIndex(i - 1, j));
        }
        if (i < size && isOpen(i + 1, j)) {
            wquf.union(getWQUFIndex(i, j), getWQUFIndex(i + 1, j));
        }
    }

    public boolean isOpen(int i, int j) {
        return opened[i - 1][j - 1];
    }

    public boolean isFull(int i, int j) {
        if (0 < i && i <= size && 0 < j && j <= size) {
            return wquf.connected(top, getWQUFIndex(i , j));
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean percolates() {
        return wquf.connected(top, bottom);
    }

    private int getWQUFIndex(int i, int j) {
        return size * (i - 1) + j;
    }
}
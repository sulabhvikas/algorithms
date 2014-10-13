import java.util.Comparator;


public class HeapMaxPQ<Key extends Comparable<Key>> {
	
	private Key[] pq;
	private int N;
	
	public HeapMaxPQ(int capacity) {
		pq = (Key[]) new Comparable[capacity + 1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			exch(k, k/2);	
			k = k/2;
		}
	}
	
	private void sink(int k) {
		while (2 * k <= N ) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) j++;
			if(!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}
	
	public void insert(Key x) {
		pq[++N] = x;
		swim(N);
	}
	
	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		sink(1);
		pq[N+1] = null;
		return max;
	}

	private void exch(int j, int i) {
		Key swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;		
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
}

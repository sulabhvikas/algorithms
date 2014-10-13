
public class HeapSort {
	
	public static void sort(Comparable[] pq) {
		int N = pq.length;
		for(int k = N/2; k >= 1; k--) //first pass: Make the array in Heap-Order
			sink(pq, k, N);
		
		while(N > 1) {				  //Sort the array
			exch(pq, 1, N--);
			sink(pq, 1, N);
		}
		
	}

	private static void sink(Comparable[] pq, int k, int N) {
		while (2 * k <= N ) {
			int j = 2 * k;
			if (j < N && less(pq, j, j + 1)) j++;
			if(!less(pq, k, j)) break;
			exch(pq, k, j);
			k = j;
		}
	}
	
	private static void exch(Comparable[] pq, int j, int i) {
		Comparable swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;		
	}

	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
}
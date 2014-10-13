//3K + 1 increment sequence
public class ShellSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		
		int h = 1;
		while (h < N/3) h = 3 * h + 1; //1, 4, 13, 40
		
		while (h >= 1) { //h-sort the array
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exch(a, j, j-h);
			}
			
			h = h / 3;			
		}
	}

	private static void exch(Comparable[] a, int j, int i) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;		
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void main(String[] args) {
		Integer [ ] a = new Integer[ 10 ];
        for( int i = 0; i < a.length; i++ )
            a[ i ] = new Integer( i );
	
        Shuffle.shuffle(a);
        System.out.println("Before Sort: "+a[0]+"-"+a[9]);
        sort(a);
        System.out.println("After Sort: "+a[0]+"-"+a[9]);
	}
	
	
}

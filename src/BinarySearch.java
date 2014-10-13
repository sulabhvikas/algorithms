
public class BinarySearch {
	
	public static int binarySearch(int[] id, int num) {
		int lo = 0;
		int hi = id.length - 1;
		
		while (lo <= hi) {
			int mid = lo + (hi - lo)/2;
			if (num < id[mid]) hi = mid - 1;
			else if (num > id[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;		
	}
	
	public static void main(String[] args) {
		int elementCount = 10;
		int[] id = new int[elementCount];
		for (int i = 0; i <elementCount; i++) {
			id[i] = i;
		} 
		
		System.out.println(binarySearch(id, 5));
	}
}

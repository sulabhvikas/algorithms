
public class WeightedUnionFind {
	private int[] id;
	private int[] size;
	private int count;
	
	public WeightedUnionFind(int N) {
		
		id = new int[N];
		size = new int[N];
		
		for (int i = 0; i < N; i++) id[i] = i;
		for (int j = 0; j < N; j++) id[j] = 1;
				
	}

}

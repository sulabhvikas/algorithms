public class QuickUnionWeightedUF {
    private int[] id;
    private int[] sz;
    public QuickUnionWeightedUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }
    
    public int root(int i) {
       int index = i;
       while (index != id[index]) index = id[index];
       return index;
    }
   
    public boolean connected(int p, int q) {
       return (root(p) == root(q));
    }
 
    public void union(int p, int q) {
       int i = root(p);
       int j = root(q);
       
       if (sz[i] < sz[j]) {
          id[i] = j;
          sz[j] += sz [i];
       } else {
          id[j] = i;
          sz[i] += sz [j];
       }
    }
    
    public int depth(int i) {
        int index = i;
        int j = 0;
        while (index != id[index]) {
            index = id[index];
            j++;
        }        
        return j;
    }
}


public class Subset {
    public static void main (String[] args) {
        
    	int k = Integer.parseInt(args[0]);
        
    	RandomizedQueue<String> input = new RandomizedQueue<String>();
        
    	while (!StdIn.isEmpty()) {
            String inputString = StdIn.readString();
    		input.enqueue(inputString);
            System.out.println("read = "+inputString);
        }
        
        for (int i = 0; i < k; i++) {
            StdOut.println(input.dequeue());
        }       
    }
}

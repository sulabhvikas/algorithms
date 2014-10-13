
public final class ImmutableVector { // can't override methods
	private final int N; // final instance variables
	private final double[] data;
	
	public ImmutableVector(double[] data) {
		this.N = data.length;
		this.data = new double[N];
		for (int i = 0; i < N; i++) { //defensive copy of mutable instance variable 
			this.data[i] = data[i];
		}
	}
	
}


package A4Traffic;

public class TrafficTester {

	public static void main(String[] args) {
		// Same as the example but the constructor has a new speed variable
		Traffic t = new Traffic(150, Integer.MAX_VALUE, 0.25, 25, 56465);

		t.run();
	}
}

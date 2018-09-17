package A4Traffic;

import java.util.Random;

public class Traffic {
	// I renamed the PLUS and MINUS to be their directions
	private final int EMPTY = 0;
	private final int EAST = 1;
	private final int SOUTH = 2;

	private int[][] array;
	private int size;
	private long speed;
	private int iterations;
	private double density;
	private Random random;
	private TrafficDrawer drawer;

	// constructor sets all the variables
	public Traffic(int size, int iterations, double density, long speed, int seed) {
		this.array = new int[size][size];
		this.size = size;
		this.speed = speed;
		this.iterations = iterations;
		this.density = density;
		this.random = new Random(seed);
		this.drawer = new TrafficDrawer(array, size);
	}

	// pretty much the only change I made was that when a vehicle gets stuck,
	// they take one step to the side. This is based on a driving strategy
	// people in New York City have that says when a traffic jam occurs, just
	// move one street over.

	public void run() {
		initialize();

		for (int n = 0; n < iterations; n++) {
			draw();

			for (int m = 0; m < size * size; m++) {
				int i = random.nextInt(size);
				int j = random.nextInt(size);

				// this makes the east moving vehicle move one square south if
				// that south square is empty

				if (array[i][j] == EAST) {
					if (array[(i + 1) % size][j] == EMPTY) {
						array[i][j] = EMPTY;
						array[(i + 1) % size][j] = EAST;
					} else if (array[i][(j + 1) % size] == EMPTY) {
						array[i][j] = EMPTY;
						array[i][(j + 1) % size] = EAST;
					}
				}

				// this makes the south moving vehicle move one square east if
				// that east square is empty

				if (array[i][j] == SOUTH) {
					if (array[i][(j + 1) % size] == EMPTY) {
						array[i][j] = EMPTY;
						array[i][(j + 1) % size] = SOUTH;
					} else if (array[(i + 1) % size][j] == EMPTY) {
						array[i][j] = EMPTY;
						array[(i + 1) % size][j] = SOUTH;
					}
				}
			}
		}
	}

	// same old initialize method
	private void initialize() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (random.nextDouble() < density) {
					if (random.nextDouble() < 0.5) {
						array[i][j] = EAST;
					} else {
						array[i][j] = SOUTH;
					}
				} else {
					array[i][j] = EMPTY;
				}
			}
		}
	}

	private void draw() {
		drawer.repaint();
		// I pulled speed out so I could edit it when calling the constructor in
		// the tester class
		try {
			Thread.sleep(this.speed);
		} catch (Exception e) {
		}

	}
}

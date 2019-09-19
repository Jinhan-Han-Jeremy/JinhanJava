package sudoku;

import java.util.ArrayList;

public class Grid {
	private int[][] values;

	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++) {
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i = 0; i < 9; i++) {
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}

	//
	// DON'T CHANGE THIS.
	//
	public String toString() {
		String s = "";
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char) ('0' + n);
			}
			s += "\n";
		}
		return s;
	}

	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You’ll call this 9 times in next9Grids.
	//
	Grid(Grid src) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++)
			for (int i = 0; i < 9; i++)
				values[j][i] = src.values[j][i];
	}

	public ArrayList<Grid> next9Grids() {
		int xOfNextEmptyCell = 0;
		int yOfNextEmptyCell = 0;
		// Set x,y locations as an integer.

		// Find x,y of an empty cell using xOfNextEmptyCell and yOfNextEmptyCell
		int[] xy = new int[2];

		for (xy[0] = 0; xy[0] < 9; xy[0]++) {
			for (xy[1] = 0; xy[1] < 9; xy[1]++) {

				// assign empty cell locations to 2 integer variables
				if (values[xy[0]][xy[1]] == 0) {
					xOfNextEmptyCell = xy[0];
					yOfNextEmptyCell = xy[1];
				}

			}
		}

		// Construct array list to contain 9 new grids.
		ArrayList<Grid> grds = new ArrayList<Grid>();

		// Create 9 new grids as described in the comments above. Add them to grids.
		for (int i = 1; i <= 9; i++) {
			Grid nextGrid = new Grid(this);
			// add new grid in order into empty cell location until 9 times
			nextGrid.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;
			grds.add(nextGrid);
		}

		return grds;
	}

	// add one method to find repeated number or not
	private boolean repeatOrNot(int[] number) {

		boolean[] ObservedOne = new boolean[number.length + 1];
		// construct list of boolean in (size of number + 1) for each number.

		for (int i : number) {
			if (i == 0) {
				// 0 is dummy because we start from 1.
				continue; // continue when it is 0
			} else if (ObservedOne[i] != true) {
				// if it has first met, assign true into ObservedOne
				ObservedOne[i] = true;
			} else {
				// return true, if ObservedOne is true.
				return true;
			}

		}
		return false;
	}

	public boolean isLegal() {
		// Check every row. If you find an illegal row, return false.
		for (int j = 0; j < values.length; j++) {

			// construct new integers with size 9
			int[] numbers = new int[9];

			// Build for loop to assign values[i][j] to integer array[9]
			for (int i = 0; i < values.length; i++) {
				numbers[i] = values[j][i];

				// if the number is repeated, return false
				if (repeatOrNot(numbers)) {
					return false;
				}
			}
		}

		// Check every column. If you find an illegal column, return false.
		for (int j = 0; j < values.length; j++) {
			// construct integer array in size of 9
			int[] numbers_c = new int[9];

			// Build for loop to assign values[j][i] to integer array[9]
			for (int i = 0; i < values.length; i++) {

				numbers_c[i] = values[i][j];

				// if the number is repeated, return false
				if (repeatOrNot(numbers_c)) {
					return false;
				}
			}
		}

		// Check every block. If you find an illegal block, return false.
		// All rows/cols/blocks are legal.
		for (int j = 0; j < values.length; j += 3) {

			// leap 3 blocks to go to next row or colummn
			for (int i = 0; i < values.length; i += 3) {
				int[] blocks = new int[9];

				int n = 0;
				// Check every block. in each row and colummn
				for (int jj = j; jj < j + 3; jj++) {

					for (int ii = i; ii < i + 3; ii++) {
						blocks[n++] = values[jj][ii];

						if (repeatOrNot(blocks))
							return false;
					}
				}
			}
		}
		return true;
	}

	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull() {

		// build two dimension for loop(for-loop inside for-loop )
		for (int j = 0; j < values.length; j++) {
			// check each cell is 0 or not, if it is 0, return false
			for (int i = 0; i < values[j].length; i++) {
				if (values[j][i] == 0) {
					return false;
				}
			}

		}
		return true;
	}

	//
	// Returns true if x is a Grid and, for every (i,j),
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x) {
		Grid grd = (Grid) x;

		// build two dimension for-loop
		for (int i = 0; i < values.length; i++) {

			for (int j = 0; j < values[i].length; j++) {
				// if value from x is equal to value from this object
				if (this.values[i][j] != grd.values[i][j]) {
					return false;
				}
			}
		}
		return true;

	}
}

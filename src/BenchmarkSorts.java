import java.util.Random;

/**
 * @title BenchmarkSorts
 * @author Megan Tran
 * @date 2017
 * @purpose class that holds the logic of benchmarking datasets. There will be a
 *          total of 10 datasets. It's constructor has an array parameter that
 *          has different sizes for each data set. It holds the method to run
 *          the sorting bench mark as well as a method to display the report.
 */
public class BenchmarkSorts {
	public int[] dataset1, dataset2, dataset3, dataset4, dataset5, dataset6, dataset7,
			dataset8, dataset9, dataset10;
	public long critCountRec, critCountRec2, critCountIter, critCountIter2;
	public long executionTimeRec, executionTimeRec2, executionTimeIter, executionTimeIter2;
	long count;
	long time;
	public long variance = 0;
	private long[][]report = new long[10][9];
	private QuickSort sort = new QuickSort();
	//the parameter array holds the sizes for each dataset.
	BenchmarkSorts(int[] sizes) {
		dataset1 = new int[sizes[0]];
		dataset2 = new int[sizes[1]];
		dataset3 = new int[sizes[2]];
		dataset4 = new int[sizes[3]];
		dataset5 = new int[sizes[4]];
		dataset6 = new int[sizes[5]];
		dataset7 = new int[sizes[6]];
		dataset8 = new int[sizes[7]];
		dataset9 = new int[sizes[8]];
		dataset10 = new int[sizes[9]];

	}//end constructor.

	/*
	 * This method runs benchmark sorting for quick sort. For each dataset the
	 * following happens:
	 * 
	 * 50 times, each data set is filled with random numbers. The data set is
	 * then sorted using two algorithms - recursive and iterative quicksort. The
	 * critical operation count and run time is saved continually for each run
	 * (out of 50 runs). These numbers are averaged and placed in a matrix array
	 * named "report" in an order so that they can be printed out the same for
	 * each data set.
	 */
	public void runSorts() throws UnsortedException { 	
		//code block for running sorting on the first data set
		for (int i = 0; i < 50; i++){
			for (int j = 0; j < dataset1.length; j++) {
				dataset1[j] = randomNum();
			}
			int[]sortedRec = sort.recursiveSort(dataset1);
			for (int k = 1; k < sortedRec.length; k++) {
		        if (sortedRec[k-1] > sortedRec[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset1);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[0][0] = dataset1.length;
		report[0][1] = critCountRec/50;
		report[0][2] = (long) Math.sqrt(getVariance(report[0][1], critCountRec2, dataset1));
		report[0][3] = executionTimeRec/50;
		report[0][4] = (long) Math.sqrt(getVariance(report[0][3], executionTimeRec2, dataset1));
		report[0][5] = critCountIter/50;
		report[0][6] = (long) Math.sqrt(getVariance(report[0][5], critCountIter2, dataset1));
		report[0][7] = executionTimeIter/50;
		report[0][8] = (long) Math.sqrt(getVariance(report[0][7], executionTimeIter2, dataset1));
		resetCounts();
		// end block 1
		
		// code block for running sorting on the second data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset2.length; j++) {
				dataset2[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset2);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset2);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[1][0] = dataset2.length;
		report[1][1] = critCountRec/50;
		report[1][2] = (long) Math.sqrt(getVariance(report[1][1], critCountRec2, dataset2));
		report[1][3] = executionTimeRec/50;
		report[1][4] = (long) Math.sqrt(getVariance(report[1][3], executionTimeRec2, dataset2));
		report[1][5] = critCountIter/50;
		report[1][6] = (long) Math.sqrt(getVariance(report[1][5], critCountIter2, dataset2));
		report[1][7] = executionTimeIter/50;
		report[1][8] = (long) Math.sqrt(getVariance(report[1][7], executionTimeIter2, dataset2));
		resetCounts();
		// end block 2

		// code block for running sorting on the third data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset3.length; j++) {
				dataset3[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset3);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset3);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[2][0] = dataset3.length;
		report[2][1] = critCountRec/50;
		report[2][2] = (long) Math.sqrt(getVariance(report[2][1], critCountRec2, dataset3));
		report[2][3] = executionTimeRec/50;
		report[2][4] = (long) Math.sqrt(getVariance(report[2][3], executionTimeRec2, dataset3));
		report[2][5] = critCountIter/50;
		report[2][6] = (long) Math.sqrt(getVariance(report[2][5], critCountIter2, dataset3));
		report[2][7] = executionTimeIter/50;
		report[2][8] = (long) Math.sqrt(getVariance(report[2][7], executionTimeIter2, dataset3));
		resetCounts();
		// end block 3
		
		// code block for running sorting on the fourth data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset4.length; j++) {
				dataset4[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset4);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset4);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[3][0] = dataset4.length;
		report[3][1] = critCountRec / 50;
		report[3][2] = (long) Math.sqrt(getVariance(report[3][1], critCountRec2, dataset4));
		report[3][3] = executionTimeRec / 50;
		report[3][4] = (long) Math.sqrt(getVariance(report[3][3], executionTimeRec2, dataset4));
		report[3][5] = critCountIter / 50;
		report[3][6] = (long) Math.sqrt(getVariance(report[3][5], critCountIter2, dataset4));
		report[3][7] = executionTimeIter / 50;
		report[3][8] = (long) Math.sqrt(getVariance(report[3][7], executionTimeIter2, dataset4));
		resetCounts();
		// end block 4

		// code block for running sorting on the fifth data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset5.length; j++) {
				dataset5[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset5);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset5);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[4][0] = dataset5.length;
		report[4][1] = critCountRec / 50;
		report[4][2] = (long) Math.sqrt(getVariance(report[4][1], critCountRec2, dataset5));
		report[4][3] = executionTimeRec / 50;
		report[4][4] = (long) Math.sqrt(getVariance(report[4][3], executionTimeRec2, dataset5));
		report[4][5] = critCountIter / 50;
		report[4][6] = (long) Math.sqrt(getVariance(report[4][5], critCountIter2, dataset5));
		report[4][7] = executionTimeIter / 50;
		report[4][8] = (long) Math.sqrt(getVariance(report[4][7], executionTimeIter2, dataset5));
		resetCounts();
		// end block 5

		// code block for running sorting on the sixth data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset6.length; j++) {
				dataset6[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset6);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset6);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[5][0] = dataset6.length;
		report[5][1] = critCountRec / 50;
		report[5][2] = (long) Math.sqrt(getVariance(report[5][1], critCountRec2, dataset6));
		report[5][3] = executionTimeRec / 50;
		report[5][4] = (long) Math.sqrt(getVariance(report[5][3], executionTimeRec2, dataset6));
		report[5][5] = critCountIter / 50;
		report[5][6] = (long) Math.sqrt(getVariance(report[5][5], critCountIter2, dataset6));
		report[5][7] = executionTimeIter / 50;
		report[5][8] = (long) Math.sqrt(getVariance(report[5][7], executionTimeIter2, dataset6));
		resetCounts();
		// end block 6

		// code block for running sorting on the seventh data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset7.length; j++) {
				dataset7[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset7);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset7);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[6][0] = dataset7.length;
		report[6][1] = critCountRec / 50;
		report[6][2] = (long) Math.sqrt(getVariance(report[6][1], critCountRec2, dataset7));
		report[6][3] = executionTimeRec / 50;
		report[6][4] = (long) Math.sqrt(getVariance(report[6][3], executionTimeRec2, dataset7));
		report[6][5] = critCountIter / 50;
		report[6][6] = (long) Math.sqrt(getVariance(report[6][5], critCountIter2, dataset7));
		report[6][7] = executionTimeIter / 50;
		report[6][8] = (long) Math.sqrt(getVariance(report[6][7], executionTimeIter2, dataset7));
		resetCounts();
		// end block 7
		
		// code block for running sorting on the eight data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset8.length; j++) {
				dataset8[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset8);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset8);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[7][0] = dataset8.length;
		report[7][1] = critCountRec / 50;
		report[7][2] = (long) Math.sqrt(getVariance(report[7][1], critCountRec2, dataset8));
		report[7][3] = executionTimeRec / 50;
		report[7][4] = (long) Math.sqrt(getVariance(report[7][3], executionTimeRec2, dataset8));
		report[7][5] = critCountIter / 50;
		report[7][6] = (long) Math.sqrt(getVariance(report[7][5], critCountIter2, dataset8));
		report[7][7] = executionTimeIter / 50;
		report[7][8] = (long) Math.sqrt(getVariance(report[7][7], executionTimeIter2, dataset8));
		resetCounts();
		// end block 8

		// code block for running sorting on the ninth data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset9.length; j++) {
				dataset9[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset9);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset9);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[8][0] = dataset9.length;
		report[8][1] = critCountRec / 50;
		report[8][2] = (long) Math.sqrt(getVariance(report[8][1], critCountRec2, dataset9));
		report[8][3] = executionTimeRec / 50;
		report[8][4] = (long) Math.sqrt(getVariance(report[8][3], executionTimeRec2, dataset9));
		report[8][5] = critCountIter / 50;
		report[8][6] = (long) Math.sqrt(getVariance(report[8][5], critCountIter2, dataset9));
		report[8][7] = executionTimeIter / 50;
		report[8][8] = (long) Math.sqrt(getVariance(report[8][7], executionTimeIter2, dataset9));
		resetCounts();
		// end block 9

		// code block for running sorting on the final data set
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < dataset10.length; j++) {
				dataset10[j] = randomNum();
			}
			int[] sortedRec = sort.recursiveSort(dataset10);
			for (int k = 1; k < sortedRec.length; k++) {
				if (sortedRec[k - 1] > sortedRec[k]) {
					throw new UnsortedException();
				}
			}
			count = sort.getCount();
			critCountRec += count;
			critCountRec2 += count*count;
			time = sort.getTime();
			executionTimeRec += time;
			executionTimeRec2 += time*time;
			
			int[]sortedIter = sort.iterativeSort(dataset10);
			for (int k = 1; k < sortedIter.length; k++) {
		        if (sortedIter[k-1] > sortedIter[k]) {
		        	throw new UnsortedException();
		        }
		    }
			count = sort.getCount();
			critCountIter += count;
			critCountIter2 = count*count;
			time = sort.getTime();
			executionTimeIter += time;
			executionTimeIter2 += time*time;
		}
		report[9][0] = dataset10.length;
		report[9][1] = critCountRec / 50;
		report[9][2] = (long) Math.sqrt(getVariance(report[9][1], critCountRec2, dataset10));
		report[9][3] = executionTimeRec / 50;
		report[9][4] = (long) Math.sqrt(getVariance(report[9][3], executionTimeRec2, dataset10));
		report[9][5] = critCountIter / 50;
		report[9][6] = (long) Math.sqrt(getVariance(report[9][5], critCountIter2, dataset10));
		report[9][7] = executionTimeIter / 50;
		report[9][8] = (long) Math.sqrt(getVariance(report[9][7], executionTimeIter2, dataset10));
		resetCounts();
		// end block 7
	}//end method

	/*
	 * This method displays the table struture of all the benchmark numbers that
	 * have been collected by the current run. Displaying only works if the
	 * report array is filled with necessary information by running the runSorts
	 * method.
	 */
	public void displayReport() {
		System.out.printf(String.format("%20s %2s %59s %31s %45s", "Dataset Size N", "|", "Recursive", "|", "Iterative"));
		System.out.println();
		System.out.print("----------------------------------------------"
				+ "-----------------------------------------------------"
				+ "-----------------------------------------------------"
				+ "-----------------------------------------------------");
		System.out.println();
		System.out.printf(
				String.format("%21s %22s %22s %22s %22s %22s %22s %22s %22s",
						"", "|   Avg Crit Op Count  |",
						"Std Dev of Count  |", "Avg Run Time  |",
						"Std Dev of Time  |", 
						"Avg Crit Op Count  |", "Std Dev of Count  |",
						"Avg Run Time  |", "Std Dev of Time  |"));
		System.out.println();
		System.out.print("----------------------------------------------"
				+ "-----------------------------------------------------"
				+ "-----------------------------------------------------"
				+ "-----------------------------------------------------");
		System.out.println();
		for(int i = 0; i < 10; i ++){
			for(int j= 0; j < 9; j++){
				System.out.printf(String.format("%15d %7s", report[i][j], "|"));
			}
			System.out.println("");
			System.out.print("----------------------------------------------"
					+ "-----------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "-----------------------------------------------------");
			System.out.println("");
		}
	}//end method
	
	
	/*
	 * calculates and returns the variance number needed to calculate standard 
	 * deviation.
	 */
	public long getVariance(long mean, long mean2, int[]set){
		variance = (set.length * mean2 - mean * mean) / (set.length * set.length);
		return variance;
	}
	
	/*
	 * resets the cumulative critical operation counts and execution times variables.
	 */
	private void resetCounts(){
		critCountRec = 0;
		critCountRec2 = 0;
		critCountIter = 0;
		critCountIter2 = 0;
		executionTimeRec = 0;
		executionTimeIter = 0;
		executionTimeRec2 = 0;
		executionTimeIter2 = 0;
	}//end method

	/*
	 * Returns a random integer in between 1- 2000
	 */
	private static int randomNum() {
		Random rand = new Random();
		int randomNum = rand.nextInt(2000);
		return randomNum;
	}//end method
	
} //end class

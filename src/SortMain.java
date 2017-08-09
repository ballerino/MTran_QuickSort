/**
 * @title SortMain
 * @author Megan Tran
 * @date 2017
 * @purpose this class holds the main method of the program. It initializes the n
 *          sizes that will be used for the benchmarking of quick sort. Creates
 *          an instance of BenchmarkSorts to run the benchmarking on 10 data
 *          sets. Then, it calls the display method to output results to the
 *          console.
 *
 */
public class SortMain {

	/*
	 * main method creates BenchmarkSorts object to run benchmarking and display results.
	 */
	public static void main(String[] args) throws UnsortedException {
		int[] sizes = {50, 100, 250, 500, 750, 1000, 2500, 3500, 5000, 10000};
		BenchmarkSorts bs = new BenchmarkSorts(sizes);
		 bs.runSorts();
		 bs.displayReport();

	}//end method

}//end class

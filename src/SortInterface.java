/**
 * @title QuickSort
 * @author Megan Tran
 * @date 2017
 * @purpose an interface class implemented by QuickSort. It makes sure that any
 *          class implementing the sort interface has a recursive sort method,
 *          an iterative sort method, and methods to get the critical operation
 *          count and run time of a sort.
 *
 */

public interface SortInterface {
	public int[] recursiveSort(int[] list);
	public int[] iterativeSort(int[] list);
	public int getCount();
	public long getTime();
}//end class

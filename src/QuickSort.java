import java.util.Stack;

/**
 * @title QuickSort
 * @author Megan Tran
 * @date 2017
 * @purpose class that implements the SortInterface interface. I implement both
 *          the recursive and iterative algorithms for quick sort. I keep track
 *          of critical operations (the swap of sorting) and run time for the
 *          algorithm.
 *
 */
public class QuickSort implements SortInterface {
	private int criticalCount = 0;
	public long runTime = 0;
	
	/*
	 * runs recursive quicksort on the parameter int array and returns the
	 * sorted list in a temp variable.
	 * @see SortInterface#recursiveSort(int[])
	 */
	@Override
	public int[] recursiveSort(int[] list) {
		int[]temp = quickSortRec(list, 0, list.length-1);
		return temp;
	}// end method
	
	/*
	 * helper method for recursiveSort method. A method where the logic of the
	 * recursive algorithm for quick sort lies. It returns an array sorted using
	 * recursive quick sort.
	 */
	private int[] quickSortRec(int[] list, int front, int end){
		int count = 0;
		int i = front, j = end;
		int pivot = list[front + (end - front) / 2];
		long startTime = System.nanoTime();
		while (i <= j) {	
			while (list[i] < pivot) {
				i++;
			}	
			while (list[j] > pivot) {
				j--;
			}
			if (i <= j) {
				// swap the elements of i and j
				swap(list, i, j);
				count++;
				i++;
				j--;
			}
		}
		//now, recursively call the method until it is fully sorted
		if(front < j){
			quickSortRec(list, front, j);
		}
		if(i < end){;
			quickSortRec(list, i, end);
		}
		long endTime = System.nanoTime();
		runTime = endTime - startTime;
		criticalCount = count;
		return list;
	}//end method
	
	/*
	 * private helper method for recursive and iterative quick sort method. This method swaps
	 * the first int with the second int in the array.
	 */
	private void swap(int[] array, int first, int second){
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}// end method

	/*
	 * runs iterative quicksort on the parameter int array and returns the
	 * sorted list once sorting is finished.
	 * @see SortInterface#iterativeSort(int[])
	 */
	@Override
	public int[] iterativeSort(int[] list){
		quickSortIter(list);
		return list;
		
	}// end method

	/*
	 * private helper method for iterativeSort method. This method holds the
	 * logic of sorting an array using iterative quick sort. It uses a stack to
	 * hold all the values and pops them once they are sorted. sorting ends when
	 * the stack is empty.
	 */
	private void quickSortIter(int[] list) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(list.length);
		long startTime = System.nanoTime();
		while (!stack.isEmpty()) {
			int end = stack.pop();
			int start = stack.pop();
			if (end - start < 2) {
				continue;
			}
			int pivot = start + ((end - start) / 2);
			pivot = partition(list, pivot, start, end);
			stack.push(pivot + 1);
			stack.push(end);
			stack.push(start);
			stack.push(pivot);
		}
		long endTime = System.nanoTime();
		runTime = endTime - startTime;
		

	}//end method

	/*
	 * a partition helper method used for iterative quick sort. the method
	 * ensures that elements that are less than the pivot element is swapped to
	 * the left of the array and element higher than the pivot are swapped to
	 * the right end of the array.
	 */
	private int partition(int[] input, int position, int start,
			int end) {
		int count = 0;
		int low = start;
		int high = end - 2;
		int piv = input[position];
		swap(input, position, end - 1);
		while (low < high) {
			if (input[low] < piv) {
				low++;
			} else if (input[high] >= piv) {
				high--;
			} else {
				count++;
				swap(input, low, high);
				
			}
		}
		int index = high;
		if (input[high] < piv) {
			index++;
		}
		swap(input, end - 1, index);
		count++;
		criticalCount += count;
		return index;
	}// end method

	/*
	 * returns and resets the criticalCount of the current sort.
	 * @see SortInterface#getCount()
	 */
	@Override
	public int getCount() {
		int temp = criticalCount;
		criticalCount = 0;
		return temp;
	}// end method. 

	/*
	 * returns and resets the runTime of the current sort,
	 * @see SortInterface#getTime()
	 */
	@Override
	public long getTime() {
		long temp = runTime;
		runTime = 0;
		return temp;
	}//end method

}//end class

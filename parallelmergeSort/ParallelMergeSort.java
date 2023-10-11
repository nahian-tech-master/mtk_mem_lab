import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ParallelMergeSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        // Create a ForkJoinPool with the desired parallelism level
        ForkJoinPool pool = new ForkJoinPool();

        // Create a task for sorting the entire array
        ParallelMergeSortTask task = new ParallelMergeSortTask(arr);

        // Invoke the task and get the result
        int[] sortedArray = pool.invoke(task);

        // Print the sorted array
        System.out.println(Arrays.toString(sortedArray));
    }

    static class ParallelMergeSortTask extends RecursiveTask<int[]> {
        private final int[] array;

        ParallelMergeSortTask(int[] array) {
            this.array = array;
        }

        @Override
        protected int[] compute() {
            if (array.length <= 1) {
                return array;
            }

            int mid = array.length / 2;

            // Divide the array into two halves
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            // Create tasks for sorting the left and right halves
            ParallelMergeSortTask leftTask = new ParallelMergeSortTask(left);
            ParallelMergeSortTask rightTask = new ParallelMergeSortTask(right);

            // Fork both tasks to sort in parallel
            leftTask.fork();
            rightTask.fork();

            // Join the results
            int[] sortedLeft = leftTask.join();
            int[] sortedRight = rightTask.join();

            // Merge the sorted halves
            return merge(sortedLeft, sortedRight);
        }

        private int[] merge(int[] left, int[] right) {
            int[] merged = new int[left.length + right.length];
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    merged[k++] = left[i++];
                } else {
                    merged[k++] = right[j++];
                }
            }

            while (i < left.length) {
                merged[k++] = left[i++];
            }

            while (j < right.length) {
                merged[k++] = right[j++];
            }

            return merged;
        }
    }
}

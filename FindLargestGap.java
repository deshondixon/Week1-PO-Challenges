import java.util.*;

public class FindLargestGap {
    public static void main(String args[]) {
        int[] elements = {5, 10, 2, 8, 1, 6};
//        int[] elements = {20, 15, 25, 30, 35, 40};

        int[] results = findLargestGap(elements);
        System.out.println("Largest gap between " + results[0] + " and " + results[1] +
                " is " + results[2]);
    }

    public static int[] findLargestGap(int[] elements) {
        int[] results = new int[3];
        quickSort(elements, 0, elements.length - 1);
        int prev = elements[0];
        int largestGap = 0;
        int first = prev;
        int second = prev;
        for(int i = 1; i < elements.length; i++) {
            int diff = elements[i] - prev;
            if(diff > largestGap) {
                largestGap = diff;
                first = prev;
                second = elements[i];
            }
            prev = elements[i];
        }
        results[0] = first;
        results[1] = second;
        results[2] = largestGap;
        return results;
    }

    private static void quickSort(int[] elements, int low, int high) {
        if(low >= high) return;
        int pivot = partition(elements, low, high);
        quickSort(elements, low, pivot-1);
        quickSort(elements, pivot+1, high);
    }

    private static int partition(int[] elements, int pivot, int high) {
        int gtPtr = pivot;
        final int pivotElement = elements[high];
        while(gtPtr < high) {
            if(elements[gtPtr] < pivotElement) {
                int temp = elements[gtPtr];
                elements[gtPtr] = elements[pivot];
                elements[pivot] = temp;
                pivot++;
            }
            gtPtr++;
        }
        elements[high] = elements[pivot];
        elements[pivot] = pivotElement;
        return pivot;
    }
}

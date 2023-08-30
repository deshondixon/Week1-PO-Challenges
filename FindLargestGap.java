import java.util.*;

public class FindLargestGap {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input;
        int size;
        int[] elements;
        while(true) {
            System.out.println("enter array size (empty to exit): ");
            input = sc.nextLine();
            if(input.equals("")) break;
            size = Integer.parseInt(input);
            elements = new int[size];
            System.out.println("enter array values: ");
            for(int i = 0; i < size; i++) {
                elements[i] = sc.nextInt();
            }
            sc.nextLine();
            System.out.print('\n');
            int[] results = findLargestGap(elements);
            System.out.println("Sorted array: " + Arrays.toString(elements));
            System.out.println("Largest gap between " + results[0] + " and " + results[1] +
            " is " + results[2] + '\n');
        }
        sc.close();
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

    // could probably handle duplicates better but it works
    private static void quickSort(int[] elements, int low, int high) {
        if(low >= high) return;
        int pivot = partition(elements, low, high);
        /*System.out.println("partitioned: " + Arrays.toString(elements));
        System.out.println("pivot: " + pivot);
        System.out.println("low: " + low);
        System.out.println("high: " + high);*/
        quickSort(elements, low, pivot-1);
        quickSort(elements, pivot+1, high);
    }

    private static int partition(int[] elements, int pivot, int high) {
        int gtPtr = pivot;
        int pivotElement = elements[high];
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

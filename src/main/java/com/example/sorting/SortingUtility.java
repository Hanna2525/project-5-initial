package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] a) {

        // TODO implement Gnome Sort here
        int pos = 0;
        while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(a, pos, pos - 1); // Use swap method
                pos--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] A) {

        // TODO implement Cocktail Shaker Sort here
        boolean swapped;
        do {
            swapped = false;

            // Forward pass
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1); // Use swap method
                    swapped = true;
                }
            }

            // Early exit if no swaps
            if (!swapped) break;

            swapped = false;

            // Backward pass
            for (int i = A.length - 2; i >= 0; i--) {
                if (A[i].compareTo(A[i + 1]) > 0) {
                    swap(A, i, i + 1); // Use swap method
                    swapped = true;
                }
            }
        } while (swapped);
    }


    public static <T extends Comparable<T>> void shellSort(T[] a) {

        // TODO implement Shell Sort here
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1}; // Ciura gap sequence
        int n = a.length;

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                T temp = a[i];
                int j;

                for (j = i; j >= gap && a[j - gap].compareTo(temp) > 0; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}

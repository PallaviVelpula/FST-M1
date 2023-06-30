package activities;

public class Activity4 {
    public static void main(String[] args) {
        int[] array1 = {87, 65, 5, 76, 34, 9, 54, 32};
        for (int i : array1) {
            System.out.println(i + " ");
        }
        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                int tmp = 0;
                if (array1[i] > array1[j]) {
                    tmp = array1[i];
                    array1[i] = array1[j];
                    array1[j] = tmp;
                }
            }

        }
        System.out.println("Array after sorting is: ");
        for (int l : array1) {
            System.out.println(l + " ");
        }
    }
}

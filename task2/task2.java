package Lesson1;

/*
2. Отсортируйте массив [5,6,3,2,5,1,4,9]
 */

import java.util.Arrays;

public class task2 {
    private static long count;

    public static void main(String[] args) {

        int[] array = new int[] {5,6,3,2,5,1,4,9};

        System.out.println("The original array:\n" + Arrays.toString(array));

        System.out.println("The sorted (increasing) array:\n" + Arrays.toString(sort(array)));

        assert Arrays.equals(sort(new int[]{}),new int[]{});

        assert Arrays.equals(sort(new int[]{1,2,3,1,2,3,3,2,1,3,2,1}),new int[]{1,1,1,1,2,2,2,2,3,3,3,3});

        assert Arrays.equals(sort(new int[]{-1,-2,-3,-4,-5,-6,-7,-8,-9,-10}),new int[]{10,-9,-8,-7,-6,-5,-4,-3,-2,-1});
    }

    public static int[] sort(int[] array) {
        count = 0;
        if (array == null){
            return null;
        }
        if (array.length == 0){
            return array;
        }

        return sort(array,0,array.length - 1);
    }

    public static int[] sort(int[] array, int low, int high) {
        if (low > high - 1){
            return new int[] { array[low] };
        }
        int mid = low + (high - low) / 2;

        return merge(sort(array,low,mid), sort(array,mid + 1, high));
    }


    public static int[] merge(int[] arrL, int[] arrR){
        int[] res = new int[arrL.length+arrR.length];
        int left = 0;
        int right =0;
        int resX = 0;

        while (left< arrL.length && right < arrR.length) {
            if (arrL[left] <= arrR[right])
                res[resX++] = arrL[left++];
            else {
                res[resX++] = arrR[right++];
                count += (arrL.length - left);
            }
        }

        while (left < arrL.length)
            res[resX++] = arrL[left++];

        while (right < arrR.length)
            res[resX++] = arrR[right++];

        return res;
    }
}

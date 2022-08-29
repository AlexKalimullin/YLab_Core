package Lesson1;

/*
1. Заполните двумерный массив случайным числами и выведите максимальное, минимальное и среднее значение.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class task1 {

    public static void main(String[] args) {

        int[][] array = completion();

        System.out.println("Your array:\n" + Arrays.deepToString(array));

        System.out.println(arrMaxMinAver(array));

    }

    public static int[][] completion(){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrWidth = 1;
        int arrHeight = 1;
        int rangeDown = 0;
        int rangeUp = 0;
        int correct = 0;

        try {
            System.out.println("Enter separated by a space array's width, height, down range and up range. For example: 10 10 -100 100");
            String s = bufferedReader.readLine();
            String[] sArr = s.split(" ");
            arrWidth = Integer.parseInt(sArr[0]);
            arrHeight = Integer.parseInt(sArr[1]);
            rangeDown = Integer.parseInt(sArr[2]);
            rangeUp = Integer.parseInt(sArr[3]);

            if (arrWidth<0 || arrHeight<0 || rangeDown>rangeUp){
                System.out.println("Incorrect value entered! Please, enter parameters again.");
                completion();
            }


        } catch (Exception e) {
            System.out.println("Incorrect value entered! Please, enter parameters again.");
            completion();
        }

        if (rangeDown<0 && rangeUp>=0){
            correct = 1;
        }

        int[][] array = new int[arrWidth][arrHeight];
        for (int i = 0; i < arrHeight; i++) {
            for(int j = 0; j< arrWidth; j++) {
                array[i][j] = (int) (Math.random() * (rangeUp - rangeDown + correct)) + rangeDown;
            }
        }
        return array;
    }

    public static String arrMaxMinAver(int[][] arr) {
        if (arr.length == 0){
            return "Array is empty. It is impossible to get values.";
        } else {
            int max = arr[0][0];
            int min = arr[0][0];
            int sum = 0;
            for (int i=0; i<arr.length; i++) {
                for (int j=0; j<arr[0].length; j++) {
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                    if (arr[i][j] < min) {
                        min = arr[i][j];
                    }
                    sum += arr[i][j];
                }
            }
            return "Max: " + max + "\nMin: " + min + "\nAverage: " + sum/(arr.length*arr[0].length);
        }
    }
}

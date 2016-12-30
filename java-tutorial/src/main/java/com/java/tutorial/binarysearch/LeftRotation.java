package com.java.tutorial.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by isa.kalinsaz on 30/12/2016.
 */
public class LeftRotation {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of integers");
        int numberOfInteger = scanner.nextInt();
        System.out.println("Enter the shifting value");
        int shiftValue = scanner.nextInt();
        int[] numbers = new int[numberOfInteger];

        scanner.nextLine();
        System.out.println(String.format("Enter the space separated integer %d values", numberOfInteger));
        final String[] lines = scanner.nextLine().split(" ");

        if (numberOfInteger > Math.pow(10, 5))
            return;

        if (shiftValue > numberOfInteger)
            return;

        for (int i = 0; i < numberOfInteger; i++) {
            numbers[i] = Integer.valueOf(lines[i]);
            if (numbers[i] > Math.pow(10, 6))
                return;
        }
        numbers = shiftArrayAsMuchValue(shiftValue, numbers);
        for (int i = 0; i < numberOfInteger; i++) {
            System.out.print(numbers[i] + " ");
        }

    }

    private static int[] shiftArrayAsMuchValue(int shiftingValue, int[] numbers) {

        int numberOfInteger = numbers.length;
        int[] shiftedNumbers = new int[numberOfInteger];

        for (int i = 0; i < numberOfInteger; i++) {
            shiftedNumbers[i] = numbers[(i + shiftingValue) % numberOfInteger];
        }

        return shiftedNumbers;
    }


}

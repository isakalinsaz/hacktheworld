package com.java.tutorial.binarysearch;

import java.util.Scanner;

/**
 * Created by isa.kalinsaz on 29/12/2016.
 */
public class DynamicArray {

    public static void main(String[] args) {

        int numberOfSequence = 0;
        int numberOfQuery = 0;
        int lastAns = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Sequence");
        numberOfSequence = scanner.nextInt();

        System.out.println("Enter the number of Queries");
        numberOfQuery = scanner.nextInt();

        if (numberOfSequence < 1)
            return;

        if (numberOfQuery > Math.pow(10, 5))
            return;
        /*------------------------------------------------------------*/

        int[][] seqList = new int[numberOfSequence][numberOfSequence];
        int[][] queries = new int[numberOfQuery][3];
        int[] a =new int[numberOfQuery];

        scanner.nextLine();


        for (int i = 0; i < numberOfQuery; i++) {
            String values = scanner.nextLine();
            String[] line = values.split(" ");
            queries[i][0] = Integer.valueOf(line[0]);
            queries[i][1] = Integer.valueOf(line[1]);
            queries[i][2] = Integer.valueOf(line[2]);

            if (queries[i][2] > Math.pow(10, 9))
                return;
        }

        for (int i = 0; i < numberOfQuery; i++) {

            if (queries[i][0] == 1) {
                int index = (queries[i][1] ^ lastAns) % numberOfSequence;
                seqList[index][a[index]] = queries[i][2];
                a[index]++;
            }else{
                int nextIndex = (queries[i][1] ^ lastAns) % numberOfSequence;
                int size = queries[i][2] % a[nextIndex];
                lastAns = seqList[nextIndex][size];
                System.out.println(lastAns);
            }
        }


    }
}

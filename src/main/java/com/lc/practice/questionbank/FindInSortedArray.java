package com.lc.practice.questionbank;

import java.util.Arrays;
import java.util.List;

/*
import java.util.Arrays;
https://www.geeksforgeeks.org/binary-search/
You are given a sorted array of integer and a number to find

Return a boolean true if number is found in array
Return a boolean false if number is not found in array

Example 1
Input: nums = [1,2,3,4,5] 3
Output: true
Explanation: 3 is in position 2 of the array

Example 2
Input: nums = [1,2,3,4,5] 6
Output: false
Explanation: 6 is not in the input array
 */
public class FindInSortedArray {
    static boolean suboptimalSolution(int[] input, int find) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == find) {
                return true;
            }
        }
        return false;
    }

    static boolean optimalSolution(int[] input, int find) {
        return checkHighLow(input, find, 0, input.length - 1);
    }

    static boolean checkHighLow(int[] input, int find, int lowIndex, int highIndex) {
        int middleIndex = (lowIndex + highIndex) / 2;
        if (input[middleIndex] == find) {
            return true;
        } else if (highIndex == lowIndex || highIndex < lowIndex) {
            return false;
        } 
        else if (input[middleIndex] < find) {
            return checkHighLow(input, find, middleIndex + 1, highIndex);
        }
        return checkHighLow(input, find, lowIndex, middleIndex - 1);
    }
}

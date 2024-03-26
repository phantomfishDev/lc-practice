package com.lc.practice.questionbank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/description/
You are given an array of integer and a target sum of 2 integers

Return a boolean true if two sum found
Return a boolean false if two sum not found

Example 1
Input: nums = [1,2,3,4,5] 3
Output: true
Explanation: 3 is in position 2 of the array

Example 2
Input: nums = [1,2,3,4,5] 1
Output: false
Explanation: no two numbers in the array add up to 1
 */
public class TwoSum {
    static boolean suboptimalSolution(int[] input, int sum) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i != j && input[i] + input[j] == sum) {
                    return true;
                } 
            }
        }
        return false;
    }

    static boolean optimalSolution(int[] input, int sum) {
        Map<Integer, Integer> values = new HashMap<>();
        for (int i = 0; i < input.length; i ++) {
            int val = input[i];
            if (values.containsKey(val)) {
                values.put(val, values.get(val) + 1);
            }
            else {
                values.put(val, 1);
            }
        }
        for (int i = 0; i < input.length; i++) {
            int neededValue = sum - input[i];
            // check if needed value is not this same value
            if (values.containsKey(neededValue)) {
                if (neededValue == input[i]) {
                    return values.get(neededValue) > 1;
                }
                return true;
            }
        }
        return false;
    }
}

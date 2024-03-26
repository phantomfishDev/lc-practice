package com.lc.practice.questionbank;

import java.util.HashMap;
import java.util.Map;

/*
import java.util.HashMap;
https://leetcode.com/problems/fibonacci-number/description/
You are given a integer >= 0

Return the Fibonacci number of the input

Example 1
Input: nums = 3
Output: 2
Explanation: F(3) = F(2) + F(1) = F(1) + F(0) + F(1)

Example 2
Input: nums = 4
Output: 3
Explanation: F(4) = F(3) + F(2) = F(2) + F(1) + F(2) = F(1) + F(0) + F(1) + F(2) = F(1) + F(0) + F(1) + F(1) + F(0)

Base cases
F(1) = 1
F(0) = 0
F(n) = F(n - 1) + F(n - 2)
 */

public class Fibonacci {
    static int suboptimalSolution(int input) {
        if (input == 1) {
            return 1;
        } 
        if (input == 0) {
            return 0;
        }
        return suboptimalSolution(input - 1) + suboptimalSolution(input - 2);
    }

    static Map<Integer, Integer> cache = new HashMap<>();

    static int optimalSolution(int input) {
        if (cache.containsKey(input)) {
            return cache.get(input);
        }
        if (input == 1 || input == 0) {
            return input;
        }
        int result = optimalSolution(input - 1) + optimalSolution(input - 2);
        cache.put(input, result);
        
        return result;
    }
}

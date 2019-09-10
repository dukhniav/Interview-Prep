package com.java2novice.junit.tests;

import org.junit.Test;

import com.java2novice.junit.samples.Employee;

import static org.junit.Assert.*;

/**
 * coins
 */
public class coins {

    public static int arrangeCoins(int n) {

        return 3;
    }

    public static void main(String[] args) {
        int coins = 5;

        System.out.println(arrangeCoins(coins));
        assert (arrangeCoins(5) == 3) : "Wrong answer";

    }
}
package com.hank.BundleCalculator.hank_BundleCalculator_version3.progress;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BundleDistributionCalculatorTest {
    private BundleDistributionCalculator bundleDistributionCalculator;

    @Before
    public void setUp() throws Exception {
        bundleDistributionCalculator = new BundleDistributionCalculator();
    }

    @Test
    public void bundleDistributionCalculate() {

        int[] candidates1 = {9, 5, 3};
        int target1 = 4;
        List<Integer> results1 = bundleDistributionCalculator.bundleDistributionCalculate(candidates1, target1);
        assertEquals(Arrays.asList(5), results1);

        //----------------------------------------------------------
        int[] candidates2 = {9, 5, 3};
        int target2 = 19;
        List<Integer> results2 = bundleDistributionCalculator.bundleDistributionCalculate(candidates2, target2);
        assertEquals(Arrays.asList(9, 5, 5), results2);
        //-----------------------------------------------------------
        int[] candidates3 = {9, 5, 3};
        int target3 = 6;
        List<Integer> results3 = bundleDistributionCalculator.bundleDistributionCalculate(candidates3, target3);
        assertEquals(Arrays.asList(3, 3), results3);
        //------------------------------------------------------------
        int[] candidates4 = {9, 5, 3};
        int target4 = 10;
        List<Integer> results4 = bundleDistributionCalculator.bundleDistributionCalculate(candidates4, target4);
        assertEquals(Arrays.asList(5, 5), results4);
        //------------------------------------------------------------
        int[] candidates5 = {9, 5, 3};
        int target5 = 13;
        List<Integer> results5 = bundleDistributionCalculator.bundleDistributionCalculate(candidates5, target5);
        assertEquals(Arrays.asList(5, 5, 3), results5);
        //-------------------------------------------------------------
        int[] candidates6 = {9, 5, 3};
        int target6 = 2;
        List<Integer> results6 = bundleDistributionCalculator.bundleDistributionCalculate(candidates6, target6);
        assertEquals(Arrays.asList(3), results6);
        //-------------------------------------------------------------
        int[] candidates7 = {9, 5, 3};
        int target7 = 7;
        List<Integer> results7 = bundleDistributionCalculator.bundleDistributionCalculate(candidates7, target7);
        assertEquals(Arrays.asList(5, 3), results7);
        //-------------------------------------------------------------
        int[] candidates8 = {9, 5, 3};
        int target8 = 137;
        List<Integer> results8 = bundleDistributionCalculator.bundleDistributionCalculate(candidates8, target8);
        assertEquals(Arrays.asList(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 5, 5, 5, 5), results8);
        //-------------------------------------------------------------
        int[] candidates9 = {9, 5, 3};
        int target9 = 0;
        List<Integer> results9 = bundleDistributionCalculator.bundleDistributionCalculate(candidates9, target9);
        assertEquals(Arrays.asList(), results9);
        //     //-------------------------------------------------------------
        int[] candidates10 = {9, 5, 3};
        int target10 = -1;
        List<Integer> results10 = bundleDistributionCalculator.bundleDistributionCalculate(candidates10, target10);
        assertEquals(Arrays.asList(), results10);
    }
}
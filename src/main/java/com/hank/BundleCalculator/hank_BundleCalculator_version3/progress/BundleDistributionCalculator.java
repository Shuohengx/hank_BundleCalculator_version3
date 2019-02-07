package com.hank.BundleCalculator.hank_BundleCalculator_version3.progress;

import java.util.*;


public class BundleDistributionCalculator {


    public  List<Integer> bundleDistributionCalculate(int[] candidates, int target){
        List<List<Integer>> results= new ArrayList<>();
        List<List<Integer>> results_proximity = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer> bundle_distribution;

        Arrays.sort(candidates);
        briefResultCalculate(results, results_proximity,0, 0, tmp, candidates, target);

        if(results.size()!=0)
            bundle_distribution = results.get(results.size() - 1);
        else
            bundle_distribution = resultSelect(results_proximity);
        Collections.reverse(bundle_distribution);
        return bundle_distribution;
    }


    //计算出精确的所有组合以及无法精确的所有组合。使用的剪枝手法
    private void briefResultCalculate(List<List<Integer>> resAccurate, List<List<Integer>> resProxi,
                                      int curIdx, int sum, List<Integer> tmp, int[] candidates,
                                      int target) {
        if (sum > target) {
            resProxi.add(new ArrayList<>(tmp));
            return;
        }
        if (sum == target) {
            resAccurate.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = curIdx; i < candidates.length; i++) {
            sum += candidates[i];
            tmp.add(candidates[i]);
            briefResultCalculate(resAccurate, resProxi, i, sum, tmp, candidates, target);
            tmp.remove(tmp.size() - 1);
            sum -= candidates[i];
        }
    }
    //从不精确的组合中筛选出最精确的
    private List<Integer> resultSelect(List<List<Integer>> results){
        long sum_min=0;
        List<Integer> result_selected = new ArrayList<>();

        for(List<Integer> result:results){
            long sum = result.stream().mapToInt((x)->x).summaryStatistics().getSum();
            if(result_selected.size()==0|(sum<=sum_min&&result.size()<result_selected.size())){
                sum_min = sum;
                result_selected = result;
            }
        }
        return result_selected;
    }
}

package com.wh;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2022/12/27 9:21
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 *
 */
public class no38 {
    //深度优先遍历+回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //简单优化,对candidates排序
        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (candidates.length==0){
            return res;
        }
        dfs(candidates,target,0,new ArrayList<Integer>(),res);
        return res;
    }

    /**
     *
     * @param candidates 给定数组
     * @param target 目标值
     * @param begin 从数组的哪一个值开始遍历,不是每一次都从第一个开始遍历,可以避免重复
     * @param res 结果集
     */
    public void dfs(int[] candidates, int target,int begin,List<Integer> path, List<List<Integer>> res) {
        if (target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if (target<0){
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target-candidates[i]<0){
                break;
            }
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],i,path,res);
            path.remove(path.size()-1);
        }
    }
}
class Test38{
    @Test
    void test38(){
        //[2,3,6,7]
        //7
        int[] candidates ={2,3,6,7};
        int target = 7;
        List<List<Integer>> lists = new no38().combinationSum(candidates, target);
        System.out.println(lists);
    }
}
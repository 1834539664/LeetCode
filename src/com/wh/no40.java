package com.wh;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author WH
 * @version 1.0
 * @date 2022/12/28 11:19
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为
 * target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。

 */
public class no40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayList<Integer>(),res,0);
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (!result.contains(res.get(i))){
                result.add(res.get(i));
            }
        }
        return result;
    }

    public void dfs(int[] candidates,int target,List<Integer> path,List<List<Integer>>res,int begin){
        if (target==0){
            res.add(path);
        }
        if (candidates.length==begin || target<0){
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target-candidates[i]<0){
                break;
            }
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],new ArrayList<>(path),res,i+1);
            path.remove(path.size()-1);
        }
    }
}
class Test40{
    @Test
    void test40(){
        //[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
        //30
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int tatget = 30;
        List<List<Integer>> lists = new no40().combinationSum2(candidates, tatget);
        System.out.println(lists);
    }
}
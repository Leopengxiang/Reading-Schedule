import java.util.*;
class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // 鲁棒性
        List<List<Integer>> resultL = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return resultL;
        }
        

        // 首先将数组进行排序；
        Arrays.sort(nums);
        
        for (int base = 0; base < nums.length - 2; base++) {
            // 选定最右端(最小值)作为base, 当最小值>0 时， 再无合适的base值，跳出循环查找结束 
            if (nums[base] > 0) {
                break;
            }
            
            // base节点的去重
            if (base > 0 && nums[base] == nums[base - 1]) {
                    continue;
                }
                
            // 设定两端节点
            int L = base + 1;
            int R = nums.length - 1;
            while (L < R) {
                // 两端节点的去重操作
                if (L > base + 1 && nums[L] == nums[L - 1]) {
                    L++;
                    continue;
                }
                if (R < nums.length - 1 && nums[R] == nums[R + 1]) {
                    R--;
                    continue;
                }
                
                // 两端节点先中间前进的规则
                if (nums[base] + nums[L] + nums[R] > 0) {
                    R--;
                } else if (nums[base] + nums[L] + nums[R] < 0) {
                    L++;
                } else {
                    resultL.add(Arrays.asList(nums[base], nums[R], nums[L]));
                    R--;
                    L++;
                }
            }
        }
        return resultL;
    }
}


//排序后， 去base节点相当于确定了独特的第一个数， 左边节点是另一个独特的小数， 右节点是又一个独特的大数。 排序是去重的前提， 没有排序，暴力求法，去重操作及其困难。

// 时间复杂度n2, 两个循环嵌套。内外的时间复杂度都是n。
// 空间复杂度是1； 直接在原数组上操作。
// 双指针同时走减少了一层循环，降低了时间复杂度。


/* 出错点1 鲁棒性未返回空List而返回了null;
   出错点2 while的判断条件， 必须是<而不能是！=;因为假如在内循环的最后一步
找到了正确的三个数， L节点和R节点的位置会交叉， 而跳过==，导致应该终止的内循环无法正常终止。
   出错点3 左右节点去重的目的是消除while循环内的重复，左节点在去重的条件必须是L > base+1(while内循环的初始左节点),不能把base包含进来。

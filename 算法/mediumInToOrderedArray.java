class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenSum = nums1.length + nums2.length;
        if (lenSum == 0)
            return 0;
        // 特殊情况两个都是空数组时；
        if (lenSum == 1) {
            if (nums1.length == 0) 
                return nums2[0] / 2;
            else
                return nums1[0] / 2;
        }
        // 特殊情况总长度为1时中位数怎么算
        // 以上两种情况确保了下面传入参数k的值永远大于或等于1；
        if (lenSum % 2 != 0) {
            return kthMin(0, nums1, 0, nums2, lenSum / 2 + 1);
        } else {
            return (kthMin(0, nums1, 0, nums2, lenSum / 2) + kthMin(0, nums1, 0, nums2, lenSum / 2 + 1)) * 0.5;
        }
    }
    

/*
   找出两个有序数组中kth小的值，有三种可能结束递归：
   当其中一个数组的s(start)索引大于或等于数组长度时，可直接返回另外一个数组的numN[sN + k - 1]元素。
   当其中一个数组的长度为0，时 也可以直接返回另外一个数组的numN[sN + k - 1]元素。
   当k=1时， 可以直接返回num1[s1], num2[s2]中较小的一个值
以上为递归的basecase
*/

    private static double kthMin(int s1, int[] num1, int s2, int[] num2, int k) {
        if (s1 >= num1.length || num1.length == 0) {
            return num2[s2 + k -1];
        }
        if (s2 >= num2.length || num2.length == 0) {
            return num1[s1 + k -1];
        }
        if (k == 1) {
            return Math.min(num1[s1], num2[s2]);
        }
        // 上面的代码时递归的basecase
        int halfK = k / 2;
        int end1 = Math.min(s1 + halfK - 1, num1.length - 1);
        int end2 = Math.min(s2 + halfK - 1, num2.length - 1);
        // min函数保证索引不会越界。
        // 求要被比较的的数组索引值end1,end2。
        if (num1[end1] > num2[end2]) {
            int dk = end2 - s2 + 1;
            k = k -dk;
            // 更新k, 和改变s索引来截断的数组。
            return kthMin(s1, num1, end2 + 1, num2, k);
        } else {
            int dk = end1 - s1 + 1;
            k = k - dk;
            return kthMin(end1 + 1, num1, s2, num2, k);
        }
    }
}



public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length;
    int m = nums2.length;
    int left = (n + m + 1) / 2;
    int right = (n + m + 2) / 2;
    //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
    return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;  
}
    
    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

作者：windliang
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



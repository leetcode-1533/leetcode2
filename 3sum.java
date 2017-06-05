import java.util.*;

public class Solution_1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return re;
        int[] nums_c = nums.clone();
        Arrays.sort(nums_c);


        for (int li = 0; li < nums_c.length - 2; li++) {
            for (int hi = nums_c.length - 1; hi > li; hi--) {
                int target = 0 - nums_c[li] - nums_c[hi];
                int target_index = binarySearch(nums_c, li + 1, hi - 1, target);

                if (target_index != -1)
                    re.add(Arrays.asList(nums_c[li], target, nums_c[hi]));


                while (hi - 1 > li && nums_c[hi] == nums_c[hi -1]) {
                    hi--;
                }
            }

            while (li + 1 < nums_c.length - 2 && nums_c[li] == nums_c[li + 1]) {
                li++;
            }
        }

        return re;
    }

    private int binarySearch(int[] nums, int li, int hi, int target) {
        int i = li;
        int j = hi;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (nums[mid] > target)
                j = mid - 1;
            else if (nums[mid] < target)
                i = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{-1,0,1,2,-1,-4};
        Solution_1 sol = new Solution_1();

        List<List<Integer>> re = sol.threeSum(test);

    }
}
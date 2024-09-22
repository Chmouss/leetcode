import java.util.HashMap;
import java.util.Map;

public class Pb_1_TwoSums {

    /**
     *Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     * - Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * - Example 2:
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     *
     * - Example 3:
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     **/

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] answer = twoSum(nums, target);
        System.out.println(answer[0] + "," + answer[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        //easy version
        /*
        for(int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if(i == j) //cannot use the same element twice
                    continue;
                if( (nums[i] + nums[j]) == target){
                    int [] indexes = {i, j};
                    return indexes;
                }
            }
        }
        return new int []{};
        */

        //optimized version
        Map<Integer, Integer> map =  new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int [] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int []{};
    }


}

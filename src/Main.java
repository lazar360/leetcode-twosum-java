import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution{
    public static int[] getIndexBrutForce(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static int[] getIndexTwoPassHashTable(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        return null;
    }

    public static int[] getIndexOnePassHashTable(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

public class Main extends Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 11, 2, 15};
        int target = 9;

        // 1- Brute force approach
        System.out.println("1-Brute force approach" + Arrays.toString(getIndexBrutForce(nums, target)));
        // 2- Two-pass Hash Table
        System.out.println("2- Two-pass Hash Table" + Arrays.toString(getIndexTwoPassHashTable(nums, target)));
        // 3- One-pass Hash Table
        System.out.println("2- Two-pass Hash Table" + Arrays.toString(getIndexOnePassHashTable(nums, target)));
    }
}

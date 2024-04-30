public class Main {
    public static void main(String[] args) {

        int[] nums = {7, 11, 2, 15};
        int target = 9;

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    index1 = i;
                    index2 = j;
                }
            }
        }

        System.out.println("index 1 = " + index1);
        System.out.println("index 2 = " + index2);

    }
}

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/submissions/1421525969
 */
public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{0});
        moveZeroes(new int[]{0,0,1});
    }

    /**
     * Move all zeroes to the end of it while maintaining the relative order of the non-zero elements.
     *
     * @param nums Array to modify.
     */
    public static void moveZeroes(int[] nums) {
        int zeroesCount = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (zeroesCount > 0) {
                    nums[i] = 0;
                }
                index++;
            } else {
                zeroesCount++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

package leetcode.queue;

/**
 * @author zhangyan
 * @date 2018/1/19
 * @des
 */
public class KNumber {

    public int getUglyNumber(int index) {

        if (index <= 0) {
            return 0;
        }

        int[] targetNumbers = new int[index];

        targetNumbers[0] = 1;

        int p3 = 0;
        int p5 = 0;
        int p7 = 0;

        int count = 1;

        while (count < index) {

            int min = min(targetNumbers[p3] * 3, targetNumbers[p5] * 5, targetNumbers[p7] * 7);

            targetNumbers[count] = min;

            while (targetNumbers[p3] * 3 <= targetNumbers[count]) {
                p3++;
            }
            while (targetNumbers[p5] * 5 <= targetNumbers[count]) {
                p5++;
            }
            while (targetNumbers[p7] * 7 <= targetNumbers[count]) {
                p7++;
            }

            count++;
        }

        return targetNumbers[index - 1];

    }

    private int min(int number1, int number2, int number3) {
        int min = number1 < number2 ? number1 : number2;
        min = min < number3 ? min : number3;
        return min;
    }

}


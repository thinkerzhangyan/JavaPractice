package search;

/**
 * @author zhangyan
 * @date 2017/10/20
 * @des 二分查找练习
 */
public class BinarySearchPractice {

    public static void main(String[] args) {

        int[] array = new int[]{1, 5, 6, 6, 8, 14, 21, 33, 33, 43, 65, 77, 88, 91, 92, 95};

        System.out.println("reBinarySearch 33:" + reBinarySearch(array, 33));
        System.out.println("reBinarySearch 21:" + reBinarySearch(array, 21));
        System.out.println("reBinarySearch 77:" + reBinarySearch(array, 77));
        System.out.println("reBinarySearch 91:" + reBinarySearch(array, 91));


        System.out.println("====================");

        System.out.println("nonReBinarySearch 33:" + nonReBinarySearch(array, 33));
        System.out.println("nonReBinarySearch 21:" + nonReBinarySearch(array, 21));
        System.out.println("nonReBinarySearch 77:" + nonReBinarySearch(array, 77));
        System.out.println("nonReBinarySearch 91:" + nonReBinarySearch(array, 91));

        System.out.println("====================");

        System.out.println("reBinarySearch 34:" + reBinarySearch(array, 34));
        System.out.println("reBinarySearch 22:" + reBinarySearch(array, 22));
        System.out.println("reBinarySearch 78:" + reBinarySearch(array, 78));
        System.out.println("reBinarySearch 93:" + reBinarySearch(array, 93));

        System.out.println("====================");

        System.out.println("nonReBinarySearch 34:" + nonReBinarySearch(array, 34));
        System.out.println("nonReBinarySearch 22:" + nonReBinarySearch(array, 22));
        System.out.println("nonReBinarySearch 78:" + nonReBinarySearch(array, 78));
        System.out.println("nonReBinarySearch 93:" + nonReBinarySearch(array, 93));
    }


    private static int nonReBinarySearch(int[] array, int target) {

        if (array == null || array.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = array.length - 1;

        int mid = 0;

        while (lo <= hi) {

            mid = lo + (hi - lo) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }

        }


        return -1;

    }


    private static int reBinarySearch(int[] array, int target) {

        if (array == null || array.length == 0) {
            return -1;
        }

        return reBinarySearch(array, target, 0, array.length - 1);
    }

    private static int reBinarySearch(int[] array, int target, int lo, int hi) {

        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return reBinarySearch(array, target, mid + 1, hi);
        } else {
            return reBinarySearch(array, target, lo, mid - 1);
        }
    }

}

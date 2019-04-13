package sort;


import java.util.Arrays;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class SortPractice {


    public static void sort(Integer[] a) {


        int[] arrayHelp = new int[65536];

        for (int i=0;i<a.length;i++) {
            arrayHelp[a[i]]++;
        }

        int k = 0;

        for (int i=0;i<arrayHelp.length;i++) {
            if (arrayHelp[i] !=0) {
                for (int j=0;j<arrayHelp[i];j++) {
                    a[k++] = i;
                }
            }
        }

    }



    public static void main(String[] args) {

        Integer[] array = new Integer[]{2, 4, 1, 2, 777, 33, 22, 11, 1, 5, 4, 3, 1, 8, 9, 444, 233, 85, 22, 4, 2, 4, 5, 8, 4, 7, 6};

        SortPractice.sort(array);

        //Bubble.sort(array);

        System.out.println(Arrays.asList(array));


    }


}

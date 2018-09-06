package sort;

import java.util.Arrays;

/**
 * Created by hzzhangyan3 on 2016/8/28.
 */
public class Main {


    public static void main(String[] args){

        Integer[] array = new Integer[]{2,4,1,2,777,33,22,11,1,5,4,3,1,8,9,444,233,85,22,4,2,4,5,8,4,7,6};

        SortPractice.sort(array);

        //Bubble.sort(array);

        System.out.println(Arrays.asList(array));

    }

}



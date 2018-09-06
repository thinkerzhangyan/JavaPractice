package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhangyan
 * @date 2018/3/15
 * @des
 */
public class BlockingQueueCommutation {

    public static void main(String[] args) {
        new BlockingQueueCommutation().exeute();
    }


    private void exeute() {
        Business business = new Business();

//        new Thread(() -> {
//            for (int i=1;i<100;i++) {
//                business.sub(i);
//            }
//        }).start();
//
//        for (int i=1;i<100;i++) {
//            business.main(i);
//        }

    }

    private class Business {

        private BlockingQueue<Integer> blockingQueue1 = new ArrayBlockingQueue(1);

        private BlockingQueue<Integer> blockingQueue2 = new ArrayBlockingQueue<Integer>(1);


        {
            try {
                blockingQueue2.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        public void sub(int j) {

            try {
                blockingQueue1.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 1; i < 10; i++) {
                System.out.println("sub-" + j + "-sequence-" + i + "-time");
            }

            try {
                blockingQueue2.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public void main(int j) {

            try {
                blockingQueue2.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 1; i < 10; i++) {
                System.out.println("main-" + j + "-sequence-" + i + "-time");
            }

            try {
                blockingQueue1.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}


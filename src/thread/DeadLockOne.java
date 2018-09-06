package thread;

/**
 * @author zhangyan
 * @date 2018/7/4
 * @des
 */
public class DeadLockOne {

    public static void main(String[] args) {
        Thread threadOne = new Thread(new MyRunableOne(true,"one"));
        Thread threadTwo = new Thread(new MyRunableOne(false,"two"));

        threadOne.start();
        threadTwo.start();
    }

}

class MyLockOne {
    public static Object lockOne = new Object();
    public static Object lockTwo = new Object();
}

class MyRunableOne implements Runnable {

    private boolean first = false;

    private String name = "default";

    public MyRunableOne(boolean first, String name) {
        this.first = first;
        this.name = name;
    }

    @Override
    public void run() {
        if (first) {
            synchronized (MyLockOne.lockOne) {
                System.out.println("线程"+name+"获取到一锁");
                synchronized (MyLockOne.lockTwo) {
                    System.out.println("线程"+name+"获取到二锁");
                }
            }
        } else {
            synchronized (MyLockOne.lockTwo) {
                System.out.println("线程"+name+"获取到二锁");
                synchronized (MyLockOne.lockOne) {
                    System.out.println("线程"+name+"获取到一锁");
                }
            }
        }
    }
}
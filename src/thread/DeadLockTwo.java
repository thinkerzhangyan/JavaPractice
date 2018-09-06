package thread;

/**
 * @author zhangyan
 * @date 2018/7/4
 * @des
 */
public class DeadLockTwo {

    public static void main(String[] args) {
        Thread threadOne = new Thread(new MyRunableTwo(1,"one"));
        Thread threadTwo = new Thread(new MyRunableTwo(2,"two"));
        Thread threadThree = new Thread(new MyRunableTwo(3,"three"));

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

}

class MyLockTwo {
    public static Object lockOne = new Object();
    public static Object lockTwo = new Object();
    public static Object lockThree = new Object();
}

class MyRunableTwo implements Runnable {

    private int flag = 0;

    private String name = "default";

    public MyRunableTwo(int flag,String name) {
        this.flag = flag;
        this.name = name;
    }

    @Override
    public void run() {
        if (flag==1) {
            synchronized (MyLockTwo.lockOne) {
                System.out.println("线程"+name+"获取到一锁");
                synchronized (MyLockTwo.lockTwo) {
                    System.out.println("线程"+name+"获取到二锁");
                }
            }
        } else if (flag==2){
            synchronized (MyLockTwo.lockTwo) {
                System.out.println("线程"+name+"获取到二锁");
                synchronized (MyLockTwo.lockThree) {
                    System.out.println("线程"+name+"获取到三锁");
                }
            }
        } else if (flag == 3) {
            synchronized (MyLockTwo.lockThree) {
                System.out.println("线程"+name+"获取到三锁");
                synchronized (MyLockTwo.lockOne) {
                    System.out.println("线程"+name+"获取到一锁");
                }
            }
        }
    }
}
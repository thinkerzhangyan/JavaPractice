package test;

/**
 * @author zhangyan
 * @date 2020/6/2
 * @des
 */
public class Child extends Parent{

    public static void main(String[] args) {
        new Child().test();
    }

    @Override
    public void print() {
        System.out.println("Child-test");
    }


}

package singleinstance;

/**
 * Created by macbook on 2017/9/17.
 */
public class SingleInstanceA {

    private SingleInstanceA() {

        if (singleInstanceA != null) {
            try {
                throw new IllegalAccessException("单例对象已经被实例化了，请不要随便使用非法的反射！");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static SingleInstanceA singleInstanceA = new SingleInstanceA();

    public static SingleInstanceA getSingleInstance() {
        return singleInstanceA;
    }

}

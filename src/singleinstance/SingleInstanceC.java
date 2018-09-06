package singleinstance;

/**
 * Created by macbook on 2017/9/17.
 */
public class SingleInstanceC {
    private SingleInstanceC() {
        if (singleInstanceC != null) {
            try {
                throw new IllegalAccessException("单例对象已经被实例化了，请不要随便使用非法的反射！");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static volatile SingleInstanceC singleInstanceC;

    public static SingleInstanceC getInstance() {
        if (singleInstanceC == null) {
            synchronized (SingleInstanceC.class) {
                if (singleInstanceC == null) {
                    singleInstanceC = new SingleInstanceC();
                }
            }
        }
        return singleInstanceC;
    }
}

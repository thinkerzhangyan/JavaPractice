package singleinstance;

import base.Parent;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * Created by macbook on 2017/9/17.
 */
public class SingleInstanceD implements Serializable{

    private SingleInstanceD() {
        if (SingleInstanceHolder.INSTANCE != null) {
            try {
                throw new IllegalAccessException("单例对象已经被实例化了，请不要随便使用非法的反射！");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    private static class SingleInstanceHolder {
        private static final SingleInstanceD INSTANCE = new SingleInstanceD();
    }

    public static SingleInstanceD getInstane() {
        return SingleInstanceHolder.INSTANCE;
    }

    //保证反序列化的时候，仍然不会创建新的对象，保证了单例模式。
    private Object readResolve() throws ObjectStreamException {
        return SingleInstanceHolder.INSTANCE;
    }

}

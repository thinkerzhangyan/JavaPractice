package singleinstance;

import java.util.Hashtable;

/**
 * @author zhangyan
 * @date 2018/2/24
 * @des 使用容器实现单例
 */
public class SingleInstanceF {

    private static Hashtable<String, Object> map = new Hashtable<>();

    private SingleInstanceF() {
        if (SingleInsanceHolder.single != null) {
            try {
                throw new IllegalAccessException("单例对象已经被实例化了，请不要随便使用非法的反射！");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SingleInsanceHolder {
        private static final SingleInstanceF single = new SingleInstanceF();
    }

    public static  SingleInstanceF getInstance() {
        return SingleInsanceHolder.single;
    }

    public void registerService(String key, Object object) {
        if (!map.containsKey(key)) {
            map.put(key, object);
        }
    }

    public Object getService(String key) {
        return map.get(key);
    }
}

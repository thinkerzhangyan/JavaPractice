package base;

/**
 * @author zhangyan
 * @date 2018/2/28
 * @des 孙子类
 */
public class Grandson extends Son {
    @Override
    public void onTouchEvent() {
        System.out.println("onTouchEvent of Grandson!");
    }
}

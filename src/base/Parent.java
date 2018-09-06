package base;

/**
 * @author zhangyan
 * @date 2017/11/10
 * @des 父类
 */
public class Parent {

    Person person;

    static class Person {
        public String name;
        public String age;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void introPerson() {
        System.out.println("name:" + person.name + "    age:" + person.age);
    }


    public void onTouchEvent() {
        System.out.println("onTouchEvent of parent!");
    }
}

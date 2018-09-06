package base;

/**
 * @author zhangyan
 * @date 2017/11/10
 * @des 运行的主类
 */
public class Test {

    public static void main(String[] args) {

        Son son = new Son();

        Parent.Person person = new Parent.Person();

        person.age = "27";
        person.name = "zhangsan";

        son.setPerson(person);

        son.test();


        Grandson grandson = new Grandson();

        grandson.testb();

    }

}

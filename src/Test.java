import javax.swing.plaf.TableHeaderUI;
import java.util.*;
import java.util.concurrent.*;

/**
 * Created by macbook on 2017/10/9.
 */
public class Test<T> {

    private static int i = 1;

    public static void main(String[] args) throws Exception {

//        int[] array = new int[]{1,2,2,3,3,4,5,7,3,5,3,4,1};
//        System.out.println("数组中只出现一次的数字：" + NumberOfApperanceOne(array));
//
//        System.out.println("张岩".length());
//        System.out.println("zhangyan".length());
//        System.out.println("zhang岩".length());
//
//        System.out.println("张岩是我啊是我送的啊啊啊的的的的的的的的".substring(0,8));
//
//        Random random = new Random();
//
//        for(int i =0;i<30;i++) {
//            System.out.println(random.nextInt(5));
//        }


//         MyThread myThread = new MyThread();
//
//         myThread.start();
//
//
//         Timer timer  = new Timer();
//
//         timer.schedule(new TimerTask() {
//             @Override
//             public void run() {
//                 myThread.quit();
//             }
//         },1000);
//

//        System.out.println(Thread.currentThread().getId());
//
//        Executor executor = new Executor() {
//            @Override
//            public void execute(Runnable command) {
//                System.out.println(Thread.currentThread().getId());
//            }
//        };
//
//        executor.execute(null);


//
//        String a = new String("ab");//运行时确定，常量池中存在了“ab”，堆中存在了对象a
//        String b = new String("ab");//运行时确定，用常量池管理"ab"，调用构造器创造新的对象b，
//        String c = "ab";//编译时确定，直接引用了常量池中的"ab"
//        String d = "a" + "b";//编译时确定，直接引用了常量中的"ab"
//        String e = "b";
//        String f = "a" + e;//运行时确定，不能直接引用常量池中的"ab"
//
//        System.out.println(b.intern() == a);//b.intern()返回的是常量池中"ab"的地址，a是堆上a的地址 false
//        System.out.println(b.intern() == c);//b.intern()返回的是常量池中"ab"的地址，c是常量池中"ab"的地址的地址 true
//        System.out.println(b.intern() == d);//b.intern()返回的是常量池中"ab"的地址，d是常量池中"ab"的地址的地址 true
//        System.out.println(b.intern() == f);//b.intern()返回的是常量池中"ab"的地址，f返回的是堆上f的地址 false
//        System.out.println(b.intern() == a.intern());//b.intern()返回的是常量池中"ab"的地址，a.intern()返回的是常量池中"ab"的地址的地址 true


//
//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("a");
//        hashSet.add("b");
//        hashSet.add("c");
//        hashSet.add("d");
//        String[] array = hashSet.toArray(new String[5]);
//        for (int j = 0; j < array.length; j++) {
//            System.out.println(array[j]);
//        }
//
//
//        TreeSet<Object> treeSet = new TreeSet<>();
//        treeSet.add(new A());
//        treeSet.add(new B());
//        treeSet.remove(new A());
//
//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//
//        for (Integer x : list) {
//            if (x % 2 == 0) {
//                list.remove(x);
//            }
//        }

//        Thread t1 = new Thread(new ThreadTesterA());
//        Thread t2 = new Thread(new ThreadTesterB());
//        t1.start();
//        t1.join(); // wait t1 to be finished
//        t2.start();
//        t2.join(); // in this program, this may be removed

//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//        Future<String> future = executorService.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                boolean end = false;
//                while (!end) {
//                    if (Thread.interrupted()) {
//                        return "end!!!!";
//                    }
//                    System.out.println("run!!!!");
//                }
//                return "end!!!!";
//            }
//        });
//
//        Thread.sleep(100);
//
//        System.out.println(future.cancel(true));
//        //System.out.println(future.get());


        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(0, 0.75f, true);

        linkedHashMap.put("one", "one");
        linkedHashMap.put("two", "two");
        linkedHashMap.put("three", "three");


        linkedHashMap.get("two");

        Iterator iterator = linkedHashMap.entrySet().iterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



      //  System.out.println(generateOrderId());


        initEmojiMap(mHashMap);

        System.out.println(mHashMap.size());
    }

    //生成订单ID
    private static String generateOrderId() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);//获取年份
        int month = cal.get(Calendar.MONTH) + 1;//获取月份
        int day = cal.get(Calendar.DATE);//获取日
        int hour = cal.get(Calendar.HOUR);//小时
        int minute = cal.get(Calendar.MINUTE);//分
        int second = cal.get(Calendar.SECOND);//秒
        return "" + year + month + day + hour + minute + second + randomString(10);
    }

    //产生一个随机的字符串
    public static String randomString(int length) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(36);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }

    private static class ComparableA implements Comparable {

        private int x = 0;

        public ComparableA(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Object o) {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public String toString() {
            return "x:" + x;
        }
    }

    private static class ComparableB implements Comparable {

        private int x = 0;

        public ComparableB(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Object o) {
            return 2;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public String toString() {
            return "x:" + x;
        }
    }

    private static class ComparableC implements Comparable {

        private int x = 0;

        public ComparableC(int x) {
            this.x = x;
        }

        @Override
        public int compareTo(Object o) {
            return 3;
        }

        @Override
        public boolean equals(Object obj) {
            return false;
        }

        @Override
        public String toString() {
            return "x:" + x;
        }
    }

    private static class A implements Comparable {


        @Override
        public int compareTo(Object o) {
            return 1;
        }
    }

    private static class B implements Comparable {


        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }

    private static int NumberOfApperanceOne(int[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("array==null||array.length==0");
        }
        int result=0;
        for(int i=0;i<array.length;i++) {
            result = array[i] ^ result;
        }
        return result;
    }


    private static class MyThread extends Thread {

        private boolean isInterrupt = false;

        public void quit() {
            System.out.println("quit!");
            isInterrupt = true;
            interrupt();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("running!");
                } catch (Exception e) {
                    if (isInterrupt) {
                        System.out.println("finish!");
                        return;
                    }
                }
            }
        }
    }


    public interface Behaviour {
        void print();
    }

    public enum ColorA implements Behaviour{

        RED("红色"), GREEN("绿色"), BLANK("白色"), YELLO("黄色");

        // 成员变量
        private String name;
        // 构造方法
        private ColorA(String name) {
            this.name = name;
        }

        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        //接口方法
        @Override
        public void print() {
            System.out.println(this.name);
        }
    }

    public enum ColorB implements Behaviour{

        RED("红色"){
            @Override
            public void print() {
                System.out.println(RED.name);
            }
        }, GREEN("绿色"){
            @Override
            public void print() {
                System.out.println(GREEN.name);
            }
        }, BLANK("白色"){
            @Override
            public void print() {
                System.out.println(BLANK.name);
            }
        }, YELLO("黄色"){
            @Override
            public void print() {
                System.out.println(YELLO.name);
            }
        };

        // 成员变量
        private String name;
        // 构造方法
        private ColorB(String name) {
            this.name = name;
        }

        // get set 方法
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }



    static class  ThreadTesterA implements Runnable {

        private int counter;

        @Override
        public void run() {
            while (counter <= 10) {
                System.out.println("Counter = " + counter + " ");
                counter++;
            }
            System.out.println();
        }
    }

    static class ThreadTesterB implements Runnable {

        private int i;

        @Override
        public void run() {
            while (i <= 10) {
                System.out.println("i = " + i + " ");
                i++;
            }
            System.out.println();
        }
    }


    private static HashMap<String,String> mHashMap = new HashMap<>();

    private  static void initEmojiMap(HashMap<String,String> mHashMap) {
        mHashMap.put("/{dx", "[大笑]");
        mHashMap.put("/{sh", "[送花]");
        mHashMap.put("/{tx", "[偷笑]");
        mHashMap.put("/{dk", "[大哭]");
        mHashMap.put("/{hh", "[嘿哈]");
        mHashMap.put("/{66", "[666]");
        mHashMap.put("/{gd", "[感动]");
        mHashMap.put("/{yw", "[疑问]");
        mHashMap.put("/{xh", "[喜欢]");
        mHashMap.put("/{jx", "[奸笑]");
        mHashMap.put("/{zan", "[赞]");
        mHashMap.put("/{ka", "[可爱]");
        mHashMap.put("/{am", "[傲慢]");
        mHashMap.put("/{kx", "[开心]");
        mHashMap.put("/{88", "[拜拜]");
        mHashMap.put("/{hx", "[害羞]");
        mHashMap.put("/{zs", "[衰]");
        mHashMap.put("/{pu", "[吐血]");
        mHashMap.put("/{zc", "[嘴馋]");
        mHashMap.put("/{sq", "[生气]");
        mHashMap.put("/{fe", "[扶额]");
        mHashMap.put("/{bz", "[闭嘴]");
        mHashMap.put("/{kw", "[枯萎]");
        mHashMap.put("/{xu", "[嘘]");
        mHashMap.put("/{xk", "[笑哭]");
        mHashMap.put("/{lh", "[流汗]");
        mHashMap.put("/{bk", "[不看]");
        mHashMap.put("/{hq", "[哈欠]");
        mHashMap.put("/{tp", "[调皮]");
        mHashMap.put("/{gl", "[鬼脸]");
        mHashMap.put("/{cl", "[戳脸]");
        mHashMap.put("/{dg", "[大哥]");
        mHashMap.put("/{kun", "[困]");
        mHashMap.put("/{yb", "[拥抱]");
        mHashMap.put("/{zt", "[猪头]");
        mHashMap.put("/{kl", "[骷髅]");
        mHashMap.put("/{cc", "[臭臭]");
        mHashMap.put("/{xd", "[心动]");
        mHashMap.put("/{dao", "[刀]");
    }



}

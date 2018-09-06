package mianshizhenti;

/**
 * @author zhangyan
 * @date 2018/8/9
 * @des
 */
public class SuShu {

    //https://blog.csdn.net/huang_miao_xin/article/details/51331710
    //这篇博客里面思路讲解的很清楚了
    public boolean isPrimeA(int n) {

        if (n < 2) {
            return false;
        } else {

            int sqrt = (int) Math.sqrt(n);

            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;

        }

    }

    //其实是和A是一样的
    public boolean isPrimeB(int n) {

        if (n < 2) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        for (int i=3;i*i<=n;i+=2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    //通过建立Hash表的方式
    public boolean isPrimeC(int n) {
        return true;
    }

    //求大于某个数的最小的素数
    public int getPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }
        for (; !isPrimeA(n); n += 2) {

        }
        return n;
    }

    public static void main(String[] args) {

    }

}

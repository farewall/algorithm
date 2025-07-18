package com.xusn.third;

/**
 * X的平方根
 */
public class MySqrt {
    public static int mySqrt(int x) {
        // 牛顿迭代法：Xn+1 = Xn - f(Xn)/f'(Xn)
        //f(x) = x^2 -S f'(x) = 2x
        if (x == 0 || x == 1) {
            return x;
        }
        long res = x;
        while ( res * res > x) {
            res = (res + x/res)/2;
        }
        return (int) res;
    }

    public static double mySqrt(double x) {
        return 0.1;
    }

    public static void main(String[] args) {
        double eps = 1e-7;
        System.out.println(eps);
        System.out.println(mySqrt(2147483647));
    }
}

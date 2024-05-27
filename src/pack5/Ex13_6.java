package pack5;

import pack2.ThreadEx;

public class Ex13_6 {
    public static void main(String[] args) {
        ThreadEx6_1 th1 = new ThreadEx6_1();
        ThreadEx6_2 th2 = new ThreadEx6_2();

        th2.setPriority(7);

        System.out.println("Priority of th1(-) : " + th1.getPriority());
        System.out.println("Priority of th2(-) : " + th2.getPriority());
        th1.start();
        th2.start();
    }
}


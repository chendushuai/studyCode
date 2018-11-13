package com.sschen.concurrent.thread;

/**
 * 原子性：是指一个操作是不可中断的。即使是在多个线程一起执行的时候，一个操作一旦开始，就不会被其他线程干扰。
 *
 * 用于测试程序原子性的线程，需要在32位的环境下运行
 * 因为long类型的长度是64位的，所以在32位运行的时候会导致混乱读取，产生没有设置的数字。
 * 32位的系统对于int类型来讲是原子性的，但是对于long类型来讲是非原子性的。
 */
public class MultiThreadLong {
    public static long t = 0;
    public static class ChangeT implements Runnable {
        private long to;

        public ChangeT(long to) {
            this.to=to;
        }
        @Override
        public void run() {
            while (true) {
                MultiThreadLong.t = to;
                Thread.yield();
            }
        }

        public static class ReadT implements Runnable {
            @Override
            public void run() {
                while (true) {
                    long tmp = MultiThreadLong.t;
                    if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
                        System.out.print(tmp);
                        System.out.printf(" = " + Long.toBinaryString(tmp));
                        System.out.println();
                    }
                    Thread.yield();
                }
            }
        }

        public static void main(String[] args) {
            new Thread(new ChangeT(111L)).start();
            new Thread(new ChangeT(-999L)).start();
            new Thread(new ChangeT(333L)).start();
            new Thread(new ChangeT(-444L)).start();
            new Thread(new ReadT()).start();
        }
    }
}

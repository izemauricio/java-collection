package com.peace.collection;

class Queue {
    public static void main(String args[]) {
        java.util.Queue<Integer> q = new java.util.LinkedList<Integer>();

        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        int e;
        e = q.size();
        System.out.println(e); // 4
        e = q.poll();
        System.out.println(e); // 20
        e = q.poll();
        System.out.println(e); // 30
        e = q.peek();
        System.out.println(e); // 40 get first without remove
    }
}
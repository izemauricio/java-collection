class Stack {
    public static void main(String args[]) {
        java.util.Stack<Integer> s = new java.util.Stack<Integer>();

        s.push(10); // O(1)
        s.push(12);
        s.push(33);
        s.push(67);

        int e;
        e = s.size();
        System.out.println(e); // 4
        e = s.pop(); // O(1)
        System.out.println(e); // 67 get and remove top
        e = s.pop(); // O(1)
        System.out.println(e); // 33
        e = s.peek(); // O(1)
        System.out.println(e); // 12 get top but dont remove
        e = s.pop(); // O(1)
        System.out.println(e); // 12 
    }
}
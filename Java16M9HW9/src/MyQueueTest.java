public class MyQueueTest {
    public static void main(String[] args){
        MyQueue<String> queue = new MyQueue<>();
        queue.add("First");
        queue.add("Second");
        queue.add("Third");
        queue.add("Fourth");
        queue.add("Fifth");

        System.out.println("queueTest = " + queue);

        System.out.println("queueTest.size() = " + queue.size());

        queue.peek();
        System.out.println("queueTest.peek() = " + queue.peek());
        System.out.println("queueTest = " + queue);

        queue.poll();
        System.out.println("queueTest.pool() = " + queue.poll());
        System.out.println("queueTest = " + queue);

        queue.clear();
        System.out.println("queueTest.clear() = " + queue);

    }
}

public class MyStackTest {
    public static void main(String[] args){
        MyStack<String> stack = new MyStack<>();
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        stack.push("Fifth");

        System.out.println("stackTest = " + stack);

        System.out.println("stackTest.size() = " + stack.size());

        stack.remove(3);
        System.out.println("stackTest.remove(3) = " + stack);

        stack.peek();
        System.out.println("stackTest.peek() = " + stack.peek());
        System.out.println("stackTest = " + stack);

        stack.pop();
        System.out.println("stackTest.pool() = " + stack.pop());
        System.out.println("stackTest = " + stack);


        stack.clear();
        System.out.println("stackTest.clear() = " + stack);
    }
}

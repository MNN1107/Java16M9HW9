public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.add("First");
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Fourth");

        System.out.println("linkedList = " + linkedList);

        System.out.println("linkedList.get(1) = " + linkedList.get(1));

        System.out.println("linkedList.size() = " + linkedList.size());


        linkedList.remove(0);
        System.out.println("linkedList.remove(2) = " + linkedList);

        linkedList.clear();
        System.out.println("linkedList.clear() = " + linkedList);
    }
}

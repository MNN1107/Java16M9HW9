public class MyQueue <T>{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;
    public MyQueue() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public void add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>(null, null, value);
        } else if (lastNode == null) {
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        } else {
            Node<T> newLastNode = new Node<>(lastNode, null, value);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
    }
    public int size() {
        if (firstNode == null) {
            return 0;
        }
        int count = 1;
        Node<T> currentNode = firstNode;
        while (currentNode.getNextNode() != null){
            currentNode = currentNode.getNextNode();
            count++;
        }
        return count;
    }
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public T peek() {
        Node<T> currentNode = firstNode;
        return firstNode.getValue();
    }
    public T poll(){
        T value = firstNode.getValue();
        firstNode = firstNode.getNextNode();
        firstNode.setPrevNode(null);
        size--;
        return value;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        Node<T> currentNode = firstNode;
        while (currentNode != null) {
            result.append(currentNode.getValue()).append(" ");
            currentNode = currentNode.getNextNode();
        }
        return result.toString();
    }
}

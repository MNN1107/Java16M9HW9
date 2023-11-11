public class MyStack<T>{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;
    public MyStack() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public void push(T value){
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
    private Node<T> getNodeByIndex(int index) {
        Node<T> currentNode = lastNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getPrevNode();
        }
        return currentNode;
    }

    public void remove(int index) {
        if (size == 1) {
            clear();
        } else if (index == 0) {
            lastNode = lastNode.getPrevNode();
            lastNode.setNextNode(null);

            size--;
        } else if (index == size - 1) {
            firstNode = firstNode.getNextNode();
            firstNode.setPrevNode(null);
            size--;
        } else {
            Node<T> currentNode = getNodeByIndex(index);
            currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
            currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
            size--;
        }
    }
    public T peek() {
        Node<T> currentNode = lastNode;
        return lastNode.getValue();
    }
    public T pop(){
        T value = lastNode.getValue();
        lastNode = lastNode.getPrevNode();
        lastNode.setNextNode(null);
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

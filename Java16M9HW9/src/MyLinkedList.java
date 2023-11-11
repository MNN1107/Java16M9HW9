public class MyLinkedList <T>{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public MyLinkedList() {
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

    public T get(int index) {
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
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
        Node<T> currentNode = firstNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public void remove(int index){

        if (size == 1){
            clear();
        }else
        if (index == 0){
            firstNode = firstNode.getNextNode();
            firstNode.setPrevNode(null);
            size--;
        } else
            if (index == size - 1){
                lastNode = lastNode.getPrevNode();
                lastNode.setNextNode(null);
                size--;
        }else {
                Node<T> currentNode = getNodeByIndex(index);
                currentNode.getPrevNode().setNextNode(currentNode.getNextNode());
                currentNode.getNextNode().setPrevNode(currentNode.getPrevNode());
                size--;
            }


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

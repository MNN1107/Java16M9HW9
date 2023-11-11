import java.util.Arrays;

public class MyArrayList<T>{
    private static final int INIT_SIZE = 5;
    private Object[]values;
    private int size;
    public MyArrayList() {
        values = new Object[INIT_SIZE];
        size = 0;
    }

    public void add(Object value){
        rebalance();
        values[size] = value;
        size++;
    }
    private void rebalance(){
        if (values.length == size){
            values = Arrays.copyOf(values, values.length + 5);
        }
    }
    public T get(int index){
        return (T) values[index];
    }
    public int size(){
        return size;
    }
    public T remove(int index){
        for (int i = index; i < size - 1; i++) {
            values[i] = values[i +1];
        }
        size--;
        return (T) values;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            values[i] = null;
        }
        size = 0;
    }
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(values, size));
    }
}

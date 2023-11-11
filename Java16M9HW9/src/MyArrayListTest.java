public class MyArrayListTest {
    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Pear");
        arrayList.add("Plum");
        arrayList.add("Cherry");
        arrayList.add("Peach");
        arrayList.add("Currant");


        System.out.println("arrayList = " + arrayList);

        System.out.println("arrayList.size() = " + arrayList.size());

        System.out.println("arrayList.get(0)= " + arrayList.get(0));
        System.out.println("arrayList.get(-1)= " + arrayList.get(-1));

        arrayList.remove(2);
        System.out.println("arrayList.remove(2)= " + arrayList);
        arrayList.remove(8);
        System.out.println("arrayList.remove(8)= " + arrayList);

        arrayList.clear();
        System.out.println("arrayList.clear()= " + arrayList);

    }


}

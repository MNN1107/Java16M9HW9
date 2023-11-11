public class MyHashMapTest {
    public static void main(String[] args){
        MyHashMap<String, Integer> cityCode = new MyHashMap<>();
        cityCode.put("Kharkiv", 57);
        cityCode.put("Luhansk", 64);
        cityCode.put("Kyiv", 44);
        cityCode.put("Lviv", 32);
        cityCode.put("Mykolaiv", 51);
        cityCode.put("Kherson", 55);
        cityCode.put("Zhytomyr", 41);

        System.out.println("cityCode: " + cityCode);

        System.out.println("cityCode.size(): " + cityCode.size());

        System.out.println("cityCode.get(\"Mykolaiv\"): " + cityCode.get("Mykolaiv"));

        cityCode.remove("Lviv");
        System.out.println("cityCode.remove(\"Lviv\"): " + cityCode);

        cityCode.clear();
        System.out.println("cityCode.clear(): " + cityCode);
    }

}

// Time Complexity:  O(1)
// Space Complexity: O(n)

public class Main {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] values = new int[] {1, 2, 2, 2, 3, 5, 1, 10, 9, 6, 7, 8, 9, 20};
        Main obj = new Main();
        for(int value : values) {
            obj.insert(value);
        }
        System.out.println();
        System.out.println("After inserting");
        System.out.println();
        System.out.println(obj.map);
        System.out.println(obj.list.toString());
        System.out.println();
        for(int i=0; i<obj.map.size(); i++) {
            System.out.println(obj.getRandom());
        }
        for(int i=0; i<values.length; i+=3) {
            obj.remove(values[i]);
        }
        System.out.println();System.out.println();System.out.println();
        System.out.println("Now we removed few values");
        System.out.println();
        System.out.println(obj.map);
        System.out.println(obj.list.toString());
        System.out.println();
        for(int i=0; i<obj.map.size(); i++) {
            System.out.println(obj.getRandom());
        }
    }
    private void insert(int val) {
        if(!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size()-1);
        }
    }
    private void remove(int val) {
        if(map.containsKey(val)) {
            int index = map.get(val);
            int last_val = list.get(list.size()-1) ;
            list.set(index, last_val);
            map.put(last_val, index);
            list.remove(list.size()-1);
            map.remove(val);
        }
    }
    private int getRandom() {
        Random random = new Random();
        int val = list.get(random.nextInt(list.size()));
        return val;
    }
}

import java.util.*;

public class seminar6 {
    public static void main(String[] Args) {
        SetImitation setImitation = new SetImitation();
        System.out.println(setImitation.add(9));
        System.out.println(setImitation.add(52));
        System.out.println(setImitation.add(13));
        System.out.println(setImitation.add(3));
        System.out.println(setImitation.add(3));
        System.out.println(setImitation.delete(3));
        System.out.println(setImitation.delete(3));
        System.out.println(setImitation.size());
        System.out.println(setImitation.isEmpty());
        System.out.println(setImitation.contains(9));
        for (int i = 0; i < 10; i++) {
            setImitation.add(new Random().nextInt(1000));
        }

        Iterator <Integer> iterator = setImitation.iterator();
        while (iterator.hasNext()){
            int i = iterator.next();
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(setImitation.getElByIndex(3));
//        System.out.println(setImitation.getElByIndex(20));


    }


}
class SetImitation<E> {
    HashMap<E, Object> map = new HashMap<>();
    private static final Object OBJECT = new Object();
    public boolean add(E num) {
        return map.put(num,OBJECT) == null;
    }

    public boolean delete(E num) {
        return map.remove(num, OBJECT);
    }

    public int size(){
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(Object num){
        return map.containsKey(num);
    }

    public Iterator<E> iterator(){
        return map.keySet().iterator();
    }

    public E getElByIndex(int index){
        E[] mapArray = (E[]) map.keySet().toArray();
        return mapArray[index];
    }


}
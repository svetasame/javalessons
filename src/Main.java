import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = new Random().nextInt(20);
        ArrayList<Integer> list = fillArray(size);
        printArray(list);
        ArrayList<Integer> evenList = deleteEven(list);
        System.out.println();
        System.out.println(deleteEven(list) + "Список без четных чисел: ");
        printArray(evenList);
        System.out.println();
        findMaxMin(list);
    }

    public static ArrayList<Integer> fillArray(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(20));
        }
        return list;
    }

    public static void printArray(ArrayList<Integer> array) {
        array.forEach(n -> System.out.print(n + " "));
    }

    public static ArrayList<Integer> deleteEven (ArrayList<Integer> array) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i)%2 != 0) {
                newList.add(array.get(i));
            }
        }
        return newList;
    }
    public static ArrayList<Integer> findMaxMin (ArrayList<Integer> array) {
        array.sort(Comparator.naturalOrder());
        System.out.println(array.get(array.size()-1) + " - максимальное значение списка");
        System.out.println(array.get(0) + " - минимальное значение списка");
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            sum += array.get(i);
        }
        int ave = sum/array.size();
        System.out.println(ave + " - среднее значение списка");
        return array;
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;


public class seminar44 {

    public static void main(String[] args) {
        ArrayList<String[]> stringList = new ArrayList<>();
        String[] baza1;
        String encoding = System.getProperty("console.encoding", "UTF-8");
        Scanner scanner1 = new Scanner(System.in, encoding);

        while (true) {
            System.out.println("____________________");
            System.out.println("Введите через запятую: Фамилия Имя Отчество Возраст Пол");
            baza1 = GetArraeString(scanner1.nextLine());

            if (baza1 == null) {
                break;
            }
            stringList.add(baza1);
        }

            //printArrayList(stringList, -1);
        newId(stringList);
        sortingByIndex(stringList);
        System.out.println("Сортировка по возрасту: ");
        printArrayListNew(stringList);
        sortingByIndexFemMale(stringList);
        System.out.println("Сортировка по полу: ");
        printArrayListNew(stringList);
        scanner1.close();


    }

    public static String[] GetArraeString(String str) {
        String[] result = null;
        result = str.strip().split(" ");
        if (result.length != 5) {
            return null;
        }
        return result;
    }

    public static void printArrayList (ArrayList<String[]> array, int sortby) {

        array.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int res = Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
                return res*sortby;
            }
        });
        for (String[] str: array) {
            System.out.println(String.format("%s %s.%s., %s, %s", str[0], str[1].substring(0,1), str[2].substring(0,1), str[3], str[4] ));
        }
    }
    public static void printArrayListNew (ArrayList<String[]> array) {
        for (String[] str: array) {
            System.out.println(String.format("%s) %s %s.%s., %s, %s", str[0], str[1], str[2].substring(0,1), str[3].substring(0,1), str[4], str[5] ));
        }
    }
    public static void newId (ArrayList<String[]> array) {
        for (int i = 0; i < array.size(); i++) {
            String[] person = array.get(i);
            String[] newPerson = new String[person.length + 1];
            newPerson[0] = String.valueOf(i);
            System.arraycopy(person, 0, newPerson, 1, person.length);
            array.set(i,newPerson);
        }
    }

    public static void sortingByIndex (ArrayList<String[]> array) {
        for (int i = 0; i < array.size()-1; i++) {
            for (int j = 0; j < array.size()-i-1; j++) {
                String[] arr1 = array.get(j);
                String[] arr2 = array.get(j+1);
                int age1 = Integer.parseInt(arr1[4]);
                int age2 = Integer.parseInt(arr2[4]);
                if (age1>age2) {
                    array.set(j,arr2);
                    array.set(j+1,arr1);
                }
            }
        }
    }
    public static void sortingByIndexFemMale (ArrayList<String[]> array) {
        for (int i = 0; i < array.size()-1; i++) {
            for (int j = 0; j < array.size()-i-1; j++) {
                String[] arr1 = array.get(j);
                String[] arr2 = array.get(j+1);
                    String sex1 = arr1[5];
                    String sex2 = arr2[5];
                if (sex1.compareTo(sex2) > 0) {
                    array.set(j,arr2);
                    array.set(j+1,arr1);
                }
            }
        }
    }


}
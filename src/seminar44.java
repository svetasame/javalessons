import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


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
//                continue;
                break;
            }
            stringList.add(baza1);
//            if (baza1[0].equals("exit")){
//                break;
//            }
//            System.out.println(String.format("%s %s.%s., %s, %s", baza1[0], baza1[1].substring(0,1), baza1[2].substring(0,1), baza1[3], baza1[4] ));

        }
        printArrayList(stringList,-1);
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


}
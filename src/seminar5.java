import java.util.*;

public class seminar5 {
    public static void main(String[] args) {
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Integer> id = new ArrayList<>();
        // все поля отдельными списками
        age.add(3);
        age.add(31);
        age.add(75);
        age.add(10);
        age.add(15);
        age.add(5);

        id.add(0);
        id.add(1);
        id.add(2);
        id.add(3);
        id.add(4);
        id.add(5);

        // связать идентификаторы с индексами
        // класс помощник для сортировки и поиска. отсортировал айди используя данные из эйджа
//        Collections.sort(id, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return age.get(o1)- age.get(o2);
//            }
//        });
//
        Collections.sort(id, (o1, o2) -> age.get(o1) - age.get(o2));

        //System.out.println(id);
        //id.forEach(n -> System.out.println(fam.get(n) + age.get(n))); // можно передавать кучу разных полей
        //id.forEach(n -> System.out.print(" " + age.get(n)));


        //hash - какой бы объект не засунули на выходе будет инт - формируется внутренняя индексация объекта
        // хэш всегда разный у двух разных объектов

        Object o = new Object();
        o.hashCode();

        // switch (); - минимальные элементы в яве 50 шт их типа трай кэч и тд
        HashMap<Integer, String> map = new HashMap<>();
        map.put(17, "kkk"); // индекс по формуле хеш17%16 - индекс 1
        map.put(null, "khjk");
        map.put(33, "kвмпвмk");
        // если ключ был уже то он перезапишется если был не нул
        map.putIfAbsent(1, "sgs"); // защита от повреждений записывает только если пусто
        // map.putAll(); добавить весь словарь
        map.replace(1, "vv"); // проверяет наличие ключа. если ключа нет то не записывается.
        // этим отл от пута. есть еще доп проверка со значением ключа
        map.remove(1);
        map.remove(1, "vv"); //- удаление с проверкой было ли такое значение
        map.get(1); //- возвращает значение если нул тоже возвращает
        map.getOrDefault(1, "7"); // если ключа нет то возврщает дефолтное значене которые мы поставили
        map.size(); //- размер
        map.clear(); // очистить

        map.keySet(); // список не повторяющихся элеменвов. ключи никогда не повторяются
        Set<Integer> se = map.keySet();
        for (int i = 0; i < se.size(); i++) {
            System.out.println(map.get((int) se.toArray()[i]));
        }

        for (String s : map.values()) {
            System.out.println(s); // много ограничений
        }

        map.containsValue("kkk"); //истина или ложь сожержит ли значение
        map.containsKey(1); // бул на ключ

        map.compute(1, (key, value) -> value != null ? value + "!" : "0");
        map.computeIfPresent(1, (key, value) -> value == null ? value + "!" : "0");
        map.computeIfAbsent(1, value -> value != null ? value + "!" : "0");

        map.clear();
        HashMap<Integer, Integer> map1 = new HashMap<>();

        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map2.put(i, new Random().nextInt(50));
        }

        for (int i = 0; i < 10; i++) {
            map.put(i, String.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
            map1.put(i, i);
        }
        map.replaceAll((key, value) -> (key + " " + value)); //предлагает изменить значение
        //System.out.println(map);
        map1.replaceAll((key, value) -> (key * value)); //предлагает изменить значение на квадрат произведение ключа и значения
        //System.out.println(map1);

        map1.replaceAll((key, value) -> map2.computeIfPresent(value, (k, v) -> v * key));
        //System.out.println(map2); // ключ для выборке мап 1 валю из мап 1, а модифицируем мап 2  собираем в одну строчку


//        HashMap<Integer, Integer> map3 = new HashMap<>();
//        for (int i = 0; i <10; i++) {
//            map3.put(i, new Random().nextInt(50));
//        }
//        System.out.println(map3);
//        for (Integer in : map3.values()) {
//            if (in%2 == 0) {
//                System.out.print(in+" ");
//            }
//        }
        HashMap<Integer, String> men = new HashMap<>();
        HashMap<Integer, String> women = new HashMap<>();
        men.put(new Random().nextInt(25), "Женя");
        men.put(new Random().nextInt(25), "Вова");
        men.put(new Random().nextInt(25), "Макс");
        men.put(new Random().nextInt(25), "Феликс");
        men.put(new Random().nextInt(25), "Сергей");
        women.put(new Random().nextInt(25), "Кира");
        women.put(new Random().nextInt(25), "Валя");
        women.put(new Random().nextInt(25), "Аня");
        women.put(new Random().nextInt(25), "Лида");
        women.put(new Random().nextInt(25), "Мила");

//        System.out.println(men);
//        System.out.println(women);
//        for (int m: men.keySet()){
//            if (women.containsKey(m)){
//                System.out.println(men.get(m) + "+" + women.get(m));
//            }
//        }

        //ДЗ
        HashMap<String, ArrayList<String>> book = new HashMap<>();

//        addContact(book, "Соколов", "89644431955");
//        addContact(book, "Соколов", "89632431955");
//        addContact(book, "Измайлов", "89644438885");
//        addContact(book, "Иванова", "89643122955");

        //for(int i = 0; i<5; i++) {
            //addContact(book, scan("Введите фамилию: "), scan("Введите телефон: "));
        //}
        //printBook(book);
        addEl(book, "Ivan", "123");
        addEl(book, "Ivan", "12563");
        addEl(book, "Зуек", "1255563");
        addEl(book, "Зуек", "12554686763");
        addEl(book, "Зуек", "1258663");
        ArrayList<String> stringList = new ArrayList<>();
        for (String s: book.keySet()) {
           stringList.add(s);
        }
        Collections.sort(stringList, new Comparator<String>() {
            @Override
           public int compare(String o1, String o2) {
                return book.get(o1).size() - book.get(o2).size();
           }
        });
        System.out.println(stringList);

    }
    private static void addEl(HashMap<String, ArrayList<String>> book, String name, String phone){
        book.putIfAbsent(name, new ArrayList<>());
        book.get(name).add(phone);
    }


    public static void addContact(HashMap<String, ArrayList<String>> book, String name, String phone) {
        ArrayList<String> stringList = book.getOrDefault(name, new ArrayList<>());
        stringList.add(phone);
        book.put(name,stringList);
    }

    public static void printBook (HashMap<String, ArrayList<String>> book) {
        ArrayList<Map.Entry<String, ArrayList<String>>> baza = new ArrayList<>(book.entrySet());
        Collections.sort(baza, new Comparator<Map.Entry<String, ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<String>> o1, Map.Entry<String, ArrayList<String>> o2) {
                return o2.getValue().size() - o1.getValue().size();
            }
        });
        for (Map.Entry<String, ArrayList<String>> i : baza) {
            System.out.println(i.getKey() + ": " + i.getValue());
        }
    }
    public static String scan (String message) {
        String encoding = System.getProperty("console.encoding", "UTF-8");
        Scanner scanner1 = new Scanner(System.in, encoding);
        System.out.println(message);
        String value =  scanner1.nextLine();
        return value;
    }



}

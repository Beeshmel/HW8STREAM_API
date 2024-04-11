import java.util.*;
import java.util.stream.Collectors;

public class TestStreamApi {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        Collections.addAll(list, "C++", "Java", "Python", "JS","C#");
        for (String item : list) {
            if(item.length() > 2){
                System.out.println(item);
            }
        }
//        С помощью метода stream можно преобразовать коллекцию в поток данных stream
        list.stream().filter(item->item.length() > 2).forEach(item -> System.out.println(item));
        list.stream().filter(item->item.length() > 2).forEach(System.out::println);

//        Метод преобразования stream в любую коллекцию - метод collect

        List myList = list.stream().filter(item->item.length() > 2).collect(Collectors.toList());
        System.out.println(myList);

//        Для получения только уникальных элементов используем distinct
        List uniqList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqList);

//        Метод map - преобразует один стим в другой стрим, применяя к каждому элементу
//        первого стрима какую-либо функцию. Результат работы этой функции сохраняется в текущем
//        элементе нового стима

        List sizeItems = list.stream().limit(3).map(item->item.length()).collect(Collectors.toList());
        System.out.println(sizeItems);

//        Примитивный тип данных в объект не преобразуется

        Integer mas[] = {1,2,3,5};
        Set y =  Arrays.stream(mas).collect(Collectors.toSet());//это работать не будет, так как массив постоянный
        Set<Integer> y1 = Set.of(mas);//преобразовали массив обязательно уникальных элементов в set

//        Для обхода set есть разные способы:

//        1ый способ
         y1.forEach(System.out::println);

//        2ой способ - обход через iterator. Итератор - это объект перечислитель,
//        то есть он знает о каждом элементе нашей коллекции
        Iterator<Integer> it = y1.iterator();
        while(it.hasNext()) {//до тех пор пока в коллекции есть элементы, получаем их с помощью итератора
            int value = it.next();//получаем текущий элемент
            System.out.println(value);
        }


        y1.forEach(System.out::println);


//        Получим первый элемент из коллекции, где элемент содержит 2 буквы

//        После методов filter,map,limit,distinct всегда получаем новый стим, поэтому можно
//                снова вызывать методы, которые существуют в Stream API

//        Метод findFirst найдет первый элемент в Stream и вернет объект Optional
//        С помощью объекта Optional для получения элемента без проверки на его существование
//        используем метод get:
        //System.out.println(list.stream().filter(item -> item.length() == 8).findFirst().get()); ЗДЕСЬ ОШИБКА ЕСТЬ

//        Если элемент не будет найден, то get вернет null. Если нас не устраивает null и нужно
//        вывести текст сообщения, что элемент не найден, используйте orElse

        System.out.println(list.stream()
                    .filter(item -> item.length() == 8)
                    .findFirst().orElse("Элемент не найден"));
    }
}

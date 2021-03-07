import java.util.*;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) {
        //не поддерживает каких-либо структурных изменений
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        //преобразуем в поток
        intList.stream()
                //исключаем все элементы > 0
                .filter(num -> num > 0)
                //исключаем все элементы нечетные элементы
                .filter(num -> num % 2 == 0)
                //сортируем элементы по возрастанию
                .sorted(Comparator.naturalOrder())
                //Выводим на экран и уничтожаем поток
                .forEach(System.out::println);
    }

}

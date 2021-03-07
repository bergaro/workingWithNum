import java.util.*;

public class Main {
    private static boolean replace = false;             //Необходимость повторного вызова функции перестановки элементов

    public static void main(String[] args) {
        //не поддерживает каких-либо структурных изменений
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        System.out.println(filterList(intList));
    }
    /**
     * <p>
     *     Выделяет из списка положительные чётные элементы.
     * </p>
     * <p>
     *     После чего производит перестаноку элеменотв методом
     *     sortList() до того момента пока поле класса replase
     *     не примет отрицательное значение.
     * </p>
     * @param intList не сортированный список
     * @return отсортированнай, в порядке возрастания, список положительных чётных элементов.
     */
    public static List<Integer> filterList(List<Integer> intList) {
        List<Integer> newList = new ArrayList<>();
         for(int num : intList) {
             if(num > 0 && num % 2 == 0) {
                 newList.add(num);
             }
         }
         newList = sortList(newList);
         while (replace) {
             newList = sortList(newList);
         }
         return newList;
    }
    /**
     * <p>
     *     Производит перестановку элементов списка
     *     от меньшего к большему. Если перестановка
     *     элементов состоялась хотя бы один раз,
     *     изменяет флаг replace на true.
     * </p>
     * <p>
     *     Иначе replace = false
     * </p>
     * @param numList не отсортированный список
     * @return единожды отсортированный список
     */

    private static List<Integer> sortList(List<Integer> numList) {
        int indexNum = 0;
        int prevNum = 0;
        List<Integer> sortedList = new ArrayList<>();
        boolean replacingElements = false;
        for(int element : numList) {
            if(element < prevNum) {
                sortedList.add(indexNum - 1, element);
                replacingElements = true;
            } else if(element > prevNum) {
                sortedList.add(element);
                prevNum = element;
            }
            indexNum++;
        }
        if(replacingElements) {
            replace = true;
        } else {
            replace = false;
        }
        return sortedList;
    }
}


public class HashMap<K, V> {                   // К - обобщение для ключа, V - Обобщение для значения

    private V[] arr =  (V[])new Object[8];     // Массив значений


    /**
     * Метод для вычисления ключа элемента - позиции по хешу
     * @param key ключ
     * @return позиция
     */
    public int hash(K key){
        System.out.println(key.hashCode());
        return Math.abs(key.hashCode())%arr.length;
    }

    /**
     * Метод для вставки элемента по ключу
     * @param key ключ
     * @param value значение
     */
    public void insert(K key, V value){
       int pos = hash(key);                 // Получаю индекс для вставки в массив
        while (arr[pos] != null){
            ++pos;
            pos %= arr.length;
            System.out.println("Провели пробирование ");
        }
       arr[pos] = value;
    }

    /**
     * Поиск элемента по ключу
     * @param key ключ
     * @return элемент
     */
    public V find(K key){                                 // TODO Решить проблему пробирования.
        int pos = hash(key);
        return arr[pos];
    }

    /**
     * Отображения всего массива
     */
    public void display(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void delete(K key, V value){    // TODO Подумать как можно обойтись без передачи двух параметров. Варианты решения - хешировать сам элемент: 1) хранение по позиции(только уникальные элементы), хранение в связных списках(хешируются позиции списка в массиве, т.е. создается массив списков); 2) Создать класс для элемента, в котором бует хранится конечный индекс этого элемента
        int pos = hash(key);
        while (arr[pos] != null){
            if(arr[pos].equals(value)){
                arr[pos] = null;
                break;
            }
            ++pos;
            pos %= arr.length;
        }
    }




}

package ir.maktab;

import com.github.javafaker.Faker;
import ir.maktab.domain.Transaction;
import ir.maktab.domain.TransactionType;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        List<String> list = new ArrayList<>();
//        list.add("Apple");
//        list.add("Banana");
//        list.add("Orange");
//
//        System.out.println(list);
//        System.out.println("Element At 2: " +list.get(2));
//        list.remove(2);
//        System.out.println("After remove this Element");
//        System.out.println(list);
//
//        for (String fruit : list) {
//            System.out.println(fruit);
//        }

//        Set<String> set = new HashSet<>();
//        set.add("Apple");
//        set.add("Orange");
//        set.add("Apple");
//
//        for (String fruit:set){
//            System.out.println(fruit);
//        }

//        Map<Integer,String> map = new HashMap<>();
//        map.put(1,"Apple");
//        map.put(2,"Banana");
//        map.put(3,"Orange");
//
//        for (Map.Entry<Integer,String> entry : map.entrySet()){
//            System.out.println("Key: "+ entry.getKey()+", Value: " + entry.getValue());
//        }

//        Scanner scanner = new Scanner(System.in);
//        Random random = new Random();
//        String num = "";
//        List<Integer> numList = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            int j = random.nextInt(0,9);
//            System.out.print(j);
//            numList.add(i);
//            num += Integer.toString(i);
//        }
//        //System.out.println(num);
//        Collections.sort(numList);
//        List<Integer> sortedNum = new ArrayList<>();
//        String sortNums = "";
//        for (int i : numList ){
//            sortNums += Integer.toString(i);
//        }
//        System.out.println();
//        System.out.println("--------------");
//        System.out.println(sortNums);
//        Set<Integer> uniqueNumbers = new HashSet<>();
//
        List<String> names = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 5; i++) {
            names.add(faker.name().firstName());
        }
        String name = names.get(1);
        names.add(name);
        System.out.println(names);
        Collections.sort(names);
//        System.out.println(names);
//        Set<String> uniqueSet = new HashSet<>();
//        for (String name1 : names){
//            uniqueSet.add(name1);
//        }
//        System.out.println(uniqueSet);
//        Transaction transaction = new Transaction(TransactionType.Withdraw,30000);
//        Collection<String> names = new ArrayList<>();
//        names.add("Ali");
//        names.add("Alireza");
//        names.add("MohammadAli");
//        names.add("Neda");
//        names.forEach(name -> System.out.println("Name "+name));
    }
}
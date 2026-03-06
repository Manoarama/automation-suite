package question.example.test;

import java.util.*;

public class SandP_Atyati {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,3,4,5,5);
        findNumbers(list);   // method call
    }
    public static void findNumbers(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int a : list) {
            if (frequencyMap.containsKey(a)) {
                frequencyMap.put(a, frequencyMap.get(a) + 1);
            } else {
                frequencyMap.put(a, 1);
            }
        }

        Set<Integer> nonRepeating = new HashSet<>();
        Set<Integer> repeating = new HashSet<>();

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                nonRepeating.add(entry.getKey());
            } else {
                repeating.add(entry.getKey());
            }
        }

        System.out.println("Non-Repeating: " + nonRepeating);
        System.out.println("Repeating: " + repeating);
    }     /* for(int a:list){
           // emp_id,emp_name,manager_id -MasterTable

            //Select manager_id,emp_name as sum(numb_emp) from table MasterTable where group by(manager_id) having
            //

        }*/




}

package question.example.comparable.Laptop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LaptopRunnerComparable {

    public static void main(String[] args) {
        List<Laptop> laptop=new ArrayList<>();
        laptop.add(new Laptop("Dell",16,800));
        laptop.add(new Laptop("Apple",8,1200));
        laptop.add(new Laptop("Acer",12,700));
        Collections.sort(laptop);
        for (Laptop  lap:laptop){
            System.out.println(lap);
        }
    }
}

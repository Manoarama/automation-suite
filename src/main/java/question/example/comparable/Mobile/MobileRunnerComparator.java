package question.example.comparable.Mobile;

import question.example.comparable.Laptop.Laptop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MobileRunnerComparator {

    public static void main(String[] args) {
        List<Mobile> mobile=new ArrayList<>();
        mobile.add(new Mobile("Dell",16,800));
        mobile.add(new Mobile("Apple",8,1200));
        mobile.add(new Mobile("Acer",12,700));

        Comparator<Mobile> comparator=new Comparator<Mobile>() {
            @Override
            public int compare(Mobile mobile1, Mobile mobile2) {
                if(mobile1.getPrice()> mobile2.getPrice())
                return 1;
                else
                    return -1;
            }
        };
        //Comparator<Mobile> comparator1 = (mobile1, mobile2) -> Integer.compare(mobile1.getPrice(), mobile2.getPrice());
        Collections.sort(mobile,comparator);
        for (Mobile  m:mobile){
            System.out.println(m);
        }
    }
}

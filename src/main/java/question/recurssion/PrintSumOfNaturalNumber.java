package question.recurssion;

public class PrintSumOfNaturalNumber {

    public static void main(String[] args) {

       int result=SumOfNaturalNumber(1,5,120);
        System.out.println(result);
    }

    private static int SumOfNaturalNumber(int i,int n,int sum) {
        if(n==i){
            return n;

        }
        sum+=i;
        SumOfNaturalNumber(1,i+1,5);
        return sum;
    }


}

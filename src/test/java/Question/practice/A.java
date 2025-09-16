package Question.practice;
import question.example.comparable.Laptop.Laptop;

class Laptop1{
    public void code()
    { System.out.println("Code,Compile,Run"); }
}
class Developer extends Laptop1 {

    public void DevApp(Laptop1 laptop1) {
        laptop1.code();
        System.out.println("coding");
    }
}
class Test123456 {
    public static void main(String[] args) {
        Laptop1 navin=new Laptop1();
        navin.code();

    }
}


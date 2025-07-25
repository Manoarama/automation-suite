package question.example.test;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Main {
    public static void main(String[] args) {
        Main mani = new Main();
        String s="M";
        int i=5;
        mani.getsound(s);
        mani.getsound(i);
        mani.getsound(s,i);


    }

        /*Scanner scnner=new Scanner (System.in);
        scanner*/

    //non access modifier
    public void getsound(String Sound){
        System.out.println("In one String parameter");
    }
    public void  getsound(int Sound){
        System.out.println("In one int parameter");
    }
    public void  getsound(String Hear,int Sound){
        System.out.println("In one int and String parameter");
    }
}


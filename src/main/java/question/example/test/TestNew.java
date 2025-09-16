package question.example.test;

public class TestNew {

    public static TestNew  testnew;

    public void getNewObject(){
        if(testnew==null){
            testnew=new TestNew();
        }
    }

    public TestNew getInstance(){
      return testnew;
    }
}

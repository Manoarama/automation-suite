package question.example.leetCode;

public class QuestionAsked {/*Dey, Rajashree 16:19
    inputString = "Hello Hello World World"

    outputString = "Hello World
    String s="12345";
    How to find the string contains only digits.
    class A {
// does something.
    }
    class B {
        A a = new A();
    }
    class C {
        A a = new A();
    }
    class D {
    }

    Dey, Rajashree 16:29
    STUDENT
            Rollnumber, name
1, Sunitha
2, Aditi
3, Roy
4. Kumud


    MARKS:
    rollnumber, subject, marks
1, hindi, 70
            2, sanksrit, 75
            3, Sanskrit, 69
            4. maths, 80

    Q- What are the names of students who got marks >=70
    How many students got marks >=70

    You 16:35
    Select  marks,count(*) from MARKS where marks >=70

    Dey, Rajashree 16:36
    {
   “student”: {
        “name”: “s1”,
        “rollnumber”: 1
    }
    }
    Jsonpath for rollnumber
            CUCUMBER



    Purchaser comes to shop to return item. Refund will be issued if the purchase was made within last 10 days

    sony -api,java -13
    ---------------------------

    automation-suite-MSRCosmosGroup

1800-419-1173-medibedi


Delete columnName from tablename where columnName>2

0,1,2,0,1,2


0,0,1,1,2,2


create
update

get api
--------------------------
int z = 10;
System.out.println(z /= (z % 3) + 1)
z=10/2


Frame A ->Frame B->Frame C


@BeforeClass -TestE()    @BeforeMethod--TestB()
@AfterClass  -TestD()



@test
testC()


@test
testA()


TestE()

TestB()
testC()

TestB()
testA()

TestD()

WebDriver dr=new WebDriver();

public static DBConnectionManager getInstance() {
    if (instance == null) {
        synchronized (DBConnectionManager.class) {
            if (instance == null) {
                instance = new DBConnectionManager();
            }
        }
    }
    return instance;
}
------------------------------------------------------------

List<String> result ;

for(int i=0;i<result.size;i++){



}


Respone response=given().when().

then(response.as Class ()).getstatuscode("200")

threadcount=2 excecute=parallel



executeTestCase(){

Testclass obj=new TestClass();

Thread t1=new thread(obj.);
t1.start


Thread t2=new thread(obj.);
t1.start

}


public class A{

public static void main(String[] args){

String input="Manorama";

String result;

for(i=input.length;i<0;i--){

result=result+charAt(i);
}
}




187669
}

----------------------------------------------------------------
 You are given an array S consisting of N strings. Every string is of the same length M. Your task is to find a pair of strings in array S, such that there exists a position in which both of the strings have the same letter. Both the index in array S and the positions in the strings are numbered from zero.
For example, given S = ["abc", "bca", "dbe"], string 0 ("abc") and string 2 ("dbe") have the same letter 'b' in position 1.
On the other hand, for strings "abc" and "bca" there does not exist a position in which they have the same letter.
Write a function: class Solution { public int[] solution(String[] S); } that, given a zero-indexed array S of N strings, returns an array describing a pair of strings from S which share a common letter at some index.
If there is no such pair, the function should return an empty array. If there is more than one correct answer, the function can return any of them. The result should be represented as an array containing three integers.
The first two integers are the indexes in S of the strings belonging to the pair. The third integer is the position of the common letter.
For S = ["abc", "bca", "dbe"], as above, the result array should be represented as [0, 2, 1].
Another correct answer is [2, 0, 1], as the order of indexes of strings does not matter.
Examples:
1. Given: S = ["abc", "bca", "dbe"], your function may return [0, 2, 1] as described above.



S = ["abc", "bca", "dbe"]---abc" "dbe"--same index b


class Solution {

 public int[] solution(String[] S);



}


[12,6,15,8,0,5,9,3] find the largest number in the given array of integers


public class A{

public static void main(String[] args){


int []input=[12,6,15,8,0,5,9,3];

 int largest=0;

for(int i=1;i<input.length-1;i++){

if(input[i]>largest){

int largest=input[i];


}


}
}
--------------------------
xample:
|UserName|Password|City|Hobbie|
|Manorama|123|Mumbai|Playing Chess|
|Ram|456|Bengaluru|Singing|


Class A
{
 	public final void display()
 	{
 		SYSO("Hi");
 	}
}
Class B extends A
{
 	public static void main(String args[])
 	{

 	}
}

Map<String ,List<String>>


List<String> list=new ArrayList<>();
list.get(1).add("Ram")
list.get(4).add("Ram")
list.get(0).add("Manorama")


Set<String> data=new HashSet<>();

Map<String ,Integer> map=new HaspMap<>();
map.put("Manorama",4);
map.put("KKKK",4);
map.put("Ram",5);


MAp->List

Entry.Map<<String ,Integer> entry:map.Entryset(){
entry.getKey()
entry.getValue()
}

List<Map<String, Integer>> mapObj=new Map<>()
mapObj.add()

playwite +type script
manula l -Bruno
Prefornance
-------------------------------------------------------

Count the vowels
//Input : Hello World
//Output : H1ll2 W3rld

/Input : rhythma
//output : rhythm1

// Online Java Compiler

// Use this editor to write, compile and run your Java code online

class Main {

    public static void main(String[] args) {

        System.out.println("Try programiz.pro");

        //Input : Hello World //Output : H1ll2 W3rld

        //Input : rhythma // output : rhythm1

        String input=" Hello World";

        Map<Character,Integer> map=new HashMap<>();

        int count=0;

        for(Char c:input.toCharArry){

           map.put(Character.towerCase(c),count) ;

            count++;

        }

          StringBuilder sb=new StringBuilder();

     for( Entry.Map<Character,Integer> entry:map.EntrySet()){

         if ('aeiou'.IsCharacters(entry.getKey())){

             int vowelCount=0;

             sb.add(vowelCount);

             vowelCount++;

         }

         else{

             sb.add(entry.getKey())

         }

         if(''IsCharacter(entry.getKey()))

          sb.add(entry.getKey());

     }

    }

}

import java.util.*;

class Main {

    public static void main(String[] args) {

  Character[] original = {'a', '1', 'b', '2','c', '3', 'd', '4'};

List<Integer>  intergerList=new ArrayList<>();

List<Character>  characterrList=new ArrayList<>();


for(int i=0;i<original.length;i++){

if(Character.IsDigit(original[i])){

    intergerList.add(original[i]);

}

if (Character.IsCharacter(original[i])){

    characterrList.add(parseInteger(original[i]));

}

}

}}
ubs-karate pune-


joshana- HCL requirement serogram
-------------------------------------------------------------
Q3 (Medium): Remove Duplicate Characters
Task: Remove duplicates while preserving character order.
Signature: String removeDuplicates(String input)
Example: Input: "automation" → Output: "automn"



Scenario:
Login button becomes clickable after spinner disappears.
•	Spinner ID: loadingSpinner
•	Button ID: submitBtn
Task:
•	Wait for spinner to disappear
•	Wait for button to be clickable wait.expectededCondiontionMeet(driver.findElement(By.id("loadingSpinner")))
•	Click the button---driver.findElement(By.id("loadingSpinner")).click();
•	Use explicit wait strategy WebDriverWait wait =new WebDriverWait();
					wait.untilexpectededCondiontion(driver.findElement(By.id("submitBtn")));




Scenario: Test a typical POST/GET API flow using REST Assured or Java pseudocode.
Task:
1.	Send a POST request to create a user (/users)
o	Body: { "name": "John", "email": "john@test.com" }
2.	Assert status = 201
3.	Extract the userId from the response
4.	Send a GET request to /users/{userId}
5.	Assert returned email = "john@test.com"




public class UserApiTest {

    @Test
    public void createAndGetUser() {
        // Base URI
        RestAssured.baseURI = "https://your-api-base-url.com";

        Response postResponse = given()
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"John\", \"email\": \"john@test.com\" }")
                .when()
                .post("/users");


        assertEquals(postResponse.getStatusCode(), 201, "Expected status code 201");


        int userId = postResponse.jsonPath().getInt("id");
        System.out.println("Created userId: " + userId);


        Response getResponse = given()
                .when()
                .get("/users/" + userId);
        String returnedEmail = getResponse.jsonPath().getString("email");
        assertEquals(returnedEmail, "john@test.com", "Email did not match expected value");
    }
}-------------------------------------------------------------------

Our automation framework follows a modular and layered architecture with the following components:

Test Layer – Contains the actual test cases written in TestNG using REST-assured or Selenium.

Business Layer – Contains reusable methods for test flows (e.g., login(), createUser(), verifyResponse()).

Service Layer – Handles API requests and responses using REST-assured.

Utility Layer – Provides utilities for Excel reading, DB validation, JSON comparison, etc.

Data Layer – Test data is managed via Excel, JSON, or properties files using DataProvider or external sources.

Configuration Layer – Environment-based configuration using config.properties or YAML files.

Reporting Layer – Generates logs (Log4j/SLF4J) and reports (ExtentReports/Allure).


test strategy ,test planning ,restASURED,
one and half hour

Reporting

Impliments iTestListener or extend testListener Adapter
Time Complexity-Total call*work done in each call
Space Complexity recursion tree-Height of call stack?depth of recursion tree

ExtentSparkReporter-UI of the report
ExtentReport-Populate common info of the report
ExtentTest-Creating test case entries in the report and update status of the test method

sele@niu&mau%to*ma#tion!
seleniumisanopensourceautomationtool
https://testautomationpractice.blogspot.com/
https://fruityvice.com/api/fruit/all

Student     Marks -Roll,
		sub,
		marks
name,
roll


select * from s.Student inner join on m.Marks where s.roll=m.roll and m.marks>70;
In RESTful APIs, different HTTP methods typically return different status codes depending on the outcome of the request. Here's a breakdown of common status codes by HTTP method:


@Given"Loging in amazon"

A a=new A();
Loging in amazon(){

}
api chaining -
select column_name from table table_name where limit 1 offset 2;

509 febonachi




    */

}

package days16;
class Parent {
    int num = 10;
    
    void printNum() {
        System.out.println(num);
    }
}
 
class Child extends Parent {
    int num = 20;
    
    void printNum() {
        System.out.println(num);
    }
}
 
public class ObjectCastTest {
    public static void main(String args[]) {
        Parent p = new Child();
        p.printNum();    // 20
        System.out.println(p.num);    // 10
    }
}

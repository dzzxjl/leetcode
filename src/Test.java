/**
 * Created by dzzxjl on 2017/4/4.
 */
public class Test {

//        public static class InnerClass {
//            public InnerClass() {
//                System.out.println("创建InnerClass");
//            }
//        }
    public class InnerClass {
        public InnerClass() {
            System.out.println("创建InnerClass");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        InnerClass a = test. new InnerClass();
        InnerClass b = test. new InnerClass();

        String str = "hello";
//        str.length()

    }
}

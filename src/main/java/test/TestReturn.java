package test;

/**
 * Created by Ecic Chen on 2016/2/15.
 */
public class TestReturn {

    public static void main(String[] args) {
        System.out.println(testReturn());
    }


    public static String testReturn(){
        try {
            System.out.println("11");
            int i = 0;
            int j = 1/i;
        }catch (Exception e){
            return "3";
        }finally {
            System.out.println("22");

        }
        return "2";
    }
}

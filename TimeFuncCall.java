/**
 * Call a function 10 times and wait 5 seconds before calling it again
 */
public class TimeFuncCall {

    public static void main(String[] args) {
        funcCall();
    }

    static void funcCall() {

        for(int i = 1; i <= 10; i++) {
            double start = System.currentTimeMillis();
            System.out.println("hello");
            double finish = System.currentTimeMillis();
            if(i == 10) {
                try {
                    Thread.sleep(5000);
                    i = 1;
                    System.out.println();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

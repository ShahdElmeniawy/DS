import java.rmi.*;
import java.util.*;

public class Client {
    public static void main(String args[]) {
        String server = "localhost";
        Scanner scanner = new Scanner(System.in);
        String exp[] = args;
        scanner.close();
        try{
            RemoteInterface obj = (RemoteInterface) Naming.lookup("rmi://" + server + "/RemoteInterface");
            int a = Integer.parseInt(exp[0]);
            String operator = exp[1];
            int b = Integer.parseInt(exp[2]);
            int result = 0;
            switch (operator) {
                case "+":
                    result = obj.add(a, b);
                    break;
                case "-":
                    result = obj.subtract(a, b);
                    break;
                case "*":
                    result = obj.multiply(a, b);
                    break;
                case "/":
                    result = obj.divide(a, b);
                    break;
                default:
                    System.out.println("Invalid operator");
                    System.exit(1);
            }
            System.out.println("Result: " + result);
        } catch (Exception e) {
        System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

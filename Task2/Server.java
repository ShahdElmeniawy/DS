import java.rmi.*;

public class Server {
    public static void main(String args[]) {
        try {
            ServerImplementation addRemImpl = new ServerImplementation();
            Naming.rebind("rmi:///RemoteInterface", addRemImpl);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
    
}

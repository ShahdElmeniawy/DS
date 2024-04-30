import java.rmi.*;
public interface RemoteInterface extends Remote {
    public int add(int a, int b) throws RemoteException;
    public int subtract(int a, int b) throws RemoteException;
    public int multiply(int a, int b) throws RemoteException;
    public int divide(int a, int b) throws RemoteException;
}




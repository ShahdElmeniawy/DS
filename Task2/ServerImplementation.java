import java.rmi.*;

import java.rmi.server.UnicastRemoteObject;
public class ServerImplementation extends UnicastRemoteObject implements RemoteInterface {
    public ServerImplementation() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    public int subtract(int a, int b) throws RemoteException{
        return a - b;
    }

    public int multiply(int a, int b) throws RemoteException{
        return a * b;
    }

    public int divide(int a, int b) throws RemoteException{
        return a / b;
    }
}




package DATABASE;

import DATABASE.Service.IDataBaseRemoteImp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class DataBaseMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        IDataBaseRemoteImp serverDatabase = new IDataBaseRemoteImp();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("serverDatabase",serverDatabase);
        System.out.println("the server of databse is up ...");

    }
}

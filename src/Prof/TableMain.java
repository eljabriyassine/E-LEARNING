package Prof;

import Prof.Service.ITableRemoteImp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TableMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        ITableRemoteImp serverTable = new ITableRemoteImp();
        Naming.rebind("serverTable",serverTable);
        System.out.println("server TAble is up ...");
    }
}

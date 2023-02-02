package Prof;

import Prof.Service.IProfRemoteImp;
import Prof.Service.ITableRemoteImp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ProfMain {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        IProfRemoteImp serverProf = new IProfRemoteImp() ;
        Naming.rebind("serverProf",serverProf);
        ITableRemoteImp serverTable = new ITableRemoteImp();
        Naming.rebind("serverTable",serverTable);
        System.out.println("the server of prof is up ...");

    }
}

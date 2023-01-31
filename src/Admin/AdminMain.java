package Admin;

import Admin.Service.IAdminRemoteImp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class AdminMain {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        IAdminRemoteImp serverAdmin = new IAdminRemoteImp();
        Naming.rebind("serverAdmin",serverAdmin);
        System.out.println("the server of admin is up ...");
    }
}

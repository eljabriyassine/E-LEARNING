package Etudiant;

import Etudiant.Service.ITableEtudiantRemoteImp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class TableEtudiantaMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        ITableEtudiantRemoteImp serverTableEtudiant = new ITableEtudiantRemoteImp();
        Naming.rebind("serverTableEtudiant",serverTableEtudiant);
    }
}

package Etudiant;

import Etudiant.Service.IEtudiantRemote;
import Etudiant.Service.IEtudiantRemoteImp;
import Etudiant.Service.ITableEtudiantRemoteImp;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EtudiantMain {
    public static void main(String[] args)  {
        try {
            IEtudiantRemoteImp serverEtudiant = new IEtudiantRemoteImp();
            Naming.rebind("serverEtudiant", serverEtudiant);
            ITableEtudiantRemoteImp serverTableEtudiant = new ITableEtudiantRemoteImp();
            Naming.rebind("serverTableEtudiant",serverTableEtudiant);
            System.out.println("the servre of Etudiant is up ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
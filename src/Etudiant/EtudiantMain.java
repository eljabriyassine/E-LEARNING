package Etudiant;

import Etudiant.Service.IEtudiantRemote;
import Etudiant.Service.IEtudiantRemoteImp;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class EtudiantMain {
    public static void main(String[] args)  {
        try {
            IEtudiantRemoteImp serverEtudiant = new IEtudiantRemoteImp();
            Naming.rebind("serverEtudiant", serverEtudiant);
            System.out.println("the servre of Etudiant is up ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
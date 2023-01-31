package Etudiant.Service;

import ClasseMetier.Classe;
import ClasseMetier.Message;
import Etudiant.Etudiant;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class IEtudiantRemoteImp extends UnicastRemoteObject implements IEtudiantRemote {
    private Etudiant etudiant = new Etudiant();

    public IEtudiantRemoteImp() throws RemoteException, MalformedURLException, NotBoundException {
        super();
    }


    @Override
    public boolean getAuthentifierEtudiant(Etudiant etudiant) throws RemoteException {
        return etudiant.getAuthentifierEtudiant(etudiant);
    }

    public List<Classe> getAllClasseOfEtudiant(String name_etudiant) throws RemoteException{
        return etudiant.getAllClasseOfEtudiant(name_etudiant);
    }

    public List<Message> getMessageinsideClasse(String name_classe , String name_etudiant) throws RemoteException{
        return etudiant.getMessageinsideClasse(name_classe,name_etudiant);
    }
}

package Etudiant.Service;

import ClasseMetier.Classe;
import ClasseMetier.Message;
import Etudiant.Etudiant;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IEtudiantRemote extends Remote {
    public boolean getAuthentifierEtudiant(Etudiant etudiant) throws RemoteException;
    public List<Classe> getAllClasseOfEtudiant(String name_etudiant) throws RemoteException;
    public List<Message> getMessageinsideClasse(String name_classe , String name_etudiant) throws RemoteException;
}

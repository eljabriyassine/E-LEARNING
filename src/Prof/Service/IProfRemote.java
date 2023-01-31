package Prof.Service;

import ClasseMetier.Classe;
import Etudiant.Etudiant;
import Prof.Prof;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IProfRemote extends Remote {
    public boolean getAuthentifierProf(Prof prof) throws RemoteException;
    public int getIdProfByName(String name) throws RemoteException;
    public List<Classe> getAllClasseOfProf (int id_prof) throws RemoteException;
    public List<Etudiant> getAllEtudiantInClasse(String name_classe,int id_classe) throws RemoteException;

    public int  getIdClasseByName(String name_classe,int id_prof)throws RemoteException ;
//
    public int  getIdEtudiantByName(String username) throws RemoteException;
    public boolean addEtudiantInClasse(String name_classe,String name_etudiant) throws RemoteException;

    public boolean  SharMessageInClasse (int id_classe , String Message) throws RemoteException;

}

package DATABASE.Service;

import Admin.Admin;
import ClasseMetier.*;
import Etudiant.Etudiant;
import Prof.Prof;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDataBaseRemote extends Remote  {
    public boolean getAuthentifier (Admin admin) throws RemoteException;
    public boolean addProf(Prof prof) throws RemoteException;
    public boolean addEtudiant(Etudiant etudiant) throws RemoteException;
    public int getIdProfByName (String username) throws RemoteException;
    public String getNameProfById(int id_prof) throws RemoteException;
    public boolean addClasse(Classe classe) throws RemoteException;
    public List<Prof> getAllProfs() throws RemoteException;
    public List<Etudiant> getAllEtudiant() throws RemoteException;
    public List<Classe> getAllClasse() throws RemoteException;
    public boolean getAuthentifierProf(Prof prof) throws RemoteException;
    public List<Classe> getAllClasseOfProf(int id_prof) throws RemoteException;
    public List<Etudiant> getAllEtudiantInClasse(String name_classe) throws RemoteException;
    public int  getIdEtudiantByName(String username) throws RemoteException;
    public int  getIdClasseByName(String name_classe) throws RemoteException;
    public boolean addEtudiantInClasse(int id_classe,int id_etudiant) throws RemoteException;
    public boolean  SharMessageInClasse (int id_classe , String Message) throws RemoteException;
    public boolean getAuthentifierEtudiant(Etudiant etudiant) throws RemoteException;
    public List<Classe> getAllClasseOfEtudiant(String name_etudiant) throws RemoteException;
    public List<Message> getMessageinsideClasse(String name_classe) throws RemoteException;



}


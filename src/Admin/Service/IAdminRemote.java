package Admin.Service;

import Admin.Admin;
import ClasseMetier.Classe;
import Etudiant.Etudiant;
import Prof.Prof;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IAdminRemote extends Remote {
    public boolean getAuthentifier(Admin admin) throws RemoteException;
    public boolean addProf(String username,String password,String password2) throws RemoteException, MalformedURLException, NotBoundException;
    public boolean addEtudiant(String username,String password,String password2) throws RemoteException, MalformedURLException, NotBoundException;
    public int getIdProfByName (String username) throws RemoteException;
    public String getNameProfById(int id_prof) throws RemoteException;
    public boolean addClasse(int id_prof,String name_classe,String description) throws RemoteException;
    public List<Prof> getAllProfs() throws RemoteException;
    public List<Etudiant> getAllEtudiant() throws RemoteException;
    public List<Classe> getAllClasse() throws RemoteException;

}

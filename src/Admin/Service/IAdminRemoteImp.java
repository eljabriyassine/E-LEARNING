package Admin.Service;

import Admin.Admin;
import ClasseMetier.Classe;
import Etudiant.Etudiant;
import Prof.Prof;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class IAdminRemoteImp extends UnicastRemoteObject implements IAdminRemote {
    private  Admin admin = new Admin();

    public IAdminRemoteImp() throws MalformedURLException, NotBoundException, RemoteException {
    }

    @Override
    public boolean getAuthentifier(Admin admin) throws RemoteException  {
        return this.admin.getAuthentifier(admin);
    }

    @Override
    public boolean addProf(String username,String password,String password2) throws RemoteException, MalformedURLException, NotBoundException {
        return admin.addProf(username,password,password2);
    }

    @Override
    public boolean addEtudiant(String username,String password,String password2) throws RemoteException, MalformedURLException, NotBoundException {
        return admin.addEtudiant(username,password,password2);
    }

    @Override
    public int getIdProfByName(String username) throws RemoteException {
        return admin.getIdProfByName(username);
    }

    public String  getNameProfById(int id_prof) throws RemoteException{
        return admin.getNameProfById(id_prof);
    }

    @Override
    public boolean addClasse(int id_prof,String name_classe,String description) throws RemoteException {
        return admin.addClasse(id_prof,name_classe,description);
    }

    @Override
    public List<Prof> getAllProfs() throws RemoteException {
        return admin.getAllProfs();
    }

    @Override
    public List<Etudiant> getAllEtudiant() throws RemoteException {
        return admin.getAllEtudiant();
    }

    @Override
    public List<Classe> getAllClasse() throws RemoteException {
        return admin.getAllClasse();
    }


}

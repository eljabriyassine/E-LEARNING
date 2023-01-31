package Prof.Service;

import ClasseMetier.Classe;
import Etudiant.Etudiant;
import Prof.Prof;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class IProfRemoteImp extends UnicastRemoteObject implements IProfRemote {
    private Prof prof = new Prof();

    public IProfRemoteImp() throws MalformedURLException, NotBoundException, RemoteException {
    }

    @Override
    public boolean getAuthentifierProf(Prof prof) throws RemoteException {
        return this.prof.getAuthentifierProf(prof);
    }

    @Override
    public int getIdProfByName(String name) throws RemoteException {
        return prof.getIdProfByName(name);
    }

    @Override
    public List<Classe> getAllClasseOfProf(int id_prof) throws RemoteException {
        return prof.getAllClasseOfProf(id_prof);
    }
    @Override
    public List<Etudiant> getAllEtudiantInClasse(String name_classe,int id_classe) throws RemoteException{
        return prof.getAllEtudiantInClasse(name_classe,id_classe);
    }

    @Override
    public int getIdClasseByName(String name_classe,int id_prof) throws RemoteException {
        return prof.getIdClasseByName(name_classe,id_prof);
    }

    @Override
    public int getIdEtudiantByName(String username) throws RemoteException {
        return prof.getIdEtudiantByName(username);
    }

    @Override
    public boolean addEtudiantInClasse(String name_classe, String name_etudiant) throws RemoteException {
        return prof.addEtudiantInClasse(name_classe,name_etudiant);
    }

    public boolean  SharMessageInClasse (int id_classe , String Message) throws RemoteException{
        return prof.ShareMessageInClasse(id_classe,Message);
    }

}

package DATABASE.Service;

import Admin.Admin;
import ClasseMetier.Classe;
import ClasseMetier.Message;
import Etudiant.Etudiant;
import Prof.Prof;
import DATABASE.DataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class IDataBaseRemoteImp extends UnicastRemoteObject implements IDataBaseRemote {
    private DataBase db = new DataBase();
    public IDataBaseRemoteImp() throws RemoteException {
        super();
    }


    @Override
    public boolean getAuthentifier(Admin admin) {
        return db.getAuthentifier(admin);
    }


    @Override
    public boolean addProf(Prof prof) {
        return db.addProf(prof);
    }

    @Override
    public boolean addEtudiant(Etudiant etudiant) {
        return db.addEtudiant(etudiant);
    }

    @Override
    public int getIdProfByName(String usernmae) throws RemoteException {
        return db.getIdProfByName(usernmae);
    }

    @Override
    public String getNameProfById(int id_prof) throws RemoteException {
        return db.getNameProfById(id_prof);
    }


    @Override
    public boolean addClasse(Classe classe) {
        return db.addClasse(classe);
    }

    @Override
    public List<Prof> getAllProfs() {
        return db.getAllProfs();
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return db.getAllEtudiant();
    }

    @Override
    public List<Classe> getAllClasse() {
        return db.getAllClasse();
    }

    @Override
    public boolean getAuthentifierProf(Prof  prof) throws RemoteException {
        return db.getAuthentifierProf(prof);
    }

    @Override
    public List<Classe> getAllClasseOfProf(int id_prof) throws RemoteException {
        return db.getAllClasseOfProf(id_prof);
    }
    @Override
    public List<Etudiant> getAllEtudiantInClasse(String name_classe){
        return db.getAllEtudiantInClasse(name_classe);
    }

    @Override
    public int  getIdEtudiantByName(String username) throws RemoteException {
        return db.getIdEtudiantByName(username);
    }
    public int  getIdClasseByName(String name_classe) throws RemoteException{
        return db.getIdClasseByName(name_classe);
    }

    @Override
    public boolean addEtudiantInClasse(int id_classe, int id_etudiant) throws RemoteException {
        return db.addEtudiantInClasse(id_classe,id_etudiant);
    }
    public boolean  SharMessageInClasse (int id_classe , String message) throws RemoteException{
        return db.SharMessageInClasse(id_classe,message);
    }
    @Override
    public boolean getAuthentifierEtudiant(Etudiant etudiant)throws  RemoteException{
        return db.getAuthentifierEtudiant(etudiant);
    }

    public List<Classe> getAllClasseOfEtudiant(String name_etudiant) throws RemoteException{
        return db.getAllClasseOfEtudiant(name_etudiant);
    }

    public List<Message> getMessageinsideClasse(String name_classe) throws RemoteException {
        return db.getMessageinsideClasse(name_classe);
    }


}

package Prof;

import ClasseMetier.Classe;
import Etudiant.Etudiant;
import DATABASE.Service.IDataBaseRemote;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Prof implements Serializable {
    private int id_prof;
    private String username;
    private String password;
    String url ="rmi://localhost/serverDatabase";
    private IDataBaseRemote iDataBaseRemote =(IDataBaseRemote) Naming.lookup(url);

    public Prof() throws MalformedURLException, NotBoundException, RemoteException {

    }



    public Prof(String username, String password) throws MalformedURLException, NotBoundException, RemoteException {
        this.username = username;
        this.password = password;
    }

    public Prof(int id_prof, String username) throws MalformedURLException, NotBoundException, RemoteException {
        this.id_prof = id_prof;
        this.username = username;
    }



    public int getId_prof() {
        return id_prof;
    }

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean getAuthentifierProf (Prof prof) throws RemoteException {
        return iDataBaseRemote.getAuthentifierProf(prof);
    }

    public int getIdProfByName(String name) throws RemoteException{
        return iDataBaseRemote.getIdProfByName(name);
    }
    public List<Classe> getAllClasseOfProf (int id_prof) throws RemoteException{
        System.out.println(id_prof);
        return iDataBaseRemote.getAllClasseOfProf(id_prof);
    }
    public List<Etudiant> getAllEtudiantInClasse(String name_classe,int  id_prof) throws RemoteException{
        System.out.println(id_prof);
        List<Classe> classes = getAllClasseOfProf(id_prof);
        for (Classe c : classes){
            if(c.getName().equals(name_classe))
                return iDataBaseRemote.getAllEtudiantInClasse(name_classe);
        }
        return null;
    }

    public int  getIdClasseByName(String name_classe,int id_prof)throws RemoteException{
        List<Classe> classes = getAllClasseOfProf(id_prof);
        for (Classe c : classes){
            if(c.getName().equals(name_classe))
                return iDataBaseRemote.getIdClasseByName(name_classe);
        }
       return -1;
    }

    public int  getIdEtudiantByName(String username) throws RemoteException {
        return iDataBaseRemote.getIdEtudiantByName(username);
    }

    public boolean addEtudiantInClasse(int id_classe,int id_etudiant) throws RemoteException{
                System.out.println("----------------");
                System.out.println(id_prof);
                System.out.println("--------------------");
                System.out.println(id_classe);
                System.out.println(id_etudiant);
                System.out.println(id_prof);
                System.out.println("------------------------");
                if(id_classe == -1  || id_etudiant == -1) {
                    return false;
                }else{
                    return iDataBaseRemote.addEtudiantInClasse(id_classe,id_etudiant);
                }
    }

    public boolean  ShareMessageInClasse (int id_classe , String Message) throws RemoteException {
        return iDataBaseRemote.SharMessageInClasse(id_classe,Message);
    }

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Prof prof = new Prof();
        System.out.println(prof.addEtudiantInClasse(11,19));
    }







}

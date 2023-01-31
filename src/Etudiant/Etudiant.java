package Etudiant;

import ClasseMetier.Classe;
import ClasseMetier.Message;
import DATABASE.Service.IDataBaseRemote;
import com.mysql.cj.util.DnsSrv;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Etudiant implements Serializable {
    private int id_etudiant;
    private String username;
    private String passwrod;
    String url ="rmi://localhost/serverDatabase";
    private IDataBaseRemote iDataBaseRemote =(IDataBaseRemote) Naming.lookup(url);

    public Etudiant(int id_etudiant, String username) throws MalformedURLException, NotBoundException, RemoteException {
        this.id_etudiant = id_etudiant;
        this.username = username;
    }

    public Etudiant(String username, String passwrod) throws MalformedURLException, NotBoundException, RemoteException {
        this.username=username;
        this.passwrod = passwrod;
    }

    public Etudiant() throws MalformedURLException, NotBoundException, RemoteException {

    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public boolean getAuthentifierEtudiant(Etudiant etudiant) throws RemoteException {
        return iDataBaseRemote.getAuthentifierEtudiant(etudiant);
    }

    public List<Classe> getAllClasseOfEtudiant(String name_etudiant) throws RemoteException{
        return  iDataBaseRemote.getAllClasseOfEtudiant(name_etudiant);
    }

    public List<Message> getMessageinsideClasse(String name_classe , String name_etudiant) throws RemoteException{
        List<Classe>  classeList= getAllClasseOfEtudiant(name_etudiant);
        for(Classe c: classeList){
            if(c.getName().equals(name_classe)){
                return iDataBaseRemote.getMessageinsideClasse(name_classe);
            }
        }
        return null;
    }
}

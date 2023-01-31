package Admin;

import ClasseMetier.Classe;
import Etudiant.Etudiant;
import Prof.Prof;
import DATABASE.Service.IDataBaseRemote;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Admin implements Serializable {

    private String usename;
    private String password;
    String url ="rmi://localhost/serverDatabase";
    private IDataBaseRemote iDataBaseRemote =(IDataBaseRemote) Naming.lookup(url);


    public Admin() throws MalformedURLException, NotBoundException, RemoteException {

    }
    public Admin(String usename, String password) throws MalformedURLException, NotBoundException, RemoteException {
        this.usename = usename;
        this.password = password;

    }



    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAuthentifier (Admin admin) throws RemoteException {
        return iDataBaseRemote.getAuthentifier(admin);
    }

    public boolean addProf(String username,String password,String password2) throws RemoteException, MalformedURLException, NotBoundException {
        if (password.equals("") || password2.equals("")) {
            System.out.println("please enter all information");
        } else if (!password.equals(password2)) {
            System.out.println("Confirm Password does not match");
        }else{
            Prof prof = new Prof(username, password);
            return iDataBaseRemote.addProf(prof);
        }
            return false;
    }

    public boolean addEtudiant (String username,String password,String password2) throws RemoteException, MalformedURLException, NotBoundException {
        if (username.equals("=") || password.equals("") || password2.equals("")) {
            System.out.println("please enter all information");
        } else if (!password.equals(password2)) {
            System.out.println("Confirm Password does not match");
        }else{
            Etudiant etudiant = new Etudiant(username, password);
            return iDataBaseRemote.addEtudiant(etudiant);
        }
        return false;
    }

    public int getIdProfByName (String username) throws RemoteException {
        return iDataBaseRemote.getIdProfByName(username);
    }

    public String getNameProfById(int id_prof) throws RemoteException{
        return iDataBaseRemote.getNameProfById(id_prof);
    }

    public boolean addClasse(int id_prof,String name_classe,String description) throws RemoteException {
        if(name_classe.equals("") || description.equals("")){
            System.out.println("please enter all information");
        }else{
            Classe classe = new Classe(id_prof,name_classe,description);
            return iDataBaseRemote.addClasse(classe);
        }
        return false;
    }

    public List<Prof> getAllProfs() throws RemoteException{
        return iDataBaseRemote.getAllProfs();
    }
    public List<Etudiant> getAllEtudiant()throws RemoteException {
        return  iDataBaseRemote.getAllEtudiant();
    }

    public List<Classe> getAllClasse() throws RemoteException {
        return iDataBaseRemote.getAllClasse();
    }
}

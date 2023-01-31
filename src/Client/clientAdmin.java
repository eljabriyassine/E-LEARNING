package Client;

import Admin.Admin;
import Admin.Service.IAdminRemote;
import ClasseMetier.Classe;
import Etudiant.Etudiant;
import Prof.Prof;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class clientAdmin {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url ="rmi://localhost/serverAdmin";
        IAdminRemote iAdminRemote = (IAdminRemote) Naming.lookup(url);

        Admin admin;
        String username,password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome admin !!!");
        System.out.println("--------------------------------");
        do{
            System.out.print("enter username : ");
            username = scanner.nextLine();
            System.out.print("enter password : ");
            password = scanner.nextLine();
            if(username.equals("") || password.equals("")){
                System.out.println("username and password are required");
            }else{
                admin = new Admin(username,password);
                if(!iAdminRemote.getAuthentifier(admin)){
                    System.out.println("username or password is incorrect try again ...");
                }else{
                    System.out.println("you are connectedd as : " + admin.getUsename());
                    break;
                }
            }
        }while(true);

        do {
            System.out.println("::::::::::::::: table borad ::::::::::::::::::::");
        	System.out.println("1 -  Ajouter professeur");
        	System.out.println("2 -  ajouter etudiant");
        	System.out.println("3 -  ajouter classe");
        	System.out.println("4 -  liste professeur");
        	System.out.println("5 -  liste etudiant");
        	System.out.println("6 -  liste Classe");
            System.out.print("choose from the list : ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    while (true){
                        System.out.println("------------");
                        System.out.print("enter name of prof : ");
                        username = scanner.nextLine();
                        System.out.print("enter password of prof : ");
                        password = scanner.nextLine();
                        System.out.print("re-enter the password : ");
                        String password2 = scanner.nextLine();
                        if(iAdminRemote.addProf(username,password,password2)){
                            System.out.println(username + " added succefully as a prof");
                            break;
                        }
                    }
                    break;
                case "2":
                    while (true) {
                        System.out.println("------------");
                        System.out.print("enter name of etudiant : ");
                        username = scanner.nextLine();
                        System.out.print("enter password of studentt : ");
                        password = scanner.nextLine();
                        System.out.print("re-enter the password : ");
                        String password2 = scanner.nextLine();
                        if (iAdminRemote.addEtudiant(username, password, password2)) {
                            System.out.println(username + " added succefully as an student");
                            break;
                        }
                    }
                    break;
                case "3":
                    while (true){
                        System.out.println("--------------");
                        System.out.print("enter the name of prof_responsalbe : ");
                        String prof_resp = scanner.nextLine();
                        int prof_id = iAdminRemote.getIdProfByName(prof_resp);
                        //test if the prof is exisit
                        if(prof_id != -1){
                            System.out.print("name of the classe : ");
                            String name_classe = scanner.nextLine();
                            System.out.print("enter the description : ");
                            String description = scanner.nextLine();
                            if(iAdminRemote.addClasse(prof_id,name_classe,description)) {
                                System.out.println("the classe " + name_classe + "added succefully ...");
                                break;
                            }
                        }else {
                            System.out.println("the name doesn't exist");
                        }
                    }
                case "4":
                    List<Prof> profs= iAdminRemote.getAllProfs();

                    if(profs.size()!=0){
                        System.out.println("id\t| username " );
                        for (Prof p : profs){
                            System.out.println("-----------------");
                            System.out.println(p.getId_prof() + " \t| " + p.getUsername());
                        }
                    }else{
                        System.out.println("this is not prof to show add a new one");
                    }
                    break;
                case "5":
                    List<Etudiant> etudiants= iAdminRemote.getAllEtudiant();
                    if(etudiants.size()!=0){
                        System.out.println("id\t| username " );
                        for (Etudiant e : etudiants){
                            System.out.println("-----------------");
                            System.out.println(e.getId_etudiant() + " \t| " + e.getUsername());
                        }
                    }else{
                        System.out.println("this is not etudiant to show add new one ...");
                    }
                    break;
                case "6":
                    List<Classe> classes = iAdminRemote.getAllClasse();
                    for (Classe c : classes){
                        String nom_prof = iAdminRemote.getNameProfById(c.getId_responsable());
                        System.out.println(nom_prof + " | "+ c.getName() + " | " + c.getDescription());
                    }
                    break;
                default:
                    System.out.println("nothing to do ");
            }
        }while (true);
    }
}

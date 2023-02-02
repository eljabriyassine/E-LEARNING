package Client;

import ClasseMetier.Classe;
import Etudiant.Etudiant;
import Prof.Prof;
import Prof.Service.IProfRemote;
import Prof.Service.ITableRemote;
import Prof.Service.ITableRemoteImp;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class clientProf {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url ="rmi://localhost/serverProf";
        IProfRemote iProfRemote = (IProfRemote) Naming.lookup(url);
        url = "rmi://localhost/serverTable";
        ITableRemote iTableRemote = (ITableRemote) Naming.lookup(url);
        Prof prof;
        String username,password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome Prof !!!");
        System.out.println("--------------------------------");

        do{
            System.out.print("enter username : ");
            username = scanner.nextLine();
            System.out.print("enter password : ");
            password = scanner.nextLine();
            if(username.equals("") || password.equals("")){
                System.out.println("username and password are required");
            }else{
                prof = new Prof(username,password);
                if(!iProfRemote.getAuthentifierProf(prof)){
                    System.out.println("username or password is incorrect try again ...");
                }else{
                    System.out.println("you are connectedd as : " + prof.getUsername());
                    break;
                }
            }
        }while(true);

        do {
            int id_prof = iProfRemote.getIdProfByName(prof.getUsername());//for select the classe of specific prof
            System.out.println("::::::::::::::: table bord ::::::::::::::::::::");
            System.out.println("1 - Liste Classe");
            System.out.println("2 - Liste Etudinat in classe");
            System.out.println("3 - add etudiant in classe");
            System.out.println("4 - share message in classe");
            System.out.println("5 - share table blanc");
            System.out.print("choose from the list : ");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    List<Classe> classes= iProfRemote.getAllClasseOfProf(id_prof);
                    int i=1;
                    if(classes.size()!=0){
                        for (Classe c : classes){
                            System.out.println("------------infomration of claase "+ i++ +"---------------");
                            System.out.println("name : " + c.getName());
                            System.out.println("description  : " + c.getDescription());
                        }
                    }else{
                        System.out.println(" no classe found try to create one ...");
                    }
                    break;
                case "2":
                    System.out.print("enter the name of classe : ");
                    String name_classe =scanner.nextLine();
                    //select the claase where prof id responsable
                    List<Etudiant> etudiants = iProfRemote.getAllEtudiantInClasse(name_classe,id_prof);
                   if(etudiants!=null){
                       System.out.println("list of etudiant");
                       System.out.println("-----------------------------");
                       for(Etudiant e : etudiants){
                           System.out.println("nom eutidant : " + e.getUsername());
                       }
                       System.out.println("-----------------------------");
                   }else{
                       System.out.println("we can't find this class ...");
                   }
                   break;
                case "3":
                    while (true){
                        System.out.print("enter the name of classe : ");
                        name_classe = scanner.nextLine();
                        System.out.print("enter the name of etudiant : ");
                        String name_etudiant = scanner.nextLine();
                        int id_classe =iProfRemote.getIdClasseByName(name_classe,id_prof);
                        int id_etudiant = iProfRemote.getIdEtudiantByName(name_etudiant);
                        System.out.println("id_classe : " + id_classe);
                        System.out.println("id_etudiant : " + id_etudiant);
                        if(id_classe== -1 ){
                            System.out.println("the classe doesn't exist");
                        } else if ( id_etudiant== -1) {
                            System.out.println("enter valid name of etudiant");
                        }else{
                            System.out.println(name_etudiant + " added succefully in classe : " + name_classe);
                            iProfRemote.addEtudiantInClasse(id_classe,id_etudiant);
                            break;
                        }
                    }
                    break;
                case "4":
                   while (true){
                       System.out.println("choose classe");
                       name_classe = scanner.nextLine();
                       int id_classe = iProfRemote.getIdClasseByName(name_classe,id_prof);
                       if( id_classe!= -1){
                           System.out.print("enter the messagee ");
                           String message = scanner.nextLine();
                           if(!message.equals("")){
                               System.out.print("message added succefully !!!");
                            iProfRemote.SharMessageInClasse(id_classe,message);
                            break;
                           }else{
                               System.out.println("enter a message ");
                           }
                       }else{
                           System.out.println("classe invalid");
                       }
                   }
                    break;
                case "5":
                    boolean isUsef = false;
                        iTableRemote.DrawInTable();
                    break;
                default:
                    System.out.println("chose from the list");
            }
        }while (true);
    }
}

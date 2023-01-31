package Client;


import Admin.Admin;
import Admin.Service.IAdminRemote;
import ClasseMetier.Classe;
import ClasseMetier.Message;
import Etudiant.Etudiant;
import Etudiant.Service.IEtudiantRemote;
import Etudiant.Service.IEtudiantRemoteImp;
import Etudiant.Service.ITableEtudiantRemote;
import Prof.Service.IProfRemote;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class clientEtudiant {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://localhost/serverEtudiant";
        IEtudiantRemote iEtudiantRemote = (IEtudiantRemote) Naming.lookup(url);
        url ="rmi://localhost/serverAdmin";
        IAdminRemote iAdminRemote = (IAdminRemote) Naming.lookup(url);
        url ="rmi://localhost/serverTableEtudiant";
        ITableEtudiantRemote iTableEtudiantRemote = (ITableEtudiantRemote) Naming.lookup(url);

        Etudiant etudiant;
        String username,password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome Etudiant !!!");
        System.out.println("--------------------------------");

        do{
            System.out.print("enter username : ");
            username = scanner.nextLine();
            System.out.print("enter password : ");
            password = scanner.nextLine();
            if(username.equals("") || password.equals("")){
                System.out.println("username and password are required");
            }else{
                etudiant = new Etudiant(username,password);
                if(!iEtudiantRemote.getAuthentifierEtudiant(etudiant)){
                    System.out.println("username or password is incorrect try again ...");
                }else{
                    System.out.println("you are connectedd as : " + etudiant.getUsername());
                    break;
                }
            }
        }while(true);

        do {
            System.out.println("--------------tableau bord---------------------");
            System.out.println("1 - liste classe ");
            System.out.println("2 - inscrit in classe");
            System.out.println("3 - rejoindre classe");
            System.out.println("4 - rejoindre paint");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    List<Classe> classeList = iEtudiantRemote.getAllClasseOfEtudiant(etudiant.getUsername());
                    if(classeList != null){
                        int i=1;
                        System.out.println("information of classes ");
                        for (Classe c : classeList){
                            String nom_prof = iAdminRemote.getNameProfById(c.getId_responsable());
                            System.out.println("----------------------------------");
                            System.out.println("classe " + i++);
                            System.out.println("prof responsable :" + nom_prof );
                            System.out.println("name of classe : "  + c.getName());
                            System.out.println("description : "  + c.getDescription());
                        }
                    }else{
                        System.out.println("inscrit in classe");
                    }
                    break;
                case "2":
                    System.out.println("hello from 2");
                    break;
                case "3":
                    System.out.println("choose classe : ");
                    String name_classe = scanner.nextLine();
                    List<Message> messageList = iEtudiantRemote.getMessageinsideClasse(name_classe, etudiant.getUsername());
                    if(messageList != null){
                        for (Message m : messageList){
                            System.out.println(m.getDate() +  ":" + m.getMessage());
                        }
                    }else{
                        System.out.println("somethign wrong ...");
                    }
                case "4":

                default:

                    break;
            }
        }while(true);
    }
}

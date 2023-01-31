package DATABASE;

import Admin.Admin;
import ClasseMetier.Classe;
import ClasseMetier.Message;
import Etudiant.Etudiant;
import Prof.Prof;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase implements Serializable {
    static final String DB_URL = "jdbc:mysql://localhost/e-learning?serverTimezone=UTC";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    static Connection connection;
    static Statement statement;
    static PreparedStatement preparedStatement;
    static ResultSet resultSet;

    public boolean getAuthentifier(Admin admin) {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from admin where username =? and password =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,admin.getUsename());
            preparedStatement.setString(2,admin.getPassword());
            resultSet = preparedStatement.executeQuery();
            while(!resultSet.next()){
                return false;
            }
            }catch (SQLException e){
                e.printStackTrace();
            }
        return true;
    }

    public boolean addProf(Prof prof){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO prof (username, password) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prof.getUsername());
            preparedStatement.setString(2, prof.getPassword());
            if( preparedStatement.executeUpdate()>0){
                return true;
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
    }

    public List<Prof> getAllProfs(){
        List<Prof> profList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * from Prof";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Prof prof = new Prof(resultSet.getInt("id_prof"),resultSet.getString("username"));
                profList.add(prof);
                }
            } catch (Exception e) {
            e.printStackTrace();
            }
        return profList;
    }

    public boolean addEtudiant(Etudiant etudiant){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO etudiant (username, password) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, etudiant.getUsername());
            preparedStatement.setString(2, etudiant.getPasswrod());
            if( preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Etudiant> getAllEtudiant(){
        List<Etudiant> etudiantList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * from etudiant";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant(resultSet.getInt("id_etudiant"),resultSet.getString("username"));
                etudiantList.add(etudiant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etudiantList;
    }



    public List<Classe> getAllClasse(){
        List<Classe> listClasse = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * from classe";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Classe classe = new Classe(resultSet.getInt("id_classe"),resultSet.getInt("id_responsable"),resultSet.getString("name"),resultSet.getString("description"));
                listClasse.add(classe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClasse;
    }
    public int getIdProfByName(String usernmae){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT id_prof from prof where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usernmae);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt("id_prof");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public String getNameProfById(int id_prof){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT username from prof where id_prof = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_prof);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getString("username");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public boolean addClasse(Classe classe){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO classe (id_responsable, name,description) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , classe.getId_responsable());
            preparedStatement.setString(2, classe.getName());
            preparedStatement.setString(3, classe.getDescription());
            if( preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    //////////////////////////////methode of prof/////////////////////////
    public boolean getAuthentifierProf(Prof prof) {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from prof where username =? and password =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,prof.getUsername());
            preparedStatement.setString(2,prof.getPassword());
            resultSet = preparedStatement.executeQuery();
            while(!resultSet.next()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    //
    public List<Classe> getAllClasseOfProf(int id_responsable){
        List<Classe> listClasse = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * from classe where id_responsable =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id_responsable);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Classe classe = new Classe(resultSet.getInt("id_classe"),resultSet.getInt("id_responsable "),resultSet.getString("name"),resultSet.getString("description"));
                listClasse.add(classe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listClasse;
    }



    public List<Etudiant> getAllEtudiantInClasse(String name_classe){
        List<Etudiant> etudiantList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT e.* from classe c,liste_etudiant l,etudiant e where c.id_classe=l.id_classe and l.id_etudiant=e.id_etudiant And c.name=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name_classe);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant(resultSet.getInt("id_etudiant"),resultSet.getString("username"));
                etudiantList.add(etudiant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etudiantList;
    }

    public int  getIdEtudiantByName(String username){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT id_etudiant from etudiant where username = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt("id_etudiant");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    public int  getIdClasseByName(String name_classe){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT id_classe from classe where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name_classe);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getInt("id_classe");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }


    public boolean addEtudiantInClasse(int id_classe,int id_etudiant){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO liste_etudiant (id_classe ,id_etudiant) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , id_classe);
            preparedStatement.setInt(2, id_etudiant);
            if( preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean  SharMessageInClasse (int id_classe , String Message){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into message  (id_classe,message)  values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_classe);
            preparedStatement.setString(2, Message);
            if( preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    ///////////////////////////////////methode etudiant////////////////////////////////
    public boolean getAuthentifierEtudiant(Etudiant etudiant) {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from etudiant where username =? and password =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,etudiant.getUsername());
            preparedStatement.setString(2,etudiant.getPasswrod());
            resultSet = preparedStatement.executeQuery();
            while(!resultSet.next()){
                return false;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }



    public List<Classe> getAllClasseOfEtudiant(String name_etudiant){
        List<Classe> classeList = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT c.* from classe c,liste_etudiant l,etudiant e where c.id_classe=l.id_classe and l.id_etudiant=e.id_etudiant And e.username=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name_etudiant);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Classe classe = new Classe(resultSet.getInt("id_classe"),resultSet.getInt("id_responsable"),resultSet.getString("name"),resultSet.getString("description"));
                classeList.add(classe);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classeList;
    }

    public List<Message> getMessageinsideClasse(String name_classe){
        try {
            List<Message> messageList = new ArrayList<>();
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * from classe c, message m where c.id_classe=m.id_classe and c.name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name_classe);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Message message = new Message(resultSet.getString("message"),resultSet.getString("date"));
                messageList.add(message);
                return messageList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        DataBase dataBase = new DataBase();
//        int id  = dataBase.getIdProfByName("yassine");
        List<Message> messageList = new ArrayList<>();
        messageList = dataBase.getMessageinsideClasse("javam");

        if(messageList!= null){
            for (Message c : messageList){
                System.out.println(c.getMessage());
                System.out.println(c.getDate());
            }
        }else {
            System.out.println("something wrong...");
        }
//        dataBase.SharMessageInClasse(1,"this is course of java");
    }
}

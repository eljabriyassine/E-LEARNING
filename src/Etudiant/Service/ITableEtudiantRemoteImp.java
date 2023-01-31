package Etudiant.Service;

import Etudiant.TableEtudiant;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ITableEtudiantRemoteImp extends UnicastRemoteObject implements ITableEtudiantRemote{
    private TableEtudiant tableEtudiant = new TableEtudiant();

    public ITableEtudiantRemoteImp() throws RemoteException {
    }

    public void Frame(){
        tableEtudiant.Frame();
    }


    @Override
    public void ShowTable(int i, int j, int k, int l) throws RemoteException {
        tableEtudiant.draw(i,j,k,l);
    }
}

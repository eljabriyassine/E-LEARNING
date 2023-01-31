package Etudiant.Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.PrimitiveIterator;

public interface ITableEtudiantRemote extends Remote {

    public void Frame() throws RemoteException;
    public void ShowTable(int i, int j ,int k , int l ) throws RemoteException;
}

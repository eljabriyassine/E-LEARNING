package Prof.Service;

import java.awt.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITableRemote extends Remote {
    public void DrawInTable() throws RemoteException;
}

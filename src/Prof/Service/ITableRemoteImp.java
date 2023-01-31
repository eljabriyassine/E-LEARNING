package Prof.Service;

import Etudiant.Service.ITableEtudiantRemote;
import Prof.Table;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ITableRemoteImp extends UnicastRemoteObject implements ITableRemote {
    String url = "rmi://localhost/serverTableEtudiant";
    ITableEtudiantRemote itb = (ITableEtudiantRemote) Naming.lookup(url);
    Table table = new Table();
    public  int currentX, currentY, oldX, oldY;
    public ITableRemoteImp() throws RemoteException, MalformedURLException, NotBoundException {
    }

    @Override
    public void DrawInTable() throws RemoteException {
        JFrame frame = new JFrame("Prof Paint");
        Container content = frame.getContentPane();
        content.add(table, BorderLayout.CENTER);
        frame.setSize(600, 600);
        frame.setVisible(true);

        Table panel = new Table();
        frame.add(panel);


        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                // save coord x,y when mouse is pressed
                Point p = e.getPoint();
                oldX = (int) p.getX();
                oldY = (int) p.getY();
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                currentX = (int) p.getX();
                currentY = (int) p.getY();
                table.draw(oldX,oldY,currentX,currentY);
                try {
                    itb.ShowTable(oldX,oldY,currentX,currentY);
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println(oldX);
                oldX = currentX;
                oldY = currentY;
            }
        });
    }


}

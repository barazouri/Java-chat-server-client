package com.barazouri.chat;

import com.barazouri.chat.GUI;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;

public class Demo {
    public static String serverName = "127.0.0.1";
    public static int serverPortNumber = 1300;
    public static void main(String args[]){
        Socket socket = null;
        try{
            socket = new Socket(serverName,serverPortNumber);
        }catch (IOException e){
            e.printStackTrace();
        }
        ConnectionProxy prox = new ConnectionProxy(socket);
        GUI g = new GUI(prox);
        prox.setUser(g);
        g.showGUI();

    }
}

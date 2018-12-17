package com.barazouri.chat;

import java.io.*;
import java.net.Socket;

public class ConnectionProxy extends Thread implements StringConsumer, StringProducer {
    GUI user = null;
    InputStream is = null;
    DataInputStream dis = null;
    OutputStream os = null;
    DataOutputStream dos = null;
ConnectionProxy(Socket socket){
    try {
        is = socket.getInputStream();
        dis = new DataInputStream(is);
        os = socket.getOutputStream();
        dos = new DataOutputStream(os);
        this.start();

    }catch (IOException e){
        e.printStackTrace();
    }

}

    public void setUser(GUI user) {
        this.user = user;
    }

    @Override
    public void consume(String str) {
    try {
        dos.writeUTF(str);
    }catch (IOException e){
        e.printStackTrace();
    }
    }

    @Override
    public void addConsumer(StringConsumer sc) {

    }

    @Override
    public void removeConsumer(StringConsumer sc) {

    }
    @Override
    public void run(){
        try {
    while(true){
        String userInput;
        userInput = dis.readUTF();
        if(user != null){
            user.consume(userInput);
        }

    }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

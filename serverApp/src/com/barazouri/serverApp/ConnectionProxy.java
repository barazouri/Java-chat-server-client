package com.barazouri.serverApp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ConnectionProxy extends Thread implements StringConsumer, StringProducer {
    InputStream is = null;
    DataInputStream dis = null;
    OutputStream os = null;
    DataOutputStream dos = null;
    String ip = null;
    clientDescriptor c;
    ConnectionProxy(Socket socket){

        try {
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            ip = socket.getRemoteSocketAddress().toString();

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @Override
    public void consume(String str) {
        try {
            dos.writeUTF(str);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addConsumer(StringConsumer sc) {
        System.out.println("hello" + sc);
         c = (clientDescriptor) sc;
    }

    @Override
    public void removeConsumer(StringConsumer sc) {

    }
    @Override
    public void run(){
        String userInput;
        try {
            while(true) {
                String s = dis.readUTF();
                System.out.println(ip + ": " + s);
                c.consume(ip + ": " + s + "\n");

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

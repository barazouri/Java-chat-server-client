package com.barazouri.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements StringProducer,StringConsumer{
    JFrame frame;
    JTextArea toSend;
    JTextArea recive;
    JButton send;
    ConnectionProxy con;
    GUI(ConnectionProxy con){
        this.con = con;
        frame = new JFrame("chat GUI");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,300);
        frame.setVisible(true);
        toSend = new JTextArea();
        recive = new JTextArea();
        recive.setBackground(Color.green);
        send = new JButton("Send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con.consume((toSend.getText()));
                toSend.setText("");
//                System.out.print("im in\n");
            }
        });
        frame.add(send,BorderLayout.SOUTH);
        frame.add(toSend,BorderLayout.NORTH);
        frame.add(recive);
    }
    @Override
    public void consume(String str) {
        recive.append(str);
    }

    @Override
    public void addConsumer(StringConsumer sc) {
        con.addConsumer(sc);
    }

    @Override
    public void removeConsumer(StringConsumer sc) {

    }

    public void showGUI(){
        frame.setVisible(true);
    }
    public void hideGUI(){
        frame.setVisible(false);
    }
    public String getTextToSend(){
        return toSend.getText();
    }
}

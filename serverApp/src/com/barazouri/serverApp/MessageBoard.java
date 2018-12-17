package com.barazouri.serverApp;

import java.util.ArrayList;
import java.util.List;

public class MessageBoard implements StringProducer,StringConsumer{
    List<ConnectionProxy> list;
    MessageBoard(){
        list = new ArrayList();

    }
    @Override
    public void consume(String str) {
        for(int i=0 ; i<list.size();i++){
            list.get(i).consume(str);
        }
    }

    @Override
    public void addConsumer(StringConsumer sc) {
        ConnectionProxy cp = (ConnectionProxy)sc;
        list.add(cp);
    }

    @Override
    public void removeConsumer(StringConsumer sc) {

    }

}

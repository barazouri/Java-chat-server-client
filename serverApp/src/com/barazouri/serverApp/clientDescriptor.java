package com.barazouri.serverApp;

import java.util.List;

public class clientDescriptor implements StringConsumer,StringProducer {
    MessageBoard m;
    @Override
    public void consume(String str) {
        m.consume(str);
    }

    @Override
    public void addConsumer(StringConsumer sc) {
        m = (MessageBoard) sc;
    }

    @Override
    public void removeConsumer(StringConsumer sc) {

    }

}

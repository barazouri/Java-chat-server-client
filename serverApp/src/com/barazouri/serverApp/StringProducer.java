package com.barazouri.serverApp;

public interface StringProducer {
    public void addConsumer(StringConsumer sc);
    public void  removeConsumer(StringConsumer sc);
}

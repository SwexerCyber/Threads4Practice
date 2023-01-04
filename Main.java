package com.company;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();

        new Thread(new GetThread(exchanger)).start();
        new Thread(new SetThread(exchanger)).start();
    }
    // коммит
}

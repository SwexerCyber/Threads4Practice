package com.company;
import java.util.concurrent.Exchanger;

public class GetThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public GetThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "Вызов конструктора GetThread";
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
        }catch (InterruptedException e) {
            System.out.println("Сообщение не доставлено :(");
        }

        System.out.println("GetThread получил " + message);
    }
}

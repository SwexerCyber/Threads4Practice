package com.company;
import java.util.concurrent.Exchanger;

public class SetThread implements Runnable {
    Exchanger<String> exchanger;
    private String message;

    public SetThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "Вызов конструктора SetThread";
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
        }catch (InterruptedException e) {
            System.out.println("Сообщение не доставлено :(");
        }

        System.out.println("SetThread получил " + message);
    }
}
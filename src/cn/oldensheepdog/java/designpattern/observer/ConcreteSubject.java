package cn.oldensheepdog.java.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    // 订阅者列表
    private List<Observer> list = new ArrayList<>();
    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : list){
            observer.update(message);
        }
    }
}

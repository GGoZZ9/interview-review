package cn.oldensheepdog.java.fundamental.multithreading.javatpoint.synchronization;

public class ThreadCommunication {
    public static void main(String[] args){
        final Customer c=new Customer();

        new Thread(() -> c.withdraw(15000)).start();
        new Thread(() -> c.deposit(10000)).start();

    }
}

class Customer{
    int amount=10000;

    synchronized void withdraw(int amount){
        System.out.println("going to withdraw...");

        if(this.amount<amount){
            System.out.println("Less balance; waiting for deposit...");
            try{wait();}catch(Exception e){}
        }
        this.amount-=amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount){
        System.out.println("going to deposit...");
        this.amount+=amount;
        System.out.println("deposit completed... ");
        notify();
    }
}
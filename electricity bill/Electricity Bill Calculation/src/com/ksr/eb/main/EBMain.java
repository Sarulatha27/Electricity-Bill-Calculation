package com.ksr.eb.main;
import java.util.Scanner;
import com.ksr.eb.service.ConnectionService;
public class EBMain {

	public static void main(String[] args) {
		int currentReading;
		int previousReading;
		String type;
        Scanner sc =new Scanner(System.in);
        currentReading=sc.nextInt();
        previousReading=sc.nextInt();
        type=sc.next();
        ConnectionService cs=new ConnectionService();
        String ss=cs.generateBill(currentReading,previousReading,type);
        System.out.println(ss);
	}

}

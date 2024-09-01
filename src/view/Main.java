package view;

import controller.ThreadIP;

public class Main {

	public static void main(String[] args) {
		
		String cmd = "ping -4 -c 10 www.uol.com.br\n";
		String cmd2 = "ping -4 -c 10 www.terra.com.br\n";
		String cmd3 = "ping -4 -c 10 www.google.com.br\n\n";
		
		Thread t = new ThreadIP(cmd, "UOL");
		Thread t2 = new ThreadIP(cmd2, "TERRA");
		Thread t3 = new ThreadIP(cmd3, "GOOGLE");
		
		t.start();
		t2.start();
		t3.start();
	}

}

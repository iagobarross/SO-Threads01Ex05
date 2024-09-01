package controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ThreadIP extends Thread {
	
	private String cmd;
	private String dominio;
	
	public ThreadIP(String cmd, String dominio) {
		this.cmd = cmd;
		this.dominio = dominio;
	}
	
	public void run() {
		String[] cmdVetor = cmd.split(" ");
		try {
			Process p = Runtime.getRuntime().exec(cmdVetor);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				if(linha.contains("time")) {
					String [] ip = linha.split("=");
					
					System.out.println("IP " + dominio + ": " + ip[3] + "\n");
				}
				linha = buffer.readLine();
			}
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

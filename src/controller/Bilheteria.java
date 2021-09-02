package controller;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Bilheteria extends Thread {

	private int idPessoa;
	private Semaphore semaforo;
	private static int ingressos = 100;
	
	public Bilheteria(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	public void run() {
		login();
	}
	
	private void login() {
		double tempo = (Math.random()*2);
		
		try {
			sleep((long) tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(tempo > 1.0) {
			System.out.println("#"+ idPessoa + " recebeu uma mensagem de timeout.");
		}else {
			System.out.println("#"+ idPessoa + " concluiu o login");
			processoCompra();
		}
		
	}
	
	private void processoCompra() {
		double tempo = (double)(Math.random()*3);
		Random numAleatorio = new Random();
		int ingressosPedidos = numAleatorio.nextInt(5); 
		
		if(ingressosPedidos == 0) {
			while(ingressosPedidos == 0) {
				ingressosPedidos = numAleatorio.nextInt(5); 
			}
		}
		
		try {
			sleep((long)tempo);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(tempo > 2.5) {
			System.out.println("#" + idPessoa + " estourou o tempo de compra");
		}else {
			System.out.println("#" + idPessoa + " pediu: " + ingressosPedidos + " ingressos.");
			validacaoCompra(idPessoa, ingressosPedidos);
		}
}
	private void validacaoCompra(int idPessoa, int ingressosPedidos) {
		
		int ingressosUsados = ingressosPedidos;
		
		if(ingressosPedidos <= ingressos) {
			System.out.println("#" + idPessoa + " adquiriu: " + ingressosPedidos);
			ingressos -= ingressosUsados;
		}else {
			System.out.println("#" + idPessoa + " recebeu uma mensagem de indisponibilidade de ingressos.");
			ingressos = ingressos;
		}
		
	}

}









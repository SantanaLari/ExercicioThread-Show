package view;

import java.util.concurrent.Semaphore;

import controller.Bilheteria;

public class Main {

	public static void main(String[] args) {
		
		int acessos = 300;
		Semaphore semaforo = new Semaphore(acessos);
		
		for(int idPessoa = 0; idPessoa < 300; idPessoa++) {
			Thread tShow = new Bilheteria(idPessoa, semaforo);
			tShow.start();
		}

	}

}

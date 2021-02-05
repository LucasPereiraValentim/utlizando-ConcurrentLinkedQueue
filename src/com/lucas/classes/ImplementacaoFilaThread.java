package com.lucas.classes;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		fila.add(objetoFilaThread);
	}
	
	

	@Override
	public void run() {

		while (true) {

			synchronized (fila) { // BLOQUEAR O ACESSO DE OUTROS PROCESSOS A ESSA THREAD.

				Iterator interacao = fila.iterator();

				while (interacao.hasNext()) {

					ObjetoFilaThread processar = (ObjetoFilaThread) interacao.next();
					
					
					System.out.println("----------------------------------------");
					System.out.println("Nome adicionado: " + processar.getNome());
					System.out.println("Email adicionado: " + processar.getEmail());
					
					
					
					interacao.remove();

					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}

		}

	}
}

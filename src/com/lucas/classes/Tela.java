package com.lucas.classes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.lucas.classes.*;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JDialog{
	private JPanel jPanel = new JPanel(new GridBagLayout());

	private JLabel timeThread1 = new JLabel("Nome");

	private JTextField mostraTempo = new JTextField();

	private JLabel timeThread2 = new JLabel("E-mail");

	private JTextField mostraTempoThread2 = new JTextField();

	private JButton jButton = new JButton("Adicionar na fila");

	private JButton jButton2 = new JButton("Fechar");
	
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	
	
	public Tela() {

		setTitle("Time com Threads");
		setSize(new Dimension(300, 300));
		setLocationRelativeTo(null);
		setResizable(true);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);

		timeThread1.setPreferredSize(new Dimension(200, 25));
		jPanel.add(timeThread1, gridBagConstraints);

		mostraTempo.setPreferredSize(new Dimension(200, 25));

		gridBagConstraints.gridy++;
		jPanel.add(mostraTempo, gridBagConstraints);

		// ***********************************************************

		timeThread2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(timeThread2, gridBagConstraints);

		mostraTempoThread2.setPreferredSize(new Dimension(200, 25));

		gridBagConstraints.gridy++;
		jPanel.add(mostraTempoThread2, gridBagConstraints);

		// ******************************

		gridBagConstraints.gridwidth = 1;

		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(jButton, gridBagConstraints);

		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(jButton2, gridBagConstraints);

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (int qtd = 0; qtd < 100; qtd++) { //Simulando 100 envios em massa.
				
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				filaThread.setNome(mostraTempo.getText());
				filaThread.setEmail(mostraTempoThread2.getText() + "\n" + qtd);
				
				fila.add(filaThread);
				
				}
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Fecha o Jdialog, e a thread continua em processo paralelo
				dispose();
			}
		});

		fila.start();

		add(jPanel, BorderLayout.WEST);

		setVisible(true); // Tornar a tela vísivel ao usuário.
	}
}

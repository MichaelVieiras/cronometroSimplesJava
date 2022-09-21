package br.com.senai.cronometro;

import java.awt.*; //chama os componentes - gerenciadores de layout
import java.awt.event.*; //acesso aos eventos (ouvintes)
import javax.swing.*; //componentes visuais
import java.util.*; //pacote de utilidades | Calendar - vai ser usada para obter a hora atual do sistema

public class Cronometro implements ActionListener {

	JLabel jlab = new JLabel("Prencione Start para iniciar o tempo");// jlab instaciado
	long start; // contem a hora incial em milessegundos

	// Criando os dois botões
	JButton btnStart = new JButton("Start");
	JButton btnStop = new JButton("Stop");

	public Cronometro() {

		// Criar um contêiner JFrame - Um componente que pode receber outro componente
		JFrame jfrm = new JFrame("SENAI - ESCOLA JAVA");

		// Adicionar os ouvintes de ação
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);

		// Especificar FlowLayout como gerenciador de layout
		jfrm.setLayout(new FlowLayout());

		// Adicionar os componentes dentro do container
		jfrm.add(btnStart);
		jfrm.add(btnStop);
		jfrm.add(jlab);

		// Fornecer um tamanho inicial para o quadro(Frame)
		jfrm.setSize(300, 90);
		
		//Deixa o Fomulario (JFrame - jfrm) visivel
		jfrm.setVisible(true);
		
		// Encerrar quando o usuario fechar o aplicativo
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Item A - Obter a hora atual do sistema
		Calendar cal = Calendar.getInstance();
		
		//Item B - Armazenar a hora inicial
		if(e.getActionCommand().equals("Start")) {
			start = cal.getTimeInMillis();
			jlab.setText("Cronometro está em execurção!");
		}else {
			//Item C - Calcular o tempo decorrido
			jlab.setText("O tempo decorrido foi: " + (double)(cal.getTimeInMillis() - start) / 1000); 
		}

	}
}

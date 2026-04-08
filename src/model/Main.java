package model;

import javax.swing.SwingUtilities;

import controller.LoginController;
import controller.Navegador;
import view.Janela;
import view.TelaLogin;

public class Main {

	    public static void main(String[] args) {

	        SwingUtilities.invokeLater(() -> {

	            Janela frame = new Janela();

	            
	            Navegador.setFrame(frame);

	            TelaLogin telaLogin = new TelaLogin();
	            new LoginController(telaLogin, frame);

	            Navegador.trocarTela(telaLogin);

	            frame.setVisible(true);
	        });
	    }
	}

package model;

import javax.swing.SwingUtilities;

import controller.LoginController;
import controller.Navegador;
import view.Jframe;
import view.TelaLogin;

public class Main {

	    public static void main(String[] args) {

	        SwingUtilities.invokeLater(() -> {

	            Jframe frame = new Jframe();

	            
	            Navegador.setFrame(frame);

	            TelaLogin telaLogin = new TelaLogin();
	            new LoginController(telaLogin, frame);

	            Navegador.trocarTela(telaLogin);

	            frame.setVisible(true);
	        });
	    }
	}

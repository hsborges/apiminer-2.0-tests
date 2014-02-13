package br.unb.cbsoft2013.web;
import br.unb.cbsoft2013.Credencial;
import br.unb.cbsoft2013.Comunicador;


public class MainWeb {
	
	private Credencial classeA = Credencial.obterInstancia("usuario","senha");
	
	public void metodoG() {
		System.out.println(classeA.informacoesDaCredencial());
	}
	
	public void metodoH() {
		classeA.reAutenticar();
		classeA.renovarComunicador();
	}
	
	public void metodoI(Object o) {
		Comunicador instanceOfB = classeA.obterComunicador();
		instanceOfB.conectar();
		instanceOfB.enviar(o);
		instanceOfB.desconectar();
	}

}

package Comandos;

import Principal.Engine;

/**
 * 
 * La clase Quit hereda de Command implementando
 *  todos los métodos abstractos
 *
 */
public class Quit implements Command {

	@Override
	public void execute(Engine engine) {
		engine.stopEngine();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return " QUIT: Finaliza la ejecucion de la aplicacion" + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "QUIT";
	}

}

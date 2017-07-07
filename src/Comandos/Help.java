package Comandos;

import Principal.Engine;

/**
 * 
 * La clase Help hereda de Command implementando
 *  todos los métodos abstractos
 *
 */
public class Help implements Command {

	@Override
	public void execute(Engine engine) {
		CommandParser.showHelp();
		engine.show_sProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("HELP"))
			return new Help();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return " HELP: Muestra esta ayuda: " + System.getProperty("line.separator");
	}

	@Override
	public String toString() {
		return "HELP";
	}

}

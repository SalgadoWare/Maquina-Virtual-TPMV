package Comandos;

import Excepciones.ArrayException;
import Excepciones.LexicalAnalysisException;
import Principal.Engine;

public class Compile implements Command {
	
	@Override
	public void execute(Engine engine) throws LexicalAnalysisException, ArrayException {
		engine.show_sProgram();
		engine.compile();
		engine.showBcProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("COMPILE"))
			return new Compile();
		else
			return null;
	}

	@Override
	public String textHelp() {
		return " COMPILE: Compilador" + System.getProperty("line.separator");
	}

	public String toString() {
		return "COMPILE";
	}

}

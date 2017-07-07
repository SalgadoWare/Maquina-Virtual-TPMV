package Comandos;

import java.io.FileNotFoundException;
import java.io.IOException;

import Excepciones.ArrayException;
import Principal.Engine;

public class LoadFich implements Command {

	private String txt;

	public LoadFich(String archivo) {
		this.txt = archivo;
	}

	public LoadFich() {
	}

	@Override
	public void execute(Engine engine) throws FileNotFoundException, IOException, ArrayException {
		engine.readFromFich(this.txt);
		engine.show_sProgram();
	}

	@Override
	public Command parse(String[] s) {
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD"))
			return new LoadFich(s[1]);
		else
			return null;
	}

	@Override
	public String textHelp() {
		return " LOAD FICH: Carga el archivo txt introducido desde teclado" + System.getProperty("line.separator");
	}

	public String toString() {
		return "LOAD FICH";

	}

}

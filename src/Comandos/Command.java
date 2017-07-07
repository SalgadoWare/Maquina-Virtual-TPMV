package Comandos;

import java.io.FileNotFoundException;
import java.io.IOException;

import Excepciones.ArrayException;
import Excepciones.BadFormatBytecode;
import Excepciones.ExecutionError;
import Excepciones.LexicalAnalysisException;
import Principal.Engine;

public interface Command {

	abstract public void execute(Engine engine) throws FileNotFoundException, IOException, LexicalAnalysisException,
			ArrayException, ExecutionError, BadFormatBytecode;

	abstract public Command parse(String[] s);

	abstract public String textHelp();

	abstract public String toString();
}
package Instrucciones;

import Excepciones.ArrayException;
import Excepciones.LexicalAnalysisException;
import Bytecode.CompilerB;

public interface Instruction {

	/**
	 * @param words- fuente
	 * @param lexparser
	 * @return Devolvemos la correspondiente instruccion de nuestro programa fuente
	 * @throws LexicalAnalysisException
	 */
	Instruction lexParse(String[] words, LexicalParser lexparser) throws LexicalAnalysisException;

	/**
	 * Producimos los bytecodes correspondientes a instrucciones, esto es la compilación
	 * @param compilerB
	 * @throws ArrayException
	 */
	void compile(CompilerB compilerB) throws ArrayException;

}

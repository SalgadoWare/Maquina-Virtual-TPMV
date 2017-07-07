package Instrucciones.Term;

import Bytecode.ByteCode;
import Bytecode.CompilerB;

public interface Term {
	Term parse(String term);

	ByteCode compile(CompilerB compiler);
}

package Bytecode;


public class ByteCodeParser {

	/**
	 * Array de objetos modelo
	 */
	private final static ByteCode[] bytecodes = { new Add(), new Sub(), new Mul(), new Div(), new Push(), new Load(),
			new Store(), new Halt(), new Out(), new Ifeq(), new Ifneq(), new Ifleq(), new Ifle(), new Goto() };

	/**
	 * Recorriendo el array con los objetos "modelo" de los comandos, cuando uno
	 * de ellos se parsea correctamente, lo devolvemos
	 * 
	 * @param line
	 *            (string introducido por teclado)
	 * @return Un nuevo bytecode
	 */
	public static ByteCode parse(String line) {
		line = line.trim();
		String words[] = line.split(" +");
		ByteCode b = null;
		int i = 0;
		while (i < ByteCodeParser.bytecodes.length && b == null) {
			b = ByteCodeParser.bytecodes[i].parse(words);
			++i;
		}
		return b;
	}
}
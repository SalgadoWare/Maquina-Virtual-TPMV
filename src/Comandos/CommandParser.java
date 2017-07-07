package Comandos;

public class CommandParser {

	/**
	 * Array con los objetos "modelo" de los comandos
	 */
	private final static Command[] commands = { new Help(), new Quit(), new Replacebc(), new Run(), new LoadFich(),
			new Compile() };

	/**
	 * Recorriendo el array con los objetos "modelo" de los comandos, cuando uno
	 * de ellos se parsea correctamente, lo devolvemos
	 * 
	 * @param line
	 *            (string introducido por teclado)
	 * @return Un nuevo Comando
	 */
	public static Command parse(String line) {
		line = line.trim();
		String words[] = line.split(" +");
		Command nuevoComando = null;
		int i = 0;
		while (i < CommandParser.commands.length && nuevoComando == null) {
			nuevoComando = commands[i].parse(words);
			++i;
		}
		return nuevoComando;
	}

	/**
	 * Recorriendo el array con los objetos "modelo" de los comandos, vamos
	 * mostrando su texto de ayuda
	 */
	public static void showHelp() {
		for (Command c : commands)
			System.out.print(c.textHelp());
		System.out.println();
	}
}
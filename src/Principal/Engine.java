package Principal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import Bytecode.CompilerB;
import Bytecode.ByteCode;
import Bytecode.ByteCodeParser;
import Bytecode.ByteCodeProgram;
import Comandos.Command;
import Comandos.CommandParser;
import Cpu.CPU;
import Excepciones.ArrayException;
import Excepciones.BadFormatBytecode;
import Excepciones.ExecutionError;
import Excepciones.LexicalAnalysisException;
import Instrucciones.Instruction;
import Instrucciones.InstructionParser;
import Instrucciones.LexicalParser;
import Instrucciones.ParsedProgram;

public class Engine {

	private SourceProgram sProgram;
	private ParsedProgram pProgram;
	private ByteCodeProgram bcProgram;
	private boolean quit;
	public static Scanner sc;
	private CPU cpu;

	/**
	 * Constructor de engine, con la cpu como atributo
	 */
	public Engine() {
		this.bcProgram = new ByteCodeProgram();
		this.quit = false;
		this.cpu = new CPU(this.bcProgram);
		this.sProgram = new SourceProgram();
		this.pProgram = new ParsedProgram();
	}

	public void compile() throws LexicalAnalysisException, ArrayException {
		this.lexicalAnalysis();
		this.generateByteCode();
	}

	private void lexicalAnalysis() throws LexicalAnalysisException {

		LexicalParser lexi = new LexicalParser(this.sProgram);
		boolean fin = false;
		this.resetpProgram();

		while (lexi.getContador() < this.sProgram.getNumeroInstrucciones() && !fin) {
			String linea = this.sProgram.getInstruction(lexi.getContador());
			if (!linea.equalsIgnoreCase("END")) {
				Instruction i = InstructionParser.parse(linea.split(" +"), lexi);
				if (i == null)
					throw new LexicalAnalysisException(
							"No se ha producido un parseo correcto: linea: " + lexi.getContador());
				else
					this.pProgram.addIns(i);
			} else {
				if (lexi.getContador() == this.sProgram.getNumeroInstrucciones() - 1)
					fin = true;
				else
					throw new LexicalAnalysisException("Posicion de END incorrecta");
			}
		}
	}

	public void resetpProgram() {
		this.pProgram.reset();
	}

	private void generateByteCode() throws ArrayException {
		this.bcProgram.reset();
		CompilerB compilador = new CompilerB(this.bcProgram);
		compilador.compile(this.pProgram);
	}

	/**
	 * Bucle principal de engine
	 * 
	 */
	public void start() {

		while (!this.quit) {
			Engine.sc = new Scanner(System.in);
			String line = Engine.sc.nextLine();
			Command com = CommandParser.parse(line);
			if (com != null) {
				System.out.println("Comienza la ejecucion de " + com + System.getProperty("line.separator"));

				try {
					com.execute(this);
				} catch (FileNotFoundException e) {
					System.out.println("FileNotFoundException: El archivo introducido no se ha encontrado");
				} catch (IOException e) {
					System.out.println("IOException: El archivo introducido no se ha encontrado");
				} catch (ArrayException e) {
					System.out.println(e.getMessage());
				} catch (LexicalAnalysisException e) {
					System.out.println(e.getMessage());
				} catch (ExecutionError e) {
					System.out.println(e.getMessage());
				} catch (BadFormatBytecode e) {
					System.out.println(e.getMessage());
				}
			} else
				System.out.println("Error de escritura del comando");
		}
		System.out.println("Fin de la ejecucion");
	}

	/**
	 * Ejecución del comando quit, se sale del buce start y se finaliza la
	 * ejecución de engine
	 * 
	 */
	public void stopEngine() {
		this.quit = true;
	}

	/**
	 * Ejecución del comando reset
	 * 
	 */
	public boolean resetProgram() {
		this.bcProgram.reset();
		return true;
	}

	/**
	 * 
	 * @param pos
	 *            (parámetro del bytecode replace)
	 * @throws BadFormatBytecode
	 * @throws ArrayException
	 */
	public void reemplazar(int pos) throws BadFormatBytecode, ArrayException {

		System.out.println("Introduce la nueva instruccion:");
		Engine.sc = new Scanner(System.in);
		String linea = sc.nextLine();
		ByteCode b = ByteCodeParser.parse(linea);

		if (b == null)
			throw new BadFormatBytecode(" BadFormatBytecode");
		else
			this.bcProgram.overwrite(b, pos);

	}

	/**
	 * Mostramos en consola el programa existente, y en caso de que no lo
	 * hubiese lo notificamos un mensaje
	 */
	public void showBcProgram() {
		if (this.bcProgram.getContador() > 0)
			System.out.println(System.getProperty("line.separator") + this.bcProgram);
		else
			System.out.println("No hay programa almacenado" + System.getProperty("line.separator"));

	}

	/**
	 * Llamamos al método run de Cpu
	 */
	public void run() throws ExecutionError, ArrayException {
		this.cpu.run();
		this.show_cpu();
	}

	public void show_cpu() {
		System.out.println(this.cpu);
	}

	public void readFromFich(String txt) throws FileNotFoundException, IOException, ArrayException {

		Engine.sc = new Scanner(new FileReader(txt));
		String linea;
		this.sProgram.reset();
		this.bcProgram.reset();
		this.cpu.resetCPU();

		while (sc.hasNextLine()) {
			linea = sc.nextLine();
			this.sProgram.addLine(linea);
		}

		Engine.sc.close();
	}

	/**
	 * Mostramos en consola el programa existente, y en caso de que no lo
	 * hubiese lo notificamos un mensaje
	 */
	public void show_sProgram() {
		if (this.sProgram.getNumeroInstrucciones() > 0)
			System.out.println("Programa fuente almacenado:" + System.getProperty("line.separator") + this.sProgram);
		else
			System.out.println("No hay programa fuente almacenado" + System.getProperty("line.separator"));

	}
}
package utils;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Classe IO
 * Contiene metodi utili per inserimento da tastiera
 * @author Elia Cotti Cottini
 * */
public class IO {
	private static final String MESS_STRINGA_VUOTA="Inserisci una stringa non vuota";
	//private static final String MESS_STRINGA_NON_VALIDA="Inserisci una stringa valida";
	private static final String MESS_CHAR_VUOTO="Inserisci un carattere non vuoto";
	private static final String MESS_CHAR_NON_VALIDO="Inserisci un carattere valido";
	private static final String VALORE_NON_VALIDO="Inserisci un valore valido";
	private static final String VALORE_COMPRESO="Inserisci un valore compreso tra %d e %d (inclusi)";
	private static final String VALORE_COMPRESO_DOUBLE="Inserisci un valore compreso tra %f e %f (inclusi)";
	private static final String VALORE_MINIMO="Inserisci un valore superiore a %d";
	private static final String VALORE_MINIMO_DOUBLE="Inserisci un valore superiore a %f";
	private final static char RISPOSTA_SI='s';
	private final static char RISPOSTA_NO='n';
	private static Scanner scan;

	//private static Scanner s = new Scanner(System.in);
	/**
	 * Legge la stringa inserita da tastiera, controlla che non sia vuota e la ritorna come String
	 * @return La stringa inserita
	 * */
	public static String inputString() {
		String tmp="";
		scan = new Scanner(System.in);
		tmp=scan.nextLine();
		while(tmp.trim().isEmpty()) {
			System.out.println(MESS_STRINGA_VUOTA);
			tmp=scan.nextLine();
		}
		return tmp;
	}

	/**
	 * Legge un carattere dalla tastiera in risposta alla domanda posta
	 * @param domanda - domanda da fare
	 * @return <code>true</code> - se si<br><code>false</code> - se no
	 * */
	//fonte: InputDati in UniBSFpLib
	public static boolean siNo(String domanda) {
		String mess=domanda+"("+RISPOSTA_SI+"/"+RISPOSTA_NO+")";
		System.out.println(mess);
		char risposta = inputChar();
		while(risposta!='s'&&risposta!='S'&&risposta!='n'&&risposta!='N') {
			System.out.println(MESS_CHAR_NON_VALIDO);
			risposta = inputChar();
		}
		return risposta==RISPOSTA_SI?true:false;
	}

	/**
	 * Legge un carattere non vuoto
	 * @return carattere inserito
	 * */
	public static char inputChar() {
		char tmp=' ';
		scan=new Scanner(System.in);
		try {	
			tmp=scan.nextLine().charAt(0);
			while(tmp==' '||tmp=='\n') {
				System.out.println(MESS_CHAR_VUOTO);
				tmp=scan.nextLine().charAt(0);
			}
		}catch (StringIndexOutOfBoundsException e) {
			System.out.println(MESS_CHAR_NON_VALIDO);
			scan.next();
		}
		return tmp;
	}

	/**
	 * Legge un valore intero inserito da tastiera e lo ritorna come int
	 * @return Il valore intero inserito
	 * 
	 * */
	public static int inputInt() {
		int tmp=0;
		scan = new Scanner(System.in);
		boolean finito=false;
		while(!finito) 
			try {
				tmp=scan.nextInt();
				finito=true;
			} catch (InputMismatchException e) {
				System.out.println(VALORE_NON_VALIDO);
				/*
				 * Serve per cancellare l'input errato
				 * nextLine() e' meglio di next() perche' prende tutta la riga compresi eventuali spazi
				 * */
				scan.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scan.nextLine();
			}

		return tmp;
	}

	/**
	 * Legge un valore intero inserito da tastiera e lo ritorna come int, se e' compreso tra minimo e massimo
	 * @param min - valore minimo (compreso)
	 * @param max - valore massimo (compreso)
	 * @return valore intero inserito, se valido
	 * */
	public static int inputInt(int min, int max) {
		int tmp=0;
		scan = new Scanner(System.in);
		boolean finito=false;
		while(!finito) 
			try {
				tmp=scan.nextInt();
				while(tmp<min||tmp>max) {
					System.out.println(String.format(VALORE_COMPRESO, min, max));
					tmp=scan.nextInt();
				}
				finito=true;
			}catch (InputMismatchException e) {
				System.out.println(VALORE_NON_VALIDO);
				scan.nextLine();
			}catch (Exception e) {
				e.printStackTrace();
				scan.nextLine();
			}

		return tmp;
	}

	/**
	 * Legge un valore intero inserito da tastiera e lo ritorna come int, se e' maggiore del minimo
	 * @param min - valore minimo (compreso)
	 * @return valore intero inserito, se valido
	 * */
	public static int inputInt(int min) {
		int tmp=0;
		scan = new Scanner(System.in);
		boolean finito=false;
		while(!finito)
			try {
				tmp=scan.nextInt();
				while(tmp<min) {
					System.out.println(String.format(VALORE_MINIMO, min));
					tmp=scan.nextInt();
				}
				finito=true;
			} catch (InputMismatchException e) {
				System.out.println(VALORE_NON_VALIDO);
				scan.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scan.nextLine();
			}

		return tmp;
	}
	
	/**
	 * Legge un valore double inserito da tastiera e lo ritorna come double
	 * @return Il valore double inserito
	 * 
	 * */
	public static double inputDouble() {
		double tmp=0;
		scan = new Scanner(System.in);
		boolean finito=false;
		while(!finito) 
			try {
				tmp=scan.nextDouble();
				finito=true;
			} catch (InputMismatchException e) {
				System.out.println(VALORE_NON_VALIDO);
				scan.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scan.nextLine();
			}

		return tmp;
	}

	/**
	 * Legge un valore double inserito da tastiera e lo ritorna come double, se e' compreso tra minimo e massimo
	 * @param min - valore minimo (compreso)
	 * @param max - valore massimo (compreso)
	 * @return valore double inserito, se valido
	 * */
	public static double inputDouble(double min, double max) {
		double tmp=0;
		scan = new Scanner(System.in);
		boolean finito=false;
		while(!finito) 
			try {
				tmp=scan.nextDouble();
				while(tmp<min||tmp>max) {
					System.out.println(String.format(VALORE_COMPRESO_DOUBLE, min, max));
					tmp=scan.nextDouble();
				}
				finito=true;
			}catch (InputMismatchException e) {
				System.out.println(VALORE_NON_VALIDO);
				scan.nextLine();
			}catch (Exception e) {
				e.printStackTrace();
				scan.nextLine();
			}

		return tmp;
	}

	/**
	 * Legge un valore double inserito da tastiera e lo ritorna come double, se e' maggiore del minimo
	 * @param min - valore minimo (compreso)
	 * @return valore double inserito, se valido
	 * */
	public static double inputDouble(double min) {
		double tmp=0;
		scan = new Scanner(System.in);
		boolean finito=false;
		while(!finito)
			try {
				tmp=scan.nextDouble();
				while(tmp<min) {
					System.out.println(String.format(VALORE_MINIMO_DOUBLE, min));
					tmp=scan.nextDouble();
				}
				finito=true;
			} catch (InputMismatchException e) {
				System.out.println(VALORE_NON_VALIDO);
				scan.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
				scan.nextLine();
			}

		return tmp;
	}
}

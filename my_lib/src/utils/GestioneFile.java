package utils;

import java.io.*;
//Fonte: UniBSFpLib
public class GestioneFile {

	private final static String MSG_NO_FILE = "ATTENZIONE: NON TROVO IL FILE ";
	private final static String MSG_NO_LETTURA = "ATTENZIONE: PROBLEMI CON LA LETTURA DEL FILE ";
	private final static String MSG_NO_SCRITTURA = "ATTENZIONE: PROBLEMI CON LA SCRITTURA DEL FILE ";
	private final static String MSG_NO_CHIUSURA ="ATTENZIONE: PROBLEMI CON LA CHIUSURA DEL FILE ";
	/**
	 * @param file - File da leggere
	 * @return <code>Object</code> contenente i dati del file letto
	 * */
	public static Object caricaOggetto (File file){
		//si usa Object perchè qualunque oggetto è sottoclasse di Object
		Object letto = null;
		ObjectInputStream ingresso = null;

		try{
			ingresso = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			letto = ingresso.readObject();
		}
		catch (FileNotFoundException excNotFound){
			System.out.println(MSG_NO_FILE + file.getName() );
		}
		catch (IOException excLettura){
			System.out.println(MSG_NO_LETTURA + file.getName() );
		}
		catch (ClassNotFoundException excLettura){
			System.out.println(MSG_NO_LETTURA + file.getName() );
		}
		finally{//chiude InputStream
			if (ingresso != null){
				try{
					ingresso.close();
				}
				catch (IOException excChiusura){
					System.out.println(MSG_NO_CHIUSURA + file.getName() );
				}
			}
		}
		return letto;
	}
	/**
	 * @param file - File su cui salvare
	 * @param daSalvare - <code>Object</code> da salvare sul file
	 * */
	public static void salvaOggetto (File file, Object daSalvare){
		ObjectOutputStream uscita = null;

		try{
			uscita = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			uscita.writeObject(daSalvare);
		}
		catch (IOException excScrittura){
			System.out.println(MSG_NO_SCRITTURA + file.getName() );
		}
		finally{
			if (uscita != null){//chiude OutputStream
				try {
					uscita.close();
				}
				catch (IOException excChiusura){
					System.out.println(MSG_NO_CHIUSURA + file.getName() );
				}
			}
		}
	}


}

package utils;
/**
 * Classe utile per la gestione dei menu
 * */
public class MyMenu {
	//Fonte UniBSFpLib
	private static final String INSERIMENTO="Scegli un opzione:";
	private static final String USCITA="0\tEsci";

	private String voci[];
	private String nome;

	/**
	 * @param _nome - nome del menu
	 * @param _voci - elenco opzioni
	 * */
	public MyMenu(String _nome, String _voci[]) {
		this.nome=_nome;
		this.voci=_voci;
	}
	/**
	 * @return numero opzione scelta
	 * */
	public int scelta() {
		this.show();
		System.out.println(INSERIMENTO);
		return IO.inputInt(0,voci.length);
	}

	private void show() {
		System.out.println(this.nome);
		for(int i=0;i<voci.length;i++)
			System.out.println((i+1)+"\t"+voci[i]);
		System.out.println(USCITA);
	}

}

package rubrica;

import java.util.HashMap;
import java.util.Map;

public class RubricaTelefonica {

	private static Map<String, String> rubrica = new HashMap<String, String>();

	public static void main(String[] args) throws Exception {
		RubricaTelefonica rub = new RubricaTelefonica();
		rub.aggiungiContatto("Mario", "1111");
		rub.aggiungiContatto("Luigi", "2222");
		rub.aggiungiContatto("Aldo", "3333");
		rub.aggiungiContatto("Giovanni", "4444");
		rub.aggiungiContatto("Giacomo", "5555");
		rub.aggiungiContatto("Cristiana", "6666");
		rub.aggiungiContatto("Aldo", "7777");

		rub.stampaRubrica();
		System.out.println("---------------------------------------");

		rub.rimuoviContatto("Luigi");
		System.out.println("Rubrica dopo la rimozione di un contatto");
		rub.stampaRubrica();
		System.out.println("---------------------------------------");

		String nomeCerca = "Aldo";
		System.out.println("Il numero della persona di nome " + nomeCerca + " è: " + rub.ricercaNumero(nomeCerca));
		System.out.println("---------------------------------------");

		String numCerca = "6666";
		System.out.println(
				"Il nome della persona che ha come numero " + numCerca + " è: " + rub.ricercaPersona(numCerca));
		System.out.println("---------------------------------------");

	}

	// 1. L’inserimento di una coppia <Nome, telefono>
	public void aggiungiContatto(String nome, String numero) throws Exception {
		if (rubrica.containsKey(nome)) {
			System.out.println("Contatto già presente in rubrica");
		} else {
			rubrica.put(nome, numero);
			System.out.println("Contatto aggiunto");
		}
	}

	// 2. La cancellazione di una coppia <Nome, telefono> a partire dal nome
	public void rimuoviContatto(String nome) {
		rubrica.remove(nome);
		System.out.println("Contatto rimosso");
	}

	// 3. La ricerca di una Persona di cui si conosce il numero di telefono
	public String ricercaPersona(String numero) {
		String trovato = null;
		for (String persona : rubrica.keySet()) {
			if (numero.equals(rubrica.get(persona)))
				trovato = persona;
		}
		return trovato;
	}

	// 4. La ricerca del numero di telefono di una Persona di cui si conosce il Nome
	public String ricercaNumero(String nome) {
		return rubrica.get(nome);
	}

	// 5. La stampa di tutti i contatti con nome e numero
	public void stampaRubrica() {
		System.out.println("*******     Rubrica     *******");
		for (String persona : rubrica.keySet()) {
			System.out.println("Nome: " + persona + " - Numero: " + rubrica.get(persona));
		}
	}

}

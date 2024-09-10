import java.util.Random;

public class VetorInteiros {

	protected int [] vetor = null;
	protected int iterador = 0;
	protected int tamanho = 0;

	VetorInteiros (int tamanho, int inteiroMaximo) {
		int i = 0;
		Random gerador = new Random();
		
		this.vetor = new int[tamanho];
		this.tamanho = tamanho;
		this.iterador = 0;

		for (i = 0; i < tamanho; i++) this.vetor[i] = gerador.nextInt(inteiroMaximo);
	}


	public boolean estaOrdenado (boolean reverse) {
		int sinal = 1;

		if (vetor == null)
			return false;

		if (reverse == true) 
			sinal = - 1;

		for (int i = 0; i < tamanho - 1; i++) {
			if (sinal * this.comparaElementos(i, i+1) > 0)
				return false;
		}
		
		return true;
	}

	public void imprimeVetor () {
		int i;

		System.out.printf("Imprimindo vetor:\n[ ");

		for (i = 0; i < tamanho - 1; i++)
			System.out.printf(" %d ,", vetor[i]);	

		System.out.printf(" %d ]\n", vetor[i]);

	}
	
	private void trocaElementos (int pos1, int pos2) {
		int aux;

		if (vetor == null)
			return;

		if (pos1 < 0 || pos2 < 0 || pos1 >= tamanho || pos2 >= tamanho) 
			return;

		aux = vetor[pos1];
		vetor[pos1] = vetor[pos2];
		vetor[pos2] = aux;
	}
	
	private int comparaElementos (int pos1, int pos2) {
			
		/*
			retorna:
				* -1, se elemento da pos1 for o menor;
				*  0, se os elementos forem iguais;
				*  1, se o elemento da pos1 for o maior;
				*  -2, caso vetor invalido
		*/

		if (pos1 >= tamanho || pos2 >= tamanho || pos1 < 0 || pos2 < 0)
			return -2;
		
		int resultado = vetor[pos1] - vetor[pos2];
		
		if (resultado < 0) return -1;
		if (resultado == 0)	return 0;
		else	return 1;
			
	}

	public void selectionSort (boolean reverse) {
		int sinal = 1;
		int i = 0, j = 0;
		int menor;
	
		if (vetor == null)
			return;

		if (reverse == true)
			sinal = -1;
		
		while (i < tamanho - 1) {
			menor = i;
			for (j = i+1; j < tamanho; j++) {
				if (sinal * this.comparaElementos (j, menor) < 0) 
					menor = j;
			}
			this.trocaElementos(i, menor);
			i++;
		}

	}

	public void insertionSort (boolean reverse) {
		int i, j;
		int sinal = 1;

		if (vetor == null)
			return;

		if (reverse == true)
			sinal = -1;

		for (i = 1; i <= tamanho; i++) {
			for (j = i - 1; j > 0 && sinal*this.comparaElementos(j,j-1) < 0; j--)
				this.trocaElementos(j, j-1);
		}
	}

	public static void main (String args[]) {
		VetorInteiros v1 = new VetorInteiros (5, 100);

		v1.imprimeVetor();

		v1.insertionSort(false);

		v1.imprimeVetor();
	
		v1.insertionSort(true);
	
		v1.imprimeVetor();

	}

}

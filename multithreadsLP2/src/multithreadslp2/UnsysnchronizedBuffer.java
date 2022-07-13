
public class UnsysnchronizedBuffer implements Buffer {
	private int buffer = -1;
	private int i = 0;
	private int j = 0;
	private int z = 0;
	private int[] bufferIntArray = new int[10];
	private double[] bufferDoubleArray = new double[10];
	private String[] bufferStringArray = new String[10];

	@Override
	public void putBuffer(int value) throws InterruptedException{
		System.out.printf("Valor do putBuffer: \t\t%d", value);
		buffer = value;
	}

	@Override
	public int getBuffer() throws InterruptedException{
		System.out.printf("Leitura  getBuffer: \t\t%d", buffer);
		return buffer;
	}

	@Override
	public void putBufferIntArray(int value) throws InterruptedException{
		System.out.printf("Escrita valor do Array de int: \t\t%d", value); // imprimindo os valores de escrita do buffer de vetor inteiro passando a variavel value que tem os valores escritos do vetor inteiro
		bufferIntArray[value-1] = value; // como a posicao comeca com 0, a posicao sera o parametro value passado no metodo putbufferintarray - 1, pois essa sera a posicao do array inteiro 
	}

	@Override
	public int getBufferIntArray() throws InterruptedException{
		int readValue = bufferIntArray[i]; // a posicao do vetor inteiro será i que tera seu valor incrementado em mais um até o 10° elemento que será o último. Permitindo a leitura de todos os valores atribuidos ao vetor inteiro
		System.out.printf("Leitura valor do Array de int: \t\t%d", readValue);
		if(i != 10) { // verifica se a posicao ou indice é diferente de 10
			if(readValue != 0 && bufferIntArray[i] != 0) i++; // ele verifica se o vetor e sua posicao sao diferentes de 0, se sim, ele incrementa um na variavel i, permitindo com que os valores sejam 10 elementos de 1 a 10
		}
		return readValue;
	}

	@Override
	public void putBufferFloatArray(float value) throws InterruptedException {
		System.out.printf("Escrita valor Array de float: \t\t%,.2f", value);
		int i = (int) value;  // convertendo double value para inteiro para depois poder atribuir a posicao que e um valor inteiro a variavel double value
		bufferDoubleArray[i-1] = value; // atribuindo a posicao do vetor de double a variavel doble value que e passada no parametro do metodo putbufferdoublearray
	}

        @Override
	public float getBufferFloatArray() throws InterruptedException {
		float readValue = (float) bufferDoubleArray[j];
		System.out.printf("Leitura valor do Array de float: \t\t%,.2f", readValue);
		if(j != 10) {
			if(readValue != 0 &&  bufferDoubleArray[j+1] != 0) j++; 
		}
		return readValue;
	}

	@Override
	public void putBufferStringArray(int posicao) throws InterruptedException {
		System.out.printf("Escrita valor do Array de String: \t\t%d", posicao); // imprimindo os valores do vetor de string
		String value = String.valueOf(posicao); // convertendo para String o valor inteiro de posicao para atribuir a posicao da string a variavel String value
		bufferStringArray[posicao-1] = value; // atribuindo a posicao do vetor de String à variavel value do tipo String
	}

	@Override
	public int getBufferStringArray() throws InterruptedException {
		int actualValue;
		System.out.printf("Leitura valor do Array de String: \t\t%s", bufferStringArray[z]);
		if(bufferStringArray[z] == null) actualValue = 0;
		else {
			actualValue = Integer.parseInt(bufferStringArray[z]);
			if(z != 10) {
				if(actualValue != 0 &&  bufferStringArray[z+1] != null) z++;
			}
		}
		return actualValue;
	}

}

public interface Buffer {
	public void putBuffer(int value) throws InterruptedException; // criando metodo para setar valor inteiro ao buffer
	public int getBuffer() throws InterruptedException; // criando metodo para pegar o valor atribuido por meio do putbuffer
	public void putBufferIntArray(int value) throws InterruptedException;// criando metodo para pegar o valor atribuido por meio do putbuffer
	public int getBufferIntArray() throws InterruptedException;// criando metodo para setar valor array de inteiro ao buffer
	public void putBufferFloatArray(float value) throws InterruptedException; // criando metodo para setar valor array de double ao buffer
	public float getBufferFloatArray() throws InterruptedException;// criando metodo para pegar o valor atribuido por meio do put
	public void putBufferStringArray(int value) throws InterruptedException; // criando metodo para setar valor array de string ao buffer passando a posicao por isso passa um valor inteiro
	public int getBufferStringArray() throws InterruptedException;// criando metodo para pegar o valor atribuido por meio do put

}

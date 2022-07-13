import java.security.SecureRandom;

public class WriteBufferIntArray implements Runnable{
	private int[] intValue = {2,4,1,7,3,5,9,6,8,10}; // atribuindo valores as posicoes do array
	private static final SecureRandom // declarando o metodo SecureRandom do Java
	generator = new SecureRandom(); 
	private final Buffer sharedLocation; // criando um objeto da classe Buffer que poderá chamar atraves desse objeto os metodos da clase Buffer como o putbuffer e getbuffer
	public WriteBufferIntArray(Buffer sharedLocation) { // criando um construtor da classe WriteBufferIntArray passando o objeto da classe Buffer
		this.sharedLocation = sharedLocation;
	}
	public void run() {
		int sum = 0;
		for (int count = 0;count < 10;count ++) { //percorrendo atraves do for 10 elementos iniciando na posicao 0 e indo ate a 9
			try {
				Thread.sleep(generator.nextInt(3000)); // chamando o metodo sleep do Thread que permite com que os haja um intervalo de tempo na leitura dos valores conforme especificado dentro dos parenteses
				sharedLocation.putBufferIntArray(intValue[count]);//escrevendo os valores atribuidos no array na posicao [count] que vai da posicao 0 à 9 e chamando o metodo putbuffer da classe Buffer através do objeto sharedLocation e passando os valores atribuídos a variavel intArray na posicao count que ira aumentar de 1 um em 1 dentro do for sempre avancando pra proxima
				sum+=intValue[count];// somando 1 unidade para sum e o array valorint na posicao[count] que vai estar começando na primeira posicao 0 e indo até a ultima que sera a 9                          
				System.out.printf("\t\t\t%2d\n",sum);//imprimindo os valores de sum um a um
				}
			catch(InterruptedException e){ 
				Thread.currentThread().interrupt(); // mensagem de erro caso de erro na leitura		
			}			
		}
		System.out.printf("%n%s %d%n%s%n",
				"Escrita do total de valores: ",
				sum, "Escrita finalizada!"); // imprimindo o total de valores escritos da variavel sum
	}
}

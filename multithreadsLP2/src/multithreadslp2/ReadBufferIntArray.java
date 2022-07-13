import java.security.SecureRandom;

public class ReadBufferIntArray implements Runnable{
	private static final SecureRandom // classe java que tem o metodo gerador de numeros aleatorios no java
	generator = new SecureRandom(); // metodo gerador de numeros aleatorios
	private final Buffer sharedLocation; // criando um objeto da classe Buffer que poderá chamar atraves desse objeto os metodos da clase Buffer como o putbuffer e getbuffer

	public ReadBufferIntArray(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	public void run() {
		int sum = 0;
		for (int count =1;count <=10;count ++) { // percorrendo 10 elementos através do for iniciando em 1 e indo até o 10
			try {
				Thread.sleep(generator.nextInt(3000)); // chamando o metodo sleep do Thread que permite com que os haja um intervalo de tempo na leitura dos valores conforme especificado dentro dos parenteses e o generator que permite gerar numeros aleatorios
				sum += sharedLocation.getBufferIntArray(); //escrevendo os valores atribuidos no array na posicao [count] que vai da posicao 0 à 9 e chamando o metodo putbuffer da classe Buffer através do objeto sharedLocation e passando os valores atribuídos a variavel intArray na posicao count que ira aumentar de 1 um em 1 dentro do for sempre avancando pra proxima
				System.out.printf("\t\t\t\t\t\t%2d\n",sum);//imprimindo os valores de sum um a um
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();// mensagem de erro caso de erro na leitura				
			}			
		}
		System.out.printf("%n%s %d%n%s%n",
				"Leitura do total de valores: ", 
				sum, "Leitura finalizada!");// imprimindo o total de valores escritos da variavel sum
	}
}
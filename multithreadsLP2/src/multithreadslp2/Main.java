

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService  threadRun = Executors.newCachedThreadPool();
		Buffer sharedLocation = new UnsysnchronizedBuffer();
		
		System.out.printf(
			"Thread running\t\tValue\t "
			+ "Sum write\tSum read\n"
		);

		System.out.println("-------------------------------------------------------------------------------------");
		threadRun.execute(new WriteBuffer(sharedLocation)); 
		threadRun.execute(new ReadBuffer(sharedLocation));
		threadRun.execute(new WriteBufferIntArray(sharedLocation));//chamando a classe WriteBufferIntArray que escreve os valores do array inteiro mandando o objeto sharedLocation do tipo buffer para fazer a escrita no buffer 
		threadRun.execute(new ReadBufferIntArray(sharedLocation));//chamando a classe ReadBufferIntArray que faz a leitura os valores do array inteiro mandando o objeto sharedLocation do tipo buffer para fazer a escrita no buffer 
		threadRun.execute(new WriteBufferFloatArray(sharedLocation));
		threadRun.execute(new ReadBufferFloatArray(sharedLocation));
		threadRun.execute(new WriteBufferStringArray(sharedLocation));
		threadRun.execute(new ReadBufferStringArray(sharedLocation));
		threadRun.shutdown();
		threadRun.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.printf(
			"Thread running\t\t\t\t\tClosing\n\n" //finalizando a escrita e leitura de valores no buffer
		);
	}

}

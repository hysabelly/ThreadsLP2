import java.security.SecureRandom;

public class WriteBufferFloatArray implements Runnable{
	private float[] floatValue ={1.0f,2.5f,4.0f,7.3f,8.3f,6.3f,7.5f,5.9f,3.1f,1.4f};
	private static final SecureRandom
	generator = new SecureRandom();
	private final Buffer sharedLocation;
	public WriteBufferFloatArray(Buffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	public void run() {
		double sum = 0.0;
		for (int count = 0;count < 10;count++) {
			try {
				Thread.sleep(generator.nextInt(3000));
				sharedLocation.putBufferFloatArray(floatValue[count]);
				sum+=floatValue[count];
				System.out.printf("\t\t\t%,.2f\n",sum);
				}
			catch(InterruptedException e){
				Thread.currentThread().interrupt();				
			}			
		}
		System.out.printf("%n%s %,.2f%n%s%n",
				"Escrita do total de valores: ",
				sum, "Escrita finalizada!");
	}

}

package dev.log.thread;

public class RunThread {

	public static void main(String[] args) {
		PrintThread print = new PrintThread();
		new Thread(print).start();
		for(int i = 0; i < 10 ; i++) {
			try {
				Thread.sleep(2000);
				print.incX();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

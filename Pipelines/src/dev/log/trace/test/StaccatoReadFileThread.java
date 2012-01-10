package dev.log.trace.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dev.log.barinel.activity.Matrix;
import dev.log.trace.Staccato;

public class StaccatoReadFileThread implements Runnable {

	@Override
	public void run() {
		try{
			System.out.println("StaccatoReadFileThread Start input stream");
			String file = "matrix_smaller.txt";
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Matrix matrix = new Matrix();
			String line;
			ArrayList<String> execution;
			long totalTime = 0;
			int linenumber = 1;
			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			while((line = reader.readLine()) != null){
//				System.out.println("Reading line: "+linenumber++);
				execution = new ArrayList<String>();
				
				String[] parts = line.split("\t");
				int error = 0;
				if(parts[1].equals("-")) error = 1;
				
				parts = parts[0].split(" ");
				
				for(int i = 0; i < parts.length; i++)
					if(Integer.parseInt(parts[i]) == 1)
						execution.add("c"+(i+1));
				
				matrix.addExecution(execution, error);
				
				long begin = System.nanoTime();
				result = Staccato.calculate(matrix.copy());
				totalTime += System.nanoTime() - begin;
//				System.out.println("for matrix " + matrix);
//				Thread.sleep(1000);
			}
//			System.out.println(matrix);
//			System.out.println(matrix.getRank());
			System.out.println(result);
			System.out.println("Total time taken: "+(double)totalTime/1000000000+" for "+result.size()+" solutions.");
		} catch(IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

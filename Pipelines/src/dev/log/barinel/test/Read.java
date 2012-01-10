package dev.log.barinel.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import dev.log.barinel.activity.Matrix;

public class Read {
	
	public static Matrix readFile(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			return read(reader);
		} catch(IOException e) {
			System.out.println("Failed to open the requested matrix file: " + file);
			e.printStackTrace();
			return null;
		}
	}
	
	public static Matrix readString(String matrix) {
		BufferedReader reader = new BufferedReader(new StringReader(matrix));
		try {
			return read(reader);
		} catch (IOException e) {
			System.out.println("Failed to parse string matrix: "+matrix);
			e.printStackTrace();
			return null;
		}
	}
	
	private static Matrix read(BufferedReader reader) throws IOException {

		Matrix matrix = new Matrix();
		String line;
		ArrayList<String> execution;
		while((line = reader.readLine()) != null){
			execution = new ArrayList<String>();
			
			String[] parts = line.split("\t");
			int error = 0;
			if(parts[1].equals("-")) error = 1;
			
			parts = parts[0].split(" ");
			
			for(int i = 0; i < parts.length; i++)
				if(Integer.parseInt(parts[i]) == 1)
					execution.add("c"+i);
			
			matrix.addExecution(execution, error);
		}
		return matrix;

	}
}

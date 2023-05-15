package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {

	public static void main(String[] args) throws IOException
	{
		String filename = "test.exe";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get("src\\hust\\soict\\dsai\\garbage\\test.exe"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		startTime = System.currentTimeMillis();
		String outputString = "";
		
		for(byte b: inputBytes) outputString += (char)b;
		
		System.out.println(outputString);
		
		endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
	}

}

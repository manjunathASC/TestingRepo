package testRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdRun {

	public static void main(String[] args) throws IOException {
		String command = "C:\\Program Files\\Notepad++";
		try
		{
			Runtime.getRuntime().exec(command);
		} catch (IOException e)
		{
		    e.printStackTrace();
		}
	}

}

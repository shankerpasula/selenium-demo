package com.fafiner.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

	    private static final char DEFAULT_SEPARATOR = ',';

	    public static void writeLine(Writer w, List<String> values) throws IOException {
	        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
	    }

	    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
	        writeLine(w, values, separators, ' ');
	    }

	    //https://tools.ietf.org/html/rfc4180
	    private static String followCVSformat(String value) {

	        String result = value;
	       // if (result.contains("\"")) {
	       //     result = result.replace("\"", "\"\"");
	       // }
	        return result;

	    }

	    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {
            
	        boolean first = true;
	        separators = (separators == ' ') ? separators = DEFAULT_SEPARATOR : separators;
	        StringBuilder sb = new StringBuilder();
	        for (String value : values) 
	        {
	            if (!first) {
	                sb.append(separators);
	            }
	            if (customQuote == ' ') {
	                sb.append(followCVSformat(value));
	            } else {
	                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
	            }
	            first = false;
	        }
	        sb.append("\n");
	        w.append(sb.toString());
	    }
	    
	    public static void writeCSV(String fileName, ArrayList<ArrayList<String>> data)
		{
			try
			{
				 File f = new File(fileName);
			        if (f.exists()== true)
			        {
			        	f.delete();
			        }
			    f.createNewFile();
				FileWriter writer = new FileWriter("./test-data/"+fileName+".csv");
		        for(int i = 0; i < data.size();i++)
		        	CSVUtils.writeLine(writer, data.get(i));
		        writer.flush();
		        writer.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

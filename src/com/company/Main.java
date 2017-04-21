package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) {

	try{
	    URL url = new URL("http://www.google.com");
        if(url == null){
            throw new RuntimeException();
        }
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(url.openStream())));
        String line = "";
        System.out.println(urlConnection.getContentType());
        while((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

    }
   catch (MalformedURLException e) {
        e.printStackTrace();
    }
    catch (RuntimeException ex){
	    ex.printStackTrace();
    }
    catch(IOException ex){
        ex.printStackTrace();

        }

    }
}

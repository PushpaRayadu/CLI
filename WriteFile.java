package com.sisk;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.FileSystems;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.charset.Charset;

public class WriteFile 
{

   public static void main(String[] args) {
 
    BufferedWriter writer;
    String path = "c:\\java\\development\\files\\";
    try 
    {
     
      writer = Files.newBufferedWriter(Paths.get(path + "FileUTF8.txt"),Charset.forName("UTF-8")); 
      writer.write("This file has UTF-8 Encoding");
      writer.close();      

      writer = Files.newBufferedWriter(Paths.get(path + "FileUTF16.txt"),Charset.forName("UTF-16")); 
      writer.write("This file has UTF-16 Encoding");
      writer.close();      
  
    } catch (IOException e) 
    {
      e.printStackTrace();
    }
   }
}
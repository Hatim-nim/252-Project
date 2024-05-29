package hostingdonation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class writeTXT implements FileOperations {

    File file= null;
    
    @Override
    public void read() {
        try{
      open();
      System.out.println("  Reading from file:   ");
        Scanner read= new Scanner(file);
        while(read.hasNextLine()){
            System.out.println(read.nextLine());
        }
        read.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
  
    @Override
    public void write(String content) {
    try{
      open();
      System.out.println("  Writing to file:   : " + content);
      FileWriter fileWrite= new FileWriter(file,true);
      fileWrite.write(content+"\n  "); // writing the records to a text file
      fileWrite.close();
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    }

    private void open(){
        try {
        file = new File("result.txt");
        if (!file.exists()) {
                file.createNewFile();    
        }}catch (IOException e) {
                System.out.println(e.getMessage());
            }
          }
    }

  
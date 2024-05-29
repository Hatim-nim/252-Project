package hostingdonation;

public class proxyWriteTXT extends writeTXT  { // this class is basically the intermediate of between the writing process and the writing on the file 
    @Override
    public void read() {
      System.out.println("Calling read");
      super.read(); // calling super class to start reading
    }
  
    @Override
    public void write(String content) {
      System.out.println("Calling write"); // same here but writing
      super.write(content);
    }
}

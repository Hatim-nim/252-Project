package hostingdonation;

public class proxyWriteTXT extends writeTXT  {
    @Override
    public void read() {
      System.out.println("Calling read");
      super.read();
    }
  
    @Override
    public void write(String content) {
      System.out.println("Calling write");
      super.write(content);
    }
}

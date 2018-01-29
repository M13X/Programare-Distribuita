package cmmdc.socket.test;
import org.junit.*;
import static org.junit.Assert.*;
import cmmdc.socket.server.impl.App;

public class TestApp{
  /*
  private App app;
  
  @Before
  public void initializare(){
    app=new App(); 
  }
  */
  
  @Test 
  public void test(){  
    assertEquals(8,App.cmmdc(56,24));
  }
  
  
  public static void main(String[] args){
    org.junit.runner.JUnitCore.main("server.TestApp");
  }
}

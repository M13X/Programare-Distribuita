package cmmdc.socket.test;
import org.testng.annotations.*;
import org.testng.Assert;
import cmmdc.socket.server.impl.App;

public class TestApp{
  /*
  private App app;
  
  @BeforeClass
  public void initializare(){
    app=new App(); 
  }
  */
  
  @Test (groups={"base"})
  public void test(){  
    Assert.assertEquals(8,App.cmmdc(56,24));
  }
  
}

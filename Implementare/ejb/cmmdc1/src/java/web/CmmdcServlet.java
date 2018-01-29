package cmmdc.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cmmdc.ejb.CmmdcBean;
import javax.ejb.EJB; 
import javax.servlet.annotation.WebServlet; 

@WebServlet(urlPatterns = "/cmmdc") 
public class CmmdcServlet extends HttpServlet{
  @EJB
  CmmdcBean cb;
  
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    //String sm=req.getParameter("m"),sn=req.getParameter("n");   
	String sn=req.getParameter("n"),sd=req.getParameter("d");  	
    //long m=Long.parseLong(sm),n=Long.parseLong(sn);  
	int n=Integer.parseInt(sn),d=Integer.parseInt(sd); 
    //long x=cb.cmmdc(m,n);
	int rez[][]= new int[n][d];
	rez = cb.tablou(n,d);
    PrintWriter out=res.getWriter();
   
    String title="Tablou";
    res.setContentType("text/html");
    out.println("<HTML><HEAD><TITLE>");
    out.println(title);
    out.println("</TITLE></HEAD><BODY>");
    out.println("<H1>"+title+"</H1>");
    //out.println("<P>Cmmdc : "+x);
	for(int i =0;i<n;i++)
	{
		out.println("<P>");
		for(int j =0;j<d;j++)
		{
			out.print(rez[i][j]);
			out.print(" ");
		}
	}
    out.println("</BODY></HTML>");
     
    out.close();   
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    doGet(req,res);
  } 
}
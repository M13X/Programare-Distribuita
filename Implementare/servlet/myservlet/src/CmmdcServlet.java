package cmmdc;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet; 
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cmmdc") 

public class CmmdcServlet extends HttpServlet{
  public long cmmdc(long m, long n){
     long r,c;
     do{
        c=n;
        r=m%n;
        m=n;
        n=r;
     }while(r!=0);
     return c;
  } 
 public  int[][] tablou(int n, int d)
	{
		int P[][] = new int[n][d];
		int T[][] = new int[n][d];
		for(int j=0; j<d; j++)
		{
			P[0][j]=1;
			for(int k=0;k<=j;k++)
			{
				T[0][j]+=P[0][k];
			}
		}
		for(int i=1; i<n; i++)
		{
			for(int j=0; j<d; j++)
			{
				P[i][j]=T[i-1][j];
				for(int k=0;k<=j;k++)
				{
					T[i][j]+=P[i][k];
				}
			}
		}
		
		return T;
	}  
   
  public void doGet(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    //String sm=req.getParameter("m"),sn=req.getParameter("n");
	String sn=req.getParameter("n"),sd=req.getParameter("d");
    String tip=req.getParameter("tip");     
    //long m=Long.parseLong(sm),n=Long.parseLong(sn);  
	int n=Integer.parseInt(sn),d=Integer.parseInt(sd); 
    //long x=cmmdc(m,n);
	int rez[][] = new int[n][d];
	rez = tablou(n,d);
    PrintWriter out=res.getWriter();
    //if(tip.equals("text/html")){
    if(1==1){
      String title="Tablou";
      res.setContentType("text/html");
      out.println("<HTML><HEAD><TITLE>");
      out.println(title);
      out.println("</TITLE></HEAD><BODY>");
      out.println("<H1>"+title+"</H1>");
	  for(int i=0;i<n;i++)
	  {
		out.println("<P>");
		for(int j=0;j<d;j++)
		{
			out.print(rez[i][j]);
			out.print(" ");
		}
	  }
      //out.println("<P>Cmmdc is "+x);
      out.println("</BODY></HTML>");
    }
    else{
      res.setContentType("text/plain");
      //out.println(x);
    }
    out.close();   
  }
  
  public void doPost(HttpServletRequest req,HttpServletResponse res)
      throws ServletException,IOException{
    doGet(req,res);
  } 
}
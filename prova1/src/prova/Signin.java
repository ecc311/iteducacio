package prova;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prova.GestorAlumnes;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	String name;
    	String edat;
    	int age=15;
    	String grup;
    	int group;
    	String password;
    	int type;
    	
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
     
        name=request.getParameter("nom");
        //edat=request.getParameter("edat");
   	    age=23;
   	    grup=request.getParameter("grup");
   	    group=Integer.parseInt(grup);	
   	    password=request.getParameter("pass");
   	    
   	    
   	    type=1;
   	    
   	    if (type==1)
   	    {
   	    	
   	    	GestorAlumnes gestora = new GestorAlumnes();
   	   	    gestora.setAlumne(name,age,group,password);
   	   	    Gestor gestor=new Gestor();
   	   	    gestor.setPersona(gestora.getAlumne());
   	   	    
   	  

    	
   	   	    int ida=gestor.getIdAlumne(name, password);
   	   	    String grupp=gestor.getGroupAlumne(name, password);
   	   	    String horari=gestor.getHorariAlumne(name, password);

   	   	    File f = new File("C:/principal.txt");
   	   	    BufferedReader entrada;
   	   	    try {
   	   	    	entrada = new BufferedReader( new FileReader( f ) );
   	   	    	String cadena = null;

   	   	    	while(entrada.ready()){

   	   	    		cadena = entrada.readLine();
    	
   	   	    		if (cadena.contains("*'''"))
   	   	    		{
    		
   	   	    			cadena=cadena.replace("*'''",Integer.toString(ida));
    	
    	}
    	if (cadena.contains("****"))
    	{
    		cadena=cadena.replace("****",name);
    	
    	}
    	if (cadena.contains("*---"))
    	{
    		cadena=cadena.replace("*---",Integer.toString(age));
    
    	}
    	if (cadena.contains("*,,,"))
    	{
    		cadena=cadena.replace("*,,,",grupp);
    		
    	}
    	if (cadena.contains("*..."))
    	{
    		cadena=cadena.replace("*...",horari);
    		
    	}
      	
    	if (cadena.contains("<h2>Professor</h2>"))
    	{
    	
    		String cadena1="<p>Professors de l'alumne:<br>";
    		out.println(cadena1);
    		 int i=0;
    		 int j=0;
    		 while( i<gestor.getAssignatura(ida).size())
	         {

    			 
    			 cadena1="id: "+gestor.getProfessorAlumne(ida).get(i).getIdPersona()+"<input nom='IdProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled><br>";
    			 out.println(cadena1);
    			 cadena1="Nom: "+gestor.getProfessorAlumne(ida).get(i).getNomPersona()+"<input nom='NomProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled><br>";
    			 out.println(cadena1);
    			 cadena1="Edat: "+gestor.getProfessorAlumne(ida).get(i).getEdatPersona()+"<input nom='EdatProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled><br>";
    			 out.println(cadena1);
    			 out.println("Assignatures que imparteix:");
    			 out.println("<br>");
    			 while(j<gestor.getAssignaturaProfessorAlumne(ida,gestor.getProfessorAlumne(ida).get(i).getIdPersona()).size())
    			 {
    			 cadena1=" "+gestor.getAssignaturaProfessorAlumne(ida,gestor.getProfessorAlumne(ida).get(i).getIdPersona()).get(j)+"<input nom='EdatProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled>";
    			 j++;
    			 out.println(cadena1);
    			 }
    			 out.println("<br>");
    			 out.println("</p>");
    			 out.println("<br>");
	             
	         i++;
	         }
    	
    	}else{
    	out.println(cadena);
    	}    

    	}
    	}catch (IOException e) {
    	e.printStackTrace();
    	}
    
   	    }else{
   	    GestorProfessors gestorp = new GestorProfessors();
   	    gestorp.setProfessor(name,age,password);
   	    Gestor gestor=new Gestor();
   	    gestor.setPersona(gestorp.getProfessor());
   	    out.println("<html>");
   	    out.println("<body>");
   	    out.println("<h1>"+gestorp.getProfessor().getIdPersona()+"</h1>");
   	    out.println("</body>"); 
   	    out.println("</html>");
   	    

   	    }
   	    	    
        
    }
    
}




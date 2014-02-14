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

/**
 * Servlet implementation class RecuperacionUsuario
 */
@WebServlet("/RecuperacionUsuario")
public class RecuperacionUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperacionUsuario() {
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
    	String ident;
    	int id;
    	String password;
    	int aux=0;
    	
    	
    	ident=request.getParameter("nom");
    	id=Integer.parseInt(ident);
    	password=request.getParameter("pass");
    	
    	
    	Gestor gestor=new Gestor();
    	
    	PrintWriter out = response.getWriter();

    	File f = new File("C:/principal.txt");
    	BufferedReader entrada;
    	try {
    	entrada = new BufferedReader( new FileReader( f ) );
    	String cadena = null;

    	while(entrada.ready()){

    	cadena = entrada.readLine();
    	
    	if (cadena.contains("*'''"))
    	{
    		
    		cadena=cadena.replace("*'''",Integer.toString(gestor.getPersona(id,password).getIdPersona()));
    	
    	}
    	if (cadena.contains("****"))
    	{
    		cadena=cadena.replace("****",gestor.getPersona(id,password).getNomPersona());
    	
    	}
    	if (cadena.contains("*---"))
    	{
    		cadena=cadena.replace("*---",Integer.toString(gestor.getPersona(id,password).getEdatPersona()));
    
    	}
    	if (cadena.contains("*,,,"))
    	{
    		cadena=cadena.replace("*,,,",gestor.getPersona(id,password).getGrupPersona());
    		
    	}
    	if (cadena.contains("*..."))
    	{
    		cadena=cadena.replace("*...",gestor.getPersona(id,password).getHorariPersona());
    		
    	}
      	
    	if (cadena.contains("<h2>Professor</h2>"))
    	{
    	
    		String cadena1="<p>Professors de l'alumne:<br>";
    		out.println(cadena1);
    		 int i=0;
    		 int j=0;
    		 while( i<gestor.getAssignatura(id).size())
	         {

    			 
    			 cadena1="id: "+gestor.getProfessorAlumne(id).get(i).getIdPersona()+"<input nom='IdProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled><br>";
    			 out.println(cadena1);
    			 cadena1="Nom: "+gestor.getProfessorAlumne(id).get(i).getNomPersona()+"<input nom='NomProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled><br>";
    			 out.println(cadena1);
    			 cadena1="Edat: "+gestor.getProfessorAlumne(id).get(i).getEdatPersona()+"<input nom='EdatProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled><br>";
    			 out.println(cadena1);
    			 out.println("Assignatures que imparteix:");
    			 out.println("<br>");
    			 while(j<gestor.getAssignaturaProfessorAlumne(id,gestor.getProfessorAlumne(id).get(i).getIdPersona()).size())
    			 {
    			 cadena1=" "+gestor.getAssignaturaProfessorAlumne(id,gestor.getProfessorAlumne(id).get(i).getIdPersona()).get(j)+"<input nom='EdatProfessor' type='text' style='background-color:transparent;border:0px solid white;' disabled>";
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
    }
}
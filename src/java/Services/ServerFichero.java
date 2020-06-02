/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.WebServiceWS_Service;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Dream-PC
 */
@WebServlet(urlPatterns = {"/ServerFichero"})
public class ServerFichero extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TServicio/Web_Service_WS.wsdl")
    private WebServiceWS_Service service;
    private static String JDBC_URL = "jdbc:mysql://localhost:3306/prueba";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String Archivo="D:\\segundo.txt";
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Server ServerFichero</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServerFichero at " + request.getContextPath() + "</h1>");
            out.println(request.getParameter("valor"));
            out.println(getFicheroAdjunto());
            
            String s = new String(getFicheroAdjunto(), StandardCharsets.US_ASCII);
            try (FileOutputStream stream = new FileOutputStream(Archivo)) {
                
                stream.write(getFicheroAdjunto());
            }
            
            out.println("se creo el archivo");
            PreparedStatement ps;
            ResultSet res;
            String cadena;
            FileReader f = new FileReader(Archivo);
            BufferedReader b = new BufferedReader(f);
            
            out.println("Subiendo archivo");
            
            while((cadena = b.readLine())!=null) {
                
                String[] parts = cadena.split(",");
                String name = parts[0]; // NOMBRES
                String lastP = parts[1]; // APELLIDO PATERNO
                String lastM = parts[2]; // APELLIDO MATERNO
                String dni = parts[3]; // DNI
                

                Connection con = null;

                try {
                    con = getConection();
                    ps = con.prepareStatement("INSERT INTO persona (nombre, apellido_paterno, apellido_materno, dni) VALUES(?,?,?,?)");
                    ps.setString(1, name);
                    ps.setString(2, lastP);
                    ps.setString(3, lastM);
                    ps.setString(4, dni);
                    ps.executeUpdate();
                    
                    int re2 = ps.executeUpdate();
                
                    if(re2 > 0){
                        out.println("Persona Guardada");
                    }else{
                        out.println("Persona No Guardad(error)");
                    }
                    
                }catch (Exception e) {  

                }  
            
            }
            b.close();
            out.println("Subida exitosa");
            out.println("</body>");
            out.println("</html>");
        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
   private String getDirec() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.WebServiceWS port = service.getWebServiceWSPort();
        return port.getDirec();
    }

    private byte[] getFicheroAdjunto() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.WebServiceWS port = service.getWebServiceWSPort();
        return port.getFicheroAdjunto();
    }

 
    
    public static Connection getConection(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = (Connection) DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
            
            
            System.out.println("conetado");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }   
 
}


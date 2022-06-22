package controller;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.genero.generoVo;
import model.genero.generoDao;

public class generoController extends HttpServlet{
    generoVo g=new generoVo();
    generoDao gd=new generoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");
        System.out.println(a);
            switch(a){
                case "registrar":
                registrar(req,resp);
                break;
                case "visualizar":
                visualizar(req,resp);
                break;
                case "eliminar":
                eliminar(req,resp);
                break;
                case "estado":
                estado(req,resp);
                break;
                case "editar":
                editar(req,resp);
                break;
    }
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");
        System.out.println(a);

        switch(a){
            case "add":
                add(req,resp);
            break;
            case "edit":
                edit(req,resp);
            break;
        }
    }
//----------------------------------------------//
    //visualizar
    private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
        generoDao gd=new generoDao();
        
        try {
            List <generoVo> generosList=gd.listargenero();
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/genero/listarGenero.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//
    //registrar
       private void registrar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/genero/insertarGenero.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }
    //----------------------------------------------//
    //eliminar  
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        try {
            gd.eliminar(g.getIdGenero());;
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }
    //----------------------------------------------//
    //estado
    
    private void estado(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        if(req.getParameter("estadoGenero")!=null){
            g.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));//Cambiar de string a boolean
        }

        try {
            gd.estado(g.getEstadoGenero(), g.getIdGenero());
            System.out.println("El estado se cambio exitosamente");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }
    }

    //----------------------------------------------//
    //editar
    
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        try {
            List<generoVo> generosList=gd.listarg(g.getIdGenero());
            req.setAttribute("generosList", generosList);
            req.getRequestDispatcher("views/genero/editarGenero.jsp").forward(req, resp);//direccion de vista
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    
    //----------------------------------------------//

//-------------------------------------------------------------------------------------------//
//Metodos del DoPost
//-------------------------------------------------------------------------------------------//

    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreGenero")!=null){
            
            g.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            g.setEstadoGenero(true);
        }
        else{
            g.setEstadoGenero(false);
        }
        try {
            gd.registrar(g);
            System.out.println("Registro insertado correctamente");
          visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idGenero")!=null){
            g.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
        }
        if(req.getParameter("nombreGenero")!=null){
            g.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            g.setEstadoGenero(true);
        }
        else{
            g.setEstadoGenero(false);
        }
        try {
            gd.actualizar(g);
            System.out.println("Editar el registro de genero");
            visualizar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al editar del registro "+e.getMessage().toString());
        }
    }
}

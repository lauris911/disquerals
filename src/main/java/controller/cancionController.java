package controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cancion.cancionDao;
import model.cancion.cancionVo;

public class cancionController extends HttpServlet {
    
    cancionVo c=new cancionVo();
    cancionDao cd=new cancionDao();

    //DoGet
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.println("Entro al DoGet");
           String a=req.getParameter("accion");

           switch (a) {
            case "registrar":
            registrar(req,resp);
            break;            
            case "visualizar":
            visualizar(req,resp);
            break;
            case "eliminar":
            eliminar(req,resp);
            break;
            case "editar":
            editar(req,resp);
            break;
            case "estado":
            estado(req,resp);
            break;
           }
           
    }
 //DoPost
 @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     System.out.println("Entro al DoPost");
     String a=req.getParameter("accion");

     switch (a) {
             case "add":
             add(req,resp);
             break;
             case "edit":
             edit(req,resp);
             break;
     }
 }

    //Registrar
    private void registrar(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("views/cancion/insertarCancion.jsp").forward(req, resp); //Direccion de vista
            System.out.println("El Formulario ha sido abierto");
            } catch(Exception e){
            System.out.println("El Formulario NO fue abierto"+e.getMessage().toString());
            }
        }

    //Visualizar
    private void visualizar(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List <cancionVo> cancionesList=cd.listar();
            req.setAttribute("cancionesList" , cancionesList);
            req.getRequestDispatcher("views/cancion/listarCancion.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas en listar los datos"+e.getMessage().toString());
        }
    }
    
 //Eliminar
 private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idCancion")!=null){
        c.setIdCancion(Integer.parseInt(req.getParameter("idCancion"))); //Cambiar de String a Int
        } 
        try{
        cd.eliminar(c.getIdCancion());
        System.out.println("El Estado se cambio exitosamente");
        visualizar(req, resp);
        } catch (Exception e) {
        System.out.println("Hay problemas en listar los datos"+e.getMessage().toString()); //Cambiar de String a Int
        }
    }

       //Editar
       private void editar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idCancion") !=null){
        c.setIdCancion(Integer.parseInt(req.getParameter("idCancion"))); //Cambiar de String a Int
        }
        try{
            List <cancionVo> cancioesList=cd.listarcancion(c.getIdCancion());
            req.setAttribute("cancioesList", cancioesList);

            req.getRequestDispatcher("views/genero/editarCancion.jsp").forward(req, resp); //Direccion de vista
            System.out.println("Datos listados correctamente para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos"+e.getMessage().toString());
        }
    }

        //Estado
        private void estado(HttpServletRequest req, HttpServletResponse resp) {
            if(req.getParameter("idCancion") !=null){
                c.setIdCancion(Integer.parseInt(req.getParameter("idCancion"))); //Cambiar de String a Int
            }
            if(req.getParameter("estadoCancion") !=null){
                c.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));  //Cambiar de String a Boolean    
            } try{
                cd.estado(c.getEstadoCancion(), c.getIdCancion());
                System.out.println("El estado se ha cambiado exitosamente");
                visualizar(req, resp);
            } catch (Exception e) {
                System.out.println("Error en el cambio de estado"+e.getMessage().toString());
            }
        }
   //Metodos del DoPost

   private void add(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("nombreCancion")!=null){
    c.setNombreCancion(req.getParameter("nombreCancion"));
    }
    if(req.getParameter("fechaGrabacion")!=null){
        c.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
    if(req.getParameter("duracionCancion")!=null){
            c.setDuracionCancion(req.getParameter("duracionCancion"));
            }
     if(req.getParameter("estadoCancion")!=null){
        c.setEstadoCancion(true);
    } else {
        c.setEstadoCancion(false);
    } try{
        cd.registrar(c);
        System.out.println("Registro insertado correctamente");
        visualizar(req, resp);
    } catch (Exception e){
        System.out.println("Error en la insercion del registro"+e.getMessage().toString());
    }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("nombreCancion")!=null) {
        c.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            c.setFechaGrabacion(req.getParameter("fechaGrabacion"));
            }
        if(req.getParameter("duracionCancion")!=null){
                c.setDuracionCancion(req.getParameter("duracionCancion"));
                }
        if (req.getParameter("estadoGenero")!=null){
            c.setEstadoCancion(true);
        }
        try{
            cd.actualizar(c);
            System.out.println("Editar el registro del Cancion");
            visualizar(req, resp);
        } catch (Exception e) {
            System.out.println("Error al editar del registro"+e.getMessage().toString());
        }

        }

}

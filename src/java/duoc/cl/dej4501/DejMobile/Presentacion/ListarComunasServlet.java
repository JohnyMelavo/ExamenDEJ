/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Presentacion;
import duoc.cl.dej4501.DejMobile.Entity.Comunas;
import duoc.cl.dej4501.DejMobile.Persistencia.ComunasSessionBeans;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarComunasServlet", urlPatterns = {"/listarComunasServlet","/listarComunas"})
public class ListarComunasServlet extends HttpServlet {

    @EJB
    private ComunasSessionBeans objComunasSessionBeans;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        List<Comunas> listadocomunas=this.objComunasSessionBeans.getAllComunas();
        sesion.setAttribute("listaComunas", listadocomunas);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

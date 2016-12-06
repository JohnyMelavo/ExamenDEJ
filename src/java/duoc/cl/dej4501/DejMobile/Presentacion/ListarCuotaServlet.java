/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Presentacion;
import duoc.cl.dej4501.DejMobile.Entity.Cuota;
import duoc.cl.dej4501.DejMobile.Persistencia.CuotaSessionBeans;
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

@WebServlet(name = "ListarCuotaServlet", urlPatterns = {"/listarCuotaServlet","/listarCuota"})
public class ListarCuotaServlet extends HttpServlet {

    @EJB
    private CuotaSessionBeans objCuotaSessionBeans;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession sesion= request.getSession();
        List<Cuota> listadocuota=this.objCuotaSessionBeans.getAllCuota();
        sesion.setAttribute("listaCuota", listadocuota);
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

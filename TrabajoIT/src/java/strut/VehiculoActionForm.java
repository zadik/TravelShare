/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strut;

import dao.VehiculosDao;
import hibernate.Usuarios;
import hibernate.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author francisco
 */
public class VehiculoActionForm extends org.apache.struts.action.ActionForm {
    
     private Integer idVehiculo;
     private String nick;
     private String modelo;
     private String marca;
     private String descripcion;

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     *
     */
    public VehiculoActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        VehiculosDao vehiculosDao = new VehiculosDao();
         Usuarios u = (Usuarios) request.getSession().getAttribute("USER");
         List<Vehiculo> v = vehiculosDao.getListUser(u.getNick());
         
         if((getModelo()!=null && getModelo().trim().equals("")) || (getMarca()!=null && getMarca().trim().equals("")) || (getDescripcion()!=null && getDescripcion().trim().equals(""))){
             
         if (v == null) {
             v = new ArrayList<Vehiculo>();
         }
         request.setAttribute("lista", v);
             errors.add("falta", new ActionMessage("errors.falta"));
         }
          
        return errors;
    }
}

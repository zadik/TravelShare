/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package strut;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author manolo
 */
public class CheckLoginAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String ADMIN = "admin";
    private static final String USER = "user";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        String usuario=((CheckLoginActionForm)form).getNick();
        String clave=((CheckLoginActionForm)form).getPass();
        
        if (usuario.equals(clave)) {
            return mapping.findForward(ADMIN);
        } else {
            return mapping.findForward(USER);
    }
        
    }
}
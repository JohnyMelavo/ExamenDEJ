/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duoc.cl.dej4501.DejMobile.Persistencia;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
class ControladorExceptions extends Exception {

    public ControladorExceptions(String message) {
        super(message);
    }
}

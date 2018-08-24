package org.val.win.service.contract;


import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * Interface de la classe OuvrageServiceImpl
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface OuvrageService {

    /**
     * Obtenir une liste d'ouvrage
     * @return une liste d'ouvrage
     */
    @WebMethod
    Object[] getListOuvrage();

    /**
     * Obtenir la liste des ouvrages disponible
     * @return la liste des ouvrages disponible
     */
    @WebMethod
    Object[] getListOuvrageDispo();
}

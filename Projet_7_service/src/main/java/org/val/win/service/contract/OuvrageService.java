package org.val.win.service.contract;

import org.val.win.model.bean.Ouvrage;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * Interface de la classe OuvrageServiceImpl
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
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

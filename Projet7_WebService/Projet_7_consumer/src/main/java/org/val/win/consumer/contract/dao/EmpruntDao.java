package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.Emprunt;

import java.util.List;

public interface EmpruntDao {

    List<Emprunt> getListEmprunt(Integer id);

    Emprunt insertEmprunt(final Emprunt pEmprunt);

    void prolongerEmprunt(Integer id);

}

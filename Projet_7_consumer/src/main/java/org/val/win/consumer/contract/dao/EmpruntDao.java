package org.val.win.consumer.contract.dao;

import org.val.win.model.bean.Emprunt;

import java.util.List;

public interface EmpruntDao {

    List<Emprunt> getListEmprunt(Integer id);

    Emprunt emprunt(final Emprunt pEmprunt);

    void prolongerEmprunt(final Emprunt pEmprunt);

    void ChangerEtatEmprunt(final Emprunt pEmprunt);

}

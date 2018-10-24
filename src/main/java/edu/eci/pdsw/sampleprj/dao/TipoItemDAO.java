/**
 *
 * @author 2099190
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.TipoItem;

public interface TipoItemDAO {

    public void save(TipoItem it) throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;

}

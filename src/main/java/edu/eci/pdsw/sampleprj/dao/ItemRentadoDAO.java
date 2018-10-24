/**
 *
 * @author 2099190
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.ItemRentado;

public interface ItemRentadoDAO {

    public void save(ItemRentado it) throws PersistenceException;

    public ItemRentado load(int id) throws PersistenceException;

}

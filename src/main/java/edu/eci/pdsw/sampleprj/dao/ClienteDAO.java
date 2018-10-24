/**
 *
 * @author 2099190
 */
package edu.eci.pdsw.sampleprj.dao;

import edu.eci.pdsw.samples.entities.Cliente;

public interface ClienteDAO {

    public void save(Cliente it) throws PersistenceException;

    public Cliente load(long id) throws PersistenceException;

}

/**
 *
 * @author 2099190
 */
package edu.eci.pdsw.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.sampleprj.dao.*;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;

import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

    @Inject
    private ItemDAO itemDAO;
    private ClienteDAO clienteDAO;
    private ItemRentadoDAO itemRentadoDAO;
    private final int factorMulta = 2;
    
    @Override
    public int valorMultaRetrasoxDia(int itemId) {      
        Item loadedItem;
        int multaxDia = 0;
        try {
            loadedItem = itemDAO.load(itemId);
            multaxDia = (int) (loadedItem.getTarifaxDia() * factorMulta);         
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAlquilerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }          
        return multaxDia;              
        /*  
        } catch (org.apache.ibatis.exceptions.PersistenceException ex) {
            throw new PersistenceException("Error al calcular multa de item ", ex);
        }*/
        /*
        } catch (UnsupportedOperationException ex) {
            throw new PersistenceException("Error al calcular multa de item ", ex);
        }
        */       
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        Cliente loadedCliente = new Cliente();
        try {
            loadedCliente = clienteDAO.load(docu);
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAlquilerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadedCliente;
    }

    /**
     * @obj Consultar los items que tenga en su poder un cliente
     * @param idcliente identificador del cliente
     * @return el litado de detalle de los items rentados por el cliente
     * identificado con 'idcliente'
     * @throws ExcepcionServiciosAlquiler si el cliente no esta registrado
     */
    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        List<ItemRentado> loadedItemsCliente;
        try {
            loadedItemsCliente = clienteDAO.load(idcliente);
            //Cliente loadedCliente = clienteDAO.load(docu);
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAlquilerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadedItemsRentados;
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar el item " + id, ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item,
             int numdias) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

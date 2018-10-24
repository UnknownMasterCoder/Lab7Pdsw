package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;


import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2106913
 */
public interface ItemRentadoMapper {
    
    
    public List<ItemRentado> consultarItemsRentados();        
    
    public ItemRentado consultarItemRentado(int id);
    
    public void insertarItemRentado(ItemRentado ir);

        
}

/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.services.client;



import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.pdsw.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.pdsw.samples.entities.Item;
import edu.eci.pdsw.samples.entities.ItemRentado;
import edu.eci.pdsw.samples.entities.TipoItem;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        SqlSession sqlss = sessionfact.openSession();
        
        //Crear mappers y usarlo: 
        ClienteMapper cm = sqlss.getMapper(ClienteMapper.class);
        ItemMapper im = sqlss.getMapper(ItemMapper.class);       
        
        //Consultar todos los clientes
        System.out.println("Consultar Clientes:");
        System.out.println("--------------------------");
        System.out.println(cm.consultarClientes());
        System.out.println("--------------------------\n\n");
        
        //Consulta Cliente
        System.out.println("Consultar Cliente: "+9843);
        System.out.println("--------------------------");
        System.out.println(cm.consultarCliente(9843));
        System.out.println("--------------------------\n\n");
        
        //Agregar Item rentado a un cliente
        Date fechainicio = new Date(2018, 10, 02);
        Date fechafin = new Date(2018, 10, 12);
        cm.agregarItemRentadoACliente(2099190, 10, fechainicio, fechafin);
        //y Verificar que se haya agregado el item
        System.out.println("Agregar Item Rentado a Cliente: "+2099190);
        System.out.println("--------------------------");
        System.out.println(cm.consultarCliente(2099190));
        System.out.println("--------------------------\n\n");
        
        //Agrega un Item Nuevo
        TipoItem newTipoItem = new TipoItem(4, "Sci-Fi");
        Item newItem = new Item(newTipoItem, 12, "Star Wars", "Best movie ever", fechainicio, 10000, "Blue Ray", "Sci-Fi", new ArrayList<ItemRentado>());
        im.insertarItem(newItem);
        //Verificar funcionamiento con consulta
        System.out.println("Agregar Item Nuevo: "+12);
        System.out.println("--------------------------");
        System.out.println(im.consultarItem(12));
        System.out.println("--------------------------\n\n");
        
        //Consultar todos los items
        System.out.println("Consultar Items:");
        System.out.println("--------------------------");
        System.out.println(im.consultarItems());
        System.out.println("--------------------------\n\n");
        
        sqlss.commit();       
        sqlss.close();                
    }
}

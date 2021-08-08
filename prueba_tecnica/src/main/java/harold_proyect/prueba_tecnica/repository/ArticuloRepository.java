/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harold_proyect.prueba_tecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import harold_proyect.prueba_tecnica.model.Articulo;
import org.springframework.stereotype.Repository;
/**
 *
 * @author COMPUMAX
 */
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long>{
    
}

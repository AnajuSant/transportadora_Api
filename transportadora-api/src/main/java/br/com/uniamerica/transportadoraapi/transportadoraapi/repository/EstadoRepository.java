package br.com.uniamerica.transportadoraapi.transportadoraapi.repository;

import br.com.uniamerica.transportadoraapi.transportadoraapi.Estado;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}

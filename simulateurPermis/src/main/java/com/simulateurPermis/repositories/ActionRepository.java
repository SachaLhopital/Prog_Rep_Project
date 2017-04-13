package com.simulateurPermis.repositories;

import com.simulateurPermis.metier.Action;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sachouw on 13/04/2017.
 */
public interface ActionRepository extends JpaRepository<Action, Long> {

}

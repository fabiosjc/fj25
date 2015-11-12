package br.com.caelum.experimentos.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by fabio on 12/11/15.
 */
@MappedSuperclass
public class EntityId {

    @Id
    @GeneratedValue
    private Long id;
}

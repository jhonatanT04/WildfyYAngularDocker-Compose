package com.ejemplo.jakarta_postgres_app;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonaService {

    @PersistenceContext(unitName = "jakarta-postgres-appPersistenceUnit")
    private EntityManager em;

    public List<Persona> listar() {
        return em.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
    }

    public Persona guardar(Persona persona) {
        em.persist(persona);
        return persona;
    }

    public Persona actualizar(Persona persona) {
        return em.merge(persona);
    }

    public void eliminar(Long id) {
        Persona persona = em.find(Persona.class, id);
        if (persona != null) {
            em.remove(persona);
        }
    }

    public Persona obtener(Long id) {
        return em.find(Persona.class, id);
    }
}

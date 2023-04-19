package org.example.presistance.daos.impl;

import jakarta.persistence.EntityManager;
import org.example.presistance.daos.interfaces.ActorDao;
import org.example.presistance.entities.Actor;
import org.example.presistance.entities.Film;

import java.util.List;

public class ActorDaoImpl extends Crud<Actor, Integer> implements ActorDao {
    EntityManager entityManager;

    public ActorDaoImpl() {
        entityManager = super.getEntityManager();
    }
//    @Override
//    public void add(Actor actor) {
//
//        Language language = entityManager.find(Language.class, actor.getLanguage().getId());
//        actor.setLanguage(language);
//
//        if(actor.getOriginalLanguage().getId()!=null) {
//
//            Language orginalLanguage = entityManager.find(Language.class, actor.getOriginalLanguage().getId());
//            actor.setOriginalLanguage(orginalLanguage);
//        }
//        else
//            actor.setOriginalLanguage(null);
//        entityManager.getTransaction().begin();
//        entityManager.persist(actor);
//        entityManager.getTransaction().commit();
//
//    }
//
//    @Override
//    public void update(Actor editedActor) {
//        Film film = entityManager.find(Film.class, editedActor.getId());
//        Language language = entityManager.find(Language.class, editedActor.getLanguage().getId());
//        editedActor.setLanguage(language);
//
//        if(editedActor.getOriginalLanguage().getId()!=null) {
//
//            Language orginalLanguage = entityManager.find(Language.class, editedActor.getOriginalLanguage().getId());
//            editedActor.setOriginalLanguage(orginalLanguage);
//        }
//        else
//            editedActor.setOriginalLanguage(null);
//        entityManager.getTransaction().begin();
//        entityManager.merge(editedActor);
//        entityManager.getTransaction().commit();
//
//    }

    @Override
    public List<Film> getFilmsByActorId(int id) {

        return (List<Film>) entityManager.createQuery("select f from Film f join FilmActor fa where fa.id.actorId = ?1").
                setParameter(1, id).getResultList();

    }

    @Override
    public List<Actor> getActorByName(String name) {
        return (List<Actor>) entityManager.createQuery("from Actor a where a.firstName like ?1  or a.lastName like ?1").
                setParameter(1, "%" + name + "%").getResultList();
    }
}

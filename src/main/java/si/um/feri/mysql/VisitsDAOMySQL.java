package si.um.feri.mysql;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import si.um.feri.interfaces.IVisitDao;
import si.um.feri.vao.Visit;

import java.util.List;

@Stateless
public class VisitsDAOMySQL implements IVisitDao {

    @PersistenceContext(unitName = "hospital")
    EntityManager entityManager;
    @Override
    public Visit addVisit(Visit visit) {
        entityManager.merge(visit);
        return visit;
    }

    @Override
    public Visit findVisit(int id) {
        return entityManager.find(Visit.class, id);
    }

    @Override
    public int deleteVisit(int entityId) {
        Visit found = entityManager.find(Visit.class, entityId);
        if (found != null) {
            entityManager.remove(found);
            return found.getId();
        }
        return -1;
    }

//    @Override
//    public List<Visit> getAllVisits() {
//        TypedQuery<Visit> query = entityManager.createQuery("SELECT v from Visit v", Visit.class);
//        return query.getResultList();
//    }

//    @Override
//    public Visit updateVisit(Visit visit) {
//        Visit foundVisit = entityManager.find(Visit.class, visit.getId());
//        foundVisit.setDoctor(visit.getDoctor());
//        foundVisit.setDateAndTime(visit.getDateAndTime());
//        foundVisit.s(visit.getDetails());
//        foundVisit.setPrescribedMedications(visit.getPrescribedMedications());
//        foundVisit.setCompleted(visit.isCompleted());
//
//        entityManager.merge(foundVisit);
//        return visit;
//
//}
}

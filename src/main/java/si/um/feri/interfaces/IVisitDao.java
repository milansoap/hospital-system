package si.um.feri.interfaces;

import jakarta.ejb.Remote;
import si.um.feri.vao.Visit;

import java.util.List;

@Remote
public interface IVisitDao {
    Visit addVisit(Visit visit);
    Visit findVisit(int id);
    int deleteVisit(int id);
//    List<Visit> getAllVisits();
//    Visit updateVisit(Visit visit);


}

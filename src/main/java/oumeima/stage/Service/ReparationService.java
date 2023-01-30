package oumeima.stage.Service;

import oumeima.stage.Models.Reparation;

import java.util.List;

public interface ReparationService {

    public List<Reparation> getReparations();

    public Reparation getReparationById(Integer id);

    public Reparation insertReparation(Reparation r);

    public void updateReparation(Integer id, Reparation r);

    public void deleteReparation(Integer id);
}

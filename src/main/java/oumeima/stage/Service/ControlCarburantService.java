package oumeima.stage.Service;

import oumeima.stage.Models.ControlCarburant;

import java.util.List;

public interface ControlCarburantService {
    public List<ControlCarburant> getSuiviCarburants();

    public ControlCarburant getSuiviCarburantById(Integer imma);

    public ControlCarburant insertSuiviCarburant(ControlCarburant v);

    public void updateSuiviCarburant(Integer imma, ControlCarburant v);

    public void deleteSuiviCarburant(Integer imma);
}

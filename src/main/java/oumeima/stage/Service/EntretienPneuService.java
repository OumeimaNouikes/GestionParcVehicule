package oumeima.stage.Service;

import oumeima.stage.Models.EntretienPneu;
import oumeima.stage.Models.Vidange;

import java.util.List;

public interface EntretienPneuService {

    public List<EntretienPneu> getEntretienPneus();

    public EntretienPneu getEntretienPneuById(Integer id);

    public EntretienPneu insertEntretienPneu(EntretienPneu v);

    public void updateEntretienPneu(Integer id, EntretienPneu v);

    public void deleteEntretienPneu(Integer id);
}

package oumeima.stage.Service;


import oumeima.stage.Models.Vidange;

import java.util.List;

public interface VidangeService {


    public List<Vidange> getVidanges();

    public Vidange getVidangeById(Integer id);

    public Vidange insertVidange(Vidange v);

    public void updateVidange(Integer id, Vidange v);

    public void deleteVidange(Integer id);
}

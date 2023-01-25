package daos;

import com.mycompany.consultorach.entidades.Puesto;
import com.mycompany.consultorach.entidades.Puntuacion;
import dtos.PuestoDTO;
import java.util.List;
//import java.util.List;



public interface PuestoDao {
  
    public int SavePuesto(Puesto p);
    public Puesto Get(int id);
    public List<Integer> getCodigoAll();
    public List<String> getNombreAll();
    public List<Puesto> buscarPuestos(PuestoDTO dto);
    public int SavePuntuacion(Puntuacion puntuacion);
    public Puesto obtenerPuesto(Integer codigo);
    public Puesto unicoPuesto(String nombreEmpresa,String nombrePuesto);
}

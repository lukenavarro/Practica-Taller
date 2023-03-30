package practica01;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Reparacion {
    private Cliente c1;
    private Vehiculo v1;
    private String descripcion;
    private Date d1;
    private int tiempo;
    private double totalReparacion;

}

package practica01;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private int anio;
    private String color;
}

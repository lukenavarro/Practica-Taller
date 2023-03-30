package practica01;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Cliente {

    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;


}

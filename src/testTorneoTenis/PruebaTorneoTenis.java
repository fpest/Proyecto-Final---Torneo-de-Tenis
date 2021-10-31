
package testTorneoTenis;

import control.JugadorData;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.Jugador;

public class PruebaTorneoTenis {

    public static void main(String[] args) {

        try {
    
            Conexion conexion= new Conexion();
            JugadorData jd = new JugadorData(conexion);

            //Instancias de jugadores
            int idJug=0;
       
            Jugador j1 = new Jugador("Matias", "Perez", 18859544, LocalDate.of(2001, 11, 18), 1.85, 76, "Agresivo", true,true);
            Jugador j2 = new Jugador("Miguel", "Perez", 38451243, LocalDate.of(1997, 10, 10), 1.78, 70.4, "Voleador", true,true);
            Jugador j3 = new Jugador("Juan", "Perez", 45851263, LocalDate.of(1999, 5, 30), 1.96, 85.5, "Voleador", true,true);
            Jugador j4 = new Jugador("Juan", "Sosa", 35624789, LocalDate.of(1991, 10, 15), 1.79, 76.6, "Jugador de toda la cancha", false,true);
            Jugador j5 = new Jugador("Jose", "Fernandez", 36123759, LocalDate.of(1993, 6, 12), 1.84, 81.2, "Jugador de toda la cancha", false,true);
            Jugador j6 = new Jugador("Juan", "Ignacio", 37693221, LocalDate.of(1993, 9, 12), 1.76, 70, "Agresivo", false,true);
            Jugador j7 = new Jugador("Bruno", "Martinez", 33693221, LocalDate.of(1990, 4, 22), 1.75, 72, "Agresivo", true,true);
            
        
            //Guardar Jugador
            jd.guardarJugador(j1); 
            jd.guardarJugador(j2); 
            jd.guardarJugador(j3); 
            jd.guardarJugador(j4);
            jd.guardarJugador(j5); 
            jd.guardarJugador(j6); 
            jd.guardarJugador(j7);
            
            
            //Obtener lista de jugadores y mostrar
            
            System.out.println("Listamos los Jugadores:");
            ArrayList<Jugador> listaJugadores = (ArrayList)jd.obtenerJugador();
            for (Jugador jugadores : listaJugadores) {
                             System.out.println(jugadores.getNombre() + " - "+ jugadores.getApellido() +" - "+ jugadores.getDni());
            }
            System.out.println("");
            
            // Obtenemos el ID de un jugador para despues ir probando distintos metodos
            ArrayList<Jugador> jugadoresDNI = (ArrayList)jd.obtenerJugador("45851263");
            for (Jugador jugador : jugadoresDNI) {
            idJug = jugador.getIdJugador();
            System.out.println("El ID del jugador con DNI 45851263 es: " + idJug);
            }
            System.out.println("");
            
            //Desactivar Jugador
            System.out.println("Aqui desactivamos el jugador con id: " + idJug);
            jd.desactivarJugador(jd.buscarJugador(idJug));
            System.out.println("");
            
            //Buscar y Mostrar un Jugador
            System.out.println("Imprimimos los datos del jugador con id: " + idJug);
            System.out.println(jd.buscarJugador(idJug).toString());
            System.out.println("");
            
            //Activa un Jugador por ID
            System.out.println("Aqui activamos el jugador con id: " + idJug);
            jd.activarJugador(jd.buscarJugador(idJug));
            System.out.println("");
            
            //Buscar y Mostrar un Jugador
            System.out.println("Imprimimos los datos del jugador con id: " + idJug);
            System.out.println(jd.buscarJugador(idJug).toString());
            System.out.println("");
            
            //Buscar y Mostrar un Jugador
            System.out.println("Aqui buscamos e imprimimos datos del jugador con id: " + idJug);
            System.out.println(jd.buscarJugador(idJug).toString());
            System.out.println("");
            
            //Actualizar Jugador Le agregamos al nombre un segundo nombre Ramon
            
            System.out.println("Aqui Agregamos un segundo nombre -Ramon- al jugador con id: " + idJug);
            Jugador j10 = new Jugador(idJug, "Juan Ramon", "Perez", 45851263, LocalDate.of(1999, 5, 30), 1.96, 85.5, "Voleador", true,true);
            jd.actualizarJugador(j10);
            
            //Obtener lista de jugadores y mostrar
            //ArrayList<Jugador> listaJugadores = (ArrayList)jd.obtenerJugador();
            System.out.println("Listamos los Jugadores (Nombre , Apellido y DNI)");
            listaJugadores = (ArrayList)jd.obtenerJugador();
            for (Jugador jugadores : listaJugadores) {
                System.out.println(jugadores.getNombre() + " - "+ jugadores.getApellido() +" - "+ jugadores.getDni());
            }
            System.out.println("");
            
            //Obtener jugador buscado por el apellido PEREZ
            System.out.println("Buscamos un jugador con apellido Perez e imprimimos su ID");
            ArrayList<Jugador> jugadoresPerez = (ArrayList)jd.obtenerJugador("perez");
            for (Jugador jugador : jugadoresPerez) {
                System.out.println(jugador.getApellido()+" --> "+jugador.getIdJugador());
            }
            System.out.println("");
          
            //Buscar jugador por DNI
            System.out.println("Buscamos un jugador con DNI:33693221 e imprimimos su DNI");
            jugadoresDNI = (ArrayList)jd.obtenerJugador("33693221");
            for (Jugador jugador : jugadoresDNI) {
                System.out.println(jugador.getNombre()+" "+jugador.getApellido() +" - "+jugador.getDni());
            }
            System.out.println("");
            
            System.out.println("Finalmente borramos el Jugador con id: " + idJug);
            jd.borrarJugador(idJug);
            System.out.println("");
            
            System.out.println("Listamos los Jugadores:");
            listaJugadores = (ArrayList)jd.obtenerJugador();
            for (Jugador jugadores : listaJugadores) {
                System.out.println("ID : " + jugadores.getIdJugador() + " - " + jugadores.getApellido() +" - DNI:"+ jugadores.getDni());
            }
            System.out.println("");
            
            

    }   catch (ClassNotFoundException ex) {
            System.out.println("Error dentro de la Clase Prueba"+ ex);
    }
    
}
}
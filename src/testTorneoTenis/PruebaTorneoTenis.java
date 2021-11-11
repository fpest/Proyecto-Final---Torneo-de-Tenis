
package testTorneoTenis;

import control.*;
import java.time.LocalDate;
import java.util.ArrayList;
import modelo.Conexion;
import modelo.*;

public class PruebaTorneoTenis {

    public static void main(String[] args) {

        try {
    
            Conexion conexion= new Conexion();
            JugadorData jd = new JugadorData(conexion);
            TorneoData td = new TorneoData(conexion);
            EstadioData ed = new EstadioData(conexion);
            PartidoData pd = new PartidoData(conexion);
            PatrocinadorData pdd = new PatrocinadorData(conexion);
            PatrocinioData pcd = new PatrocinioData(conexion);
            /*
            Desde aqui Prueba de Jugador
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
            
            //Hasta aqui Prueba de Jugador
            */
            
            
            
            
            //Desde Aqui Prueba de Torneo
            /*
              //Instancias de Torneos
            Torneo t1 = new Torneo("Brasil Open", LocalDate.of(2021, 11, 1), LocalDate.of(2021, 11, 30), true);
            Torneo t2 = new Torneo("Indian Wells", LocalDate.of(2021, 10, 7), LocalDate.of(2021, 10, 17), true);
            Torneo t3 = new Torneo("Australia Open", LocalDate.of(2021, 1, 27), LocalDate.of(2021, 1, 27), true);
            Torneo t4 = new Torneo("Roland Garros", LocalDate.of(2021, 5, 30), LocalDate.of(2021, 6, 13), true);
            Torneo t5 = new Torneo("Cincinnati", LocalDate.of(2021, 8, 13), LocalDate.of(2021, 8, 21), true);
            
            
            //Guardar Torneo
            td.guardarTorneo(t1); td.guardarTorneo(t2); td.guardarTorneo(t3); td.guardarTorneo(t4); td.guardarTorneo(t5);
            //Buscar Torneo
            System.out.println(td.buscarTorneo(3).toString());
            //Desactivar Torneo
            td.desactivarTorneo(td.buscarTorneo(3));
            //Activar Torneo
            td.activarTorneo(td.buscarTorneo(2));
            //Obtener lista de torneos y mostrar
            ArrayList<Torneo> listaTorneos = (ArrayList)td.obtenerTodosLosTorneos();
            for (Torneo torneos : listaTorneos) {
                System.out.println(torneos.getNombre() +" - "+ torneos.getIdTorneo());
            }
            //Obtener lista de torneos en ROMA y mostrar
            ArrayList<Torneo> listaTorneosRoma = (ArrayList)td.obtenerTorneos("Roma");
            for (Torneo torneos : listaTorneosRoma) {
                System.out.println(torneos.toString());
            }
            // Hasta aqui Prueba Torneo
            */
       
            
            
            //Desde Aqui Prueba de EstadioData
            
            int idEstadio=0;
            
            //Instancias de Estadios
            Estadio e1 = new Estadio(24, "La Punta", "Funes 999",0, 2000,3000,40000,"Cemento",true);  
            Estadio e2 = new Estadio(25, "Guillermo Vilas", "Londres 999",0, 2000,3000,40000,"Ladrillo",true);
            Estadio e3 = new Estadio(26, "Roger", "Francia 999",0, 2000,3000,40000,"Cesped",true);
            Estadio e4 = new Estadio(27, "Agasi", "Londres 999",0, 2000,3000,40000,"Cemento",true);
            Estadio e5 = new Estadio(28, "Lendl", "Sidney 999",0, 2000,3000,40000,"Ladrillo",true);
            
            
            //Guardar Estadio
            ed.guardarEstadio(e1); 
            ed.guardarEstadio(e2); 
            ed.guardarEstadio(e3); 
            ed.guardarEstadio(e4); 
            ed.guardarEstadio(e5);
            
            //Obtener lista de estadios y mostrar
            System.out.println("Mostramos la lista de los Estadios");
            ArrayList<Estadio> listaEstadios = (ArrayList)ed.obtenerEstadio();
            for (Estadio estadio : listaEstadios) {
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo()  );
            idEstadio = estadio.getIdEstadio();
            }
            
            //Buscar Estadio
            System.out.println("");
            System.out.println("Se busca y se imprime datos de un Estadio");
            System.out.println(ed.buscarEstadio(idEstadio).toString());
            
            //Desactivar Torneo
            System.out.println("");
            System.out.println("Se desactiva un Estadio y se imprime la lista");
            ed.desactivarEstadio(e1);
            //Comprobamos si se desactivo
            for (Estadio estadio : listaEstadios) {
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo()  );
            idEstadio = estadio.getIdEstadio();
            }
            
            //Activar Torneo
            System.out.println("");
            System.out.println("Se Activa el mismo estadio y se imprime la lista");
            ed.activarEstadio(e1);
            //Comprobamos si se Activo
            for (Estadio estadio : listaEstadios) {
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo()  );
            idEstadio = estadio.getIdEstadio();
            }
            System.out.println("");
            System.out.println("Se imprimen los estadios que estan en Londres");
            ArrayList<Estadio> listaEstadioLondres = (ArrayList) ed.obtenerEstadio("Londres");
            for (Estadio estadio : listaEstadioLondres) {
                System.out.println(estadio.toString());
            }
            
            //Borramos un Estadio
            System.out.println("");
            System.out.println("Se borra un estadio y se imprime la lista");
            ed.borrarEstadio(idEstadio);
            //Comprobamos que se haya borrado
            for (Estadio estadio : listaEstadios) {
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo()  );
            idEstadio = estadio.getIdEstadio();
            }
            
            
            
            
            
            // Hasta aqui Prueba EstadioData
            
            
            
            
            
                 
                 ed.guardarEstadio(e1);
            
               //  Partido p1 = new Partido(1,188,191,1,LocalDate.of(2021,11,06),"Programado",0,"0","0",true);
            
               
                  
//               ArrayList<Partido> listaPartidos = (ArrayList) pd.obtenerPartido(1);
//            for (Partido partido : listaPartidos) {
//                System.out.println(partido.toString());
//            }
            System.out.println(ed.buscarEstadio(1).toString());
              
           
            
            
            

    }   catch (ClassNotFoundException ex) {
            System.out.println("Error dentro de la Clase Prueba"+ ex);
    }
    
}
}
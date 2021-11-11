
package testTorneoTenis;

import control.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
            PatrocinadorData pdd = new PatrocinadorData(conexion);
            
            PartidoData pd = new PartidoData(conexion);
            PatrocinioData pcd = new PatrocinioData(conexion);
            
            
            //Desde aqui Prueba de Jugador
            /*
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
            */
            //Hasta aqui Prueba de Jugador
            
            
            
            
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
            */
            // Hasta aqui Prueba Torneo
       
            
            
            //Desde Aqui Prueba de EstadioData
            /*
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
            idEstadio = estadio.getIdEstadio();
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo() + "El ID del estadio es : " + idEstadio) ;
            
            }
            
            //Buscar Estadio
            System.out.println("");
            System.out.println("Se busca y se imprime datos de un Estadio");
            System.out.println(ed.buscarEstadio(idEstadio).toString());
            
            //Desactivar Estadio
            System.out.println("");
            System.out.println("Se desactiva un Estadio y se imprime la lista");
            ed.desactivarEstadio(ed.buscarEstadio(idEstadio));
            //Comprobamos si se desactivo
            listaEstadios = (ArrayList)ed.obtenerEstadio();
            for (Estadio estadio : listaEstadios) {
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo()  );
            }
            
            //Activar Torneo
            System.out.println("");
            System.out.println("Se Activa el mismo estadio y se imprime la lista");
            ed.activarEstadio(ed.buscarEstadio(idEstadio));
            //Comprobamos si se Activo
            listaEstadios = (ArrayList)ed.obtenerEstadio();
            for (Estadio estadio : listaEstadios) {
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo()  );
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
            listaEstadios = (ArrayList)ed.obtenerEstadio();
            for (Estadio estadio : listaEstadios) {
                System.out.println("Estadio N: " + estadio.getNumeroIdentificador() +" - "+ estadio.getCategoria() + " - Activo: " + estadio.isActivo()  );
            }
            */
            // Hasta aqui Prueba EstadioData
            
            
            //Desde Aqui Prueba de PatrocinadorData
            /*
            int idPatrocinador=0;
            
            //Instancias de Patrocinadores
            Patrocinador p1 = new Patrocinador("Nike", true);
            Patrocinador p2 = new Patrocinador("Adidas", true);
            Patrocinador p3 = new Patrocinador("Babolad", true); 
            Patrocinador p4 = new Patrocinador("Rolex", true);
            
            
            //Guardar Patrocinador
            pdd.guardarPatrocinador(p1); 
            pdd.guardarPatrocinador(p2); 
            pdd.guardarPatrocinador(p3); 
            pdd.guardarPatrocinador(p4); 
            
            
            //Obtener lista de patrocinadores y mostrar
            System.out.println("Mostramos la lista de los Patrocinadores");
            ArrayList<Patrocinador> listaPatrocinadores = (ArrayList)pdd.obtenerPatrocinador();
            for (Patrocinador patrocinador : listaPatrocinadores) {
            idPatrocinador = patrocinador.getIdPatrocinador();
                System.out.println("Marca: " + patrocinador.getMarca() +" - Activo: " + patrocinador.isActivo() + " - El ID del patrocinador es : " + idPatrocinador) ;
            
            }
            
            //Buscar Patrocinador
            System.out.println("");
            System.out.println("Se busca y se imprime datos de un Patrocinador");
            System.out.println(pdd.buscarPatrocinador(idPatrocinador).toString());
            
            //Desactivar Patrocinador
            System.out.println("");
            System.out.println("Se desactiva un Patrocinador y se imprime la lista");
            pdd.desactivarPatrocinador(pdd.buscarPatrocinador(idPatrocinador));
            //Comprobamos si se desactivo
            listaPatrocinadores = (ArrayList)pdd.obtenerPatrocinador();
            for (Patrocinador patrocinador: listaPatrocinadores) {
                System.out.println("Marca: " + patrocinador.getMarca() +" - Activo: " + patrocinador.isActivo() + " - El ID del patrocinador es : " + patrocinador.getIdPatrocinador()) ;
            
            }
            
            //Activar Patrocinador
            System.out.println("");
            System.out.println("Se Activa el mismo Patrocinador y se imprime la lista");
            pdd.activarPatrocinador(pdd.buscarPatrocinador(idPatrocinador));
            //Comprobamos si se Activo
            listaPatrocinadores = (ArrayList)pdd.obtenerPatrocinador();
            for (Patrocinador patrocinador: listaPatrocinadores) {
                System.out.println("Marca: " + patrocinador.getMarca() +" - Activo: " + patrocinador.isActivo() + " - El ID del patrocinador es : " + patrocinador.getIdPatrocinador()) ;
            
            }
            
            //Borramos un Patrocinador
            System.out.println("");
            System.out.println("Se borra un patrocinador y se imprime la lista");
            pdd.borrarPatrocinador(idPatrocinador);
            //Comprobamos que se haya borrado
            listaPatrocinadores = (ArrayList)pdd.obtenerPatrocinador();
            for (Patrocinador patrocinador: listaPatrocinadores) {
                System.out.println("Marca: " + patrocinador.getMarca() +" - Activo: " + patrocinador.isActivo() + " - El ID del patrocinador es : " + patrocinador.getIdPatrocinador()) ;
            
            }
            */
            // Hasta aqui Prueba PatrocinadorData
            
            //Desde Aqui Prueba de PatrocinioData
            /*
            Patrocinador pt1=null;
            Jugador jp1=null;
            
            ArrayList<Patrocinador> listaPatrocinadores = (ArrayList)pdd.obtenerPatrocinador();
            for (Patrocinador patrocinador : listaPatrocinadores) {
            pt1 = patrocinador;
            }
            
            ArrayList<Jugador> listaJugadores = (ArrayList)jd.obtenerJugador();
            for (Jugador jugador : listaJugadores) {
            jp1 = jugador;
            }
                
            int idPatrocinio=0;
            
            //Instancias de Patrocinios
            Patrocinio pc1 = new Patrocinio(jp1, pt1, "Raqueta",LocalDate.of(2021, 8, 13),LocalDate.of(2022, 8, 13),true);
            Patrocinio pc2 = new Patrocinio(jp1, pt1, "Remera",LocalDate.of(2021, 8, 13),LocalDate.of(2022, 8, 13),true);
            
            
            //Guardar Patrocinador
            pcd.guardarPatrocinio(pc1); 
            pcd.guardarPatrocinio(pc2);
            
            //Obtener lista de patrocinio y mostrar
            System.out.println("Mostramos la lista de los Patrocinios");
            ArrayList<Patrocinio> listaPatrocinios = (ArrayList)pcd.obtenerPatrocinio();
            for (Patrocinio patrocinio : listaPatrocinios) {
            idPatrocinio = patrocinio.getIdPatrocinio();
                System.out.println("indumentaria: " + patrocinio.getIndumentaria() +" - Activo: " + patrocinio.isActivo() + " - El ID del patrocinio es : " + idPatrocinio) ;
            }
            
            //Buscar Patrocinio
            System.out.println("");
            System.out.println("Se busca y se imprime datos de un Patrocinio");
            System.out.println(pcd.buscarPatrocinio(idPatrocinio).toString());
            
            //Desactivar Patrocinio
            System.out.println("");
            System.out.println("Se desactiva un Patrocinio y se imprime la lista");
            pcd.desactivarPatrocinio(pcd.buscarPatrocinio(idPatrocinio));
            //Comprobamos si se desactivo
            listaPatrocinios = (ArrayList)pcd.obtenerPatrocinio();
            for (Patrocinio patrocinio : listaPatrocinios) {
            idPatrocinio = patrocinio.getIdPatrocinio();
                System.out.println("indumentaria: " + patrocinio.getIndumentaria() +" - Activo: " + patrocinio.isActivo() + " - El ID del patrocinio es : " + patrocinio.getIdPatrocinio()) ;
            
            }
            //Activar Patrocinio
            System.out.println("");
            System.out.println("Se Activa el mismo Patrocinio y se imprime la lista");
            pcd.activarPatrocinio(pcd.buscarPatrocinio(idPatrocinio));
            //Comprobamos si se Activo
            listaPatrocinios = (ArrayList)pcd.obtenerPatrocinio();
            for (Patrocinio patrocinio : listaPatrocinios) {
            idPatrocinio = patrocinio.getIdPatrocinio();
                System.out.println("indumentaria: " + patrocinio.getIndumentaria() +" - Activo: " + patrocinio.isActivo() + " - El ID del patrocinio es : " + patrocinio.getIdPatrocinio()) ;
            
            }
            
            //Borramos un Patrocinio
            System.out.println("");
            System.out.println("Se borra un patrocinio y se imprime la lista");
            pcd.borrarPatrocinio(idPatrocinio);
            //Comprobamos que se haya borrado
            listaPatrocinios = (ArrayList)pcd.obtenerPatrocinio();
            for (Patrocinio patrocinio : listaPatrocinios) {
            idPatrocinio = patrocinio.getIdPatrocinio();
                System.out.println("indumentaria: " + patrocinio.getIndumentaria() +" - Activo: " + patrocinio.isActivo() + " - El ID del patrocinio es : " + patrocinio.getIdPatrocinio()) ;
            
            }
            */
            // Hasta aqui Prueba PatrocinadorData
            
            
            //Desde Aqui Prueba de PartidoData
            /*            
            Torneo tpar1=null;
            Jugador[] jpar=new Jugador[10];
            Estadio epar1=null;
            
            
            ArrayList<Torneo> listaTorneos = (ArrayList)td.obtenerTodosLosTorneos();
            for (Torneo torneo : listaTorneos) {
            tpar1 = torneo;
            }
            
            ArrayList<Jugador> listaJugadores = (ArrayList)jd.obtenerJugador();
            int i=0;
            for (Jugador jugador : listaJugadores) {
            
                jpar[i] = jugador;
            i++;
            }
            
            ArrayList<Estadio> listaEstadios = (ArrayList)ed.obtenerEstadio();
            for (Estadio estadio : listaEstadios) {
            epar1 = estadio;
            }
            
            int idPartido=0;
        
             
            //Instancias de Patrocinios
            Partido par1 = new Partido(tpar1,jpar[0],jpar[1],epar1,LocalDateTime.of(2022,02,3,6,30,40,50000),"Programado",jpar[1],"61-62","Semi Final",true);
            Partido par2 = new Partido(tpar1,jpar[2],jpar[3],epar1,LocalDateTime.of(2021,12,3,6,30,40,50000),"Programado",jpar[3],"64-64","Final",true);
            
            //Guardar Patrocinador
            pd.guardarPartido(par1); 
            pd.guardarPartido(par2);
            
            //Obtener lista de partido y mostrar
            System.out.println("Mostramos la lista de los Partidos");
            ArrayList<Partido> listaPartidos = (ArrayList)pd.obtenerPartido(1);
            for (Partido partido : listaPartidos) {
            idPartido = partido.getIdPartido();
                System.out.println("Torneo: " + partido.getTorneo().getNombre() +" - Estadio: " + partido.getEstadio().getNumeroIdentificador() + " - El ID del partido es : " + partido.getIdPartido()) ;
            
            }
            
            //Buscar Partido
            System.out.println("");
            System.out.println("Se busca y se imprime datos de un Partido");
            System.out.println(pd.buscarPartido(idPartido).toString());
            
            //Desactivar Partido
            System.out.println("");
            System.out.println("Se desactiva un Partido y se imprime la lista");
            pd.desactivarPartido(pd.buscarPartido(idPartido));
            //Comprobamos si se desactivo
            listaPartidos = (ArrayList)pd.obtenerPartido(1);
            for (Partido partido : listaPartidos) {
            idPartido = partido.getIdPartido();
                System.out.println("Torneo: " + partido.getTorneo().getNombre() +" Activo: " + partido.isActivo() + " - Estadio: " + partido.getEstadio().getNumeroIdentificador() + " - El ID del partido es : " + partido.getIdPartido()) ;
            
            }
            
            listaPartidos = (ArrayList)pd.obtenerPartido(0);
            for (Partido partido : listaPartidos) {
            idPartido = partido.getIdPartido();
                System.out.println("Torneo: " + partido.getTorneo().getNombre() +" Activo: " + partido.isActivo() + " - Estadio: " + partido.getEstadio().getNumeroIdentificador() + " - El ID del partido es : " + partido.getIdPartido()) ;
            
            }
            
            //Activar Partido
            System.out.println("");
            System.out.println("Se Activa el mismo Partido y se imprime la lista");
            pd.activarPartido(pd.buscarPartido(idPartido));
            //Comprobamos si se Activo
            listaPartidos = (ArrayList)pd.obtenerPartido(1);
            for (Partido partido : listaPartidos) {
            idPartido = partido.getIdPartido();
                System.out.println("Torneo: " + partido.getTorneo().getNombre() +" Activo: " + partido.isActivo() + " - Estadio: " + partido.getEstadio().getNumeroIdentificador() + " - El ID del partido es : " + partido.getIdPartido()) ;
            }
            listaPartidos = (ArrayList)pd.obtenerPartido(0);
            for (Partido partido : listaPartidos) {
            idPartido = partido.getIdPartido();
                System.out.println("Torneo: " + partido.getTorneo().getNombre() +" Activo: " + partido.isActivo() + " - Estadio: " + partido.getEstadio().getNumeroIdentificador() + " - El ID del partido es : " + partido.getIdPartido()) ;
            
            }
            //Borramos un Partido
            System.out.println("");
            System.out.println("Se borra un partido y se imprime la lista");
            pd.borrarPartido(idPartido);
            //Comprobamos que se haya borrado
            listaPartidos = (ArrayList)pd.obtenerPartido(1);
            for (Partido partido : listaPartidos) {
            idPartido = partido.getIdPartido();
                System.out.println("Torneo: " + partido.getTorneo().getNombre() +" Activo: " + partido.isActivo() + " - Estadio: " + partido.getEstadio().getNumeroIdentificador() + " - El ID del partido es : " + partido.getIdPartido()) ;
            
            }
            */
            // Hasta aqui Prueba PartidoData
            
            
            
            
            

    }   catch (ClassNotFoundException ex) {
            System.out.println("Error dentro de la Clase Prueba"+ ex);
    }
    
}
}
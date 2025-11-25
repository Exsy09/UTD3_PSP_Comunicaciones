package psp.coms.clienteservidor.datagrama;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Cliente {

    public static void main(String[] args){

        int PUERTO = 6789;
        int BUFFER_SIZE = 1000;
        System.out.println("Soy el cliente y envio datagrama");

        String mensaje = "Hola soy cliente";

        try (DatagramSocket socketUPD = new DatagramSocket()) {
            byte [] mensajeBytes = mensaje.getBytes(StandardCharsets.UTF_8); // StandardCharsets.UTF8 hace que puedas añadir la letra "Ñ"
            InetAddress hostServidor = InetAddress.getByName("localhost");

            DatagramPacket peticion = new DatagramPacket(mensajeBytes, mensajeBytes.length, hostServidor, PUERTO);
            socketUPD.send(peticion);

            byte[] bufer = new byte[BUFFER_SIZE];
            DatagramPacket respuesta = new DatagramPacket(bufer, BUFFER_SIZE);
            socketUPD.receive(respuesta);

            System.out.println("Respuesta: " + respuesta.getData());

        } catch (SocketException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
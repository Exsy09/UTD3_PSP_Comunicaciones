package psp.coms;

import java.net.*;
import java.util.Arrays;
import java.util.Enumeration;

public class HostInfo {
    public static void main(String[] args){

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Nombre del host local: " + localHost.getHostName());
            System.out.println("Dirección IP local: " + localHost.getHostAddress());

            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Nombre del host: " + localHost.getHostName());
            System.out.println("Direccion IP remota: " + localHost.getHostAddress());

        } catch (UnknownHostException e){
            throw new RuntimeException(e);
        }

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()){
                NetworkInterface ni = interfaces.nextElement();

                System.out.println("Nombre de la interfaz: " + ni.getName());
                System.out.println("Interfaz activa: " + ni.isUp());
                System.out.println("MAC adress: " + Arrays.toString(ni.getHardwareAddress()));
                // recorremos todas las IPs
                Enumeration<InetAddress> direcciones = ni.getInetAddresses();
                // recorremos el enumeration
                while (direcciones.hasMoreElements()){
                    InetAddress ip = direcciones.nextElement();
                    System.out.println("\tDireccion IP: " + ip.getHostAddress());
                }
            }
        } catch (SocketException e){
            throw new RuntimeException(e);
        }
    }
}

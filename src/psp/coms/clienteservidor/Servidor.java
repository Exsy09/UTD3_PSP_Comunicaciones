package psp.coms.clienteservidor;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args){

        ServerSocket servidor = null;
        Socket cliente = null;
        int numCliente = 0;
        int PUERTO = 5000;

        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Soy el servidor y  empiezo a escuchar peticiones del puerto: " + PUERTO);

            do {
                cliente = servidor.accept();
                numCliente++;
                System.out.println("\tLlega el cliente: " + cliente);

                DataOutputStream os = new DataOutputStream(cliente.getOutputStream());
                os.writeUTF();
            }
        }
    }
}

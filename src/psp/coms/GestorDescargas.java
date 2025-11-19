package psp.coms;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class GestorDescargas {

    public void descargarArchivos(String url_descarga, String nombreFichero){
        System.out.println("Descargando..." + url_descarga);

        try{
            URL url = new URL(url_descarga);
            InputStream is = url.openStream();
            InputStreamReader reader = new InputStreamReader();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
            FileWriter escritorFichero = new FileWriter(nombreFichero);

            String linea;
            while (linea = bReader.readLine()) != null) {
                escritorFichero.write(linea);
            }
            escritorFichero.close();
            bReader.close();
            is.close();

        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } finally {
            try {
                escritorFichero.close();
                bReader.close();
                is.close();
            } catch (IOException e){
                throw new RuntimeException(e);
            }

        }
        }

        public static void main(String[] args){
            GestorDescargas gd = new GestorDescargas();
            String url = "https://www.bbc.com/robots.txt";
            gd.descargarArchivos(url, "descarga.txt");
        }

}

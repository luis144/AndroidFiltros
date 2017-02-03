package example.edu.androidfiltros;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

/**
 * Created by upam on 03/02/17.
 */

public class Filtros {

    public Bitmap greyScale(Bitmap bitmap){
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel=0;
        int r=0;
        int g=0;
        int b=0;
        int a=0;
        //se declara la variable grey donde de descargara la sumatoria de los pixeles
        int grey=0;
        //se recorre la imagen de origen ancho por alto
        for (int x=0;x<bitmap.getWidth();x++){
            for(int y=0;y<bitmap.getHeight();y++){
                // se obtiene el pixel segun las coordenadas
                pixel=bitmap.getPixel(x,y);
                //se obtienen los canales del pixel por medio de corrimiento
                a=(pixel>>>24) & 0xff;
                r=(pixel>>16) & 0xff;
                g=(pixel>>8) & 0xff;
                b=pixel & 0xff;
                //-----Inicio
                //se realiza la operacion por pixel
                grey=(r+g+b)/3;
                //-------fin
                //se vuelve a codificar el pixel
                pixel=((a<<24)|(grey<<16)|(grey<<8)|grey);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x,y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }


    public Bitmap invert(Bitmap bitmap){
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(),bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel=0;
        int r=0;
        int g=0;
        int b=0;
        int a=0;

        //se recorre la imagen de origen ancho por alto
        for (int x=0;x<bitmap.getWidth();x++){
            for(int y=0;y<bitmap.getHeight();y++){
                // se obtiene el pixel segun las coordenadas
                pixel=bitmap.getPixel(x,y);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se obtienen los canales del pixel por medio de corrimiento
                a=(pixel>>>24) & 0xff;
                r=(pixel>>16) & 0xff;
                g=(pixel>>8) & 0xff;
                b=pixel & 0xff;

                //Log.d("Canales","A"+a+"R"+r+"G"+g+"B"+b);

                //-----Inicio
                //se realiza la operacion por pixel
                r=255-r;
                g=255-g;
                b=255-b;
                //-------fin
                //Log.d("Canales despues oper","A"+a+"R"+r+"G"+g+"B"+b);

                //se vuelve a codificar el pixel
                pixel=((a<<24)|(r<<16)|(g<<8)|b);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x,y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }

}

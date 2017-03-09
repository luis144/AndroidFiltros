package example.edu.androidfiltros;

import android.graphics.Bitmap;

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

    public Bitmap brillo(Bitmap bitmap, int cons) {
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel = 0;

        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;

        if (cons < 0) {
            cons = -10;
        } else if (cons > 255) {
            cons = 10;
        }
        //se recorre la imagen de origen ancho por alto
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                // se obtiene el pixel segun las coordenadas
                pixel = bitmap.getPixel(x, y);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se obtienen los canales del pixel por medio de corrimiento
                a = (pixel >>> 24) & 0xff;
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = pixel & 0xff;

                //Log.d("Canales","A"+a+"R"+r+"G"+g+"B"+b);

                //-----Inicio
                //se realiza la operacion por pixel


                r = r + cons >= 255 ? 255 : r + cons;
                g = g + cons >= 255 ? 255 : g + cons;
                b = b + cons >= 255 ? 255 : b + cons;


                //-------fin
                //Log.d("Canales despues oper","A"+a+"R"+r+"G"+g+"B"+b);

                //se vuelve a codificar el pixel
                pixel = ((a << 24) | (r << 16) | (g << 8) | b);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x, y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }


    public Bitmap MODRGB(Bitmap bitmap, int r2, int g2, int b2) {
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;


        //se recorre la imagen de origen ancho por alto
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                // se obtiene el pixel segun las coordenadas
                pixel = bitmap.getPixel(x, y);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se obtienen los canales del pixel por medio de corrimiento
                a = (pixel >>> 24) & 0xff;
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = pixel & 0xff;


                //Log.d("Canales","A"+a+"R"+r+"G"+g+"B"+b);

                //-----Inicio
                //se realiza la operacion por pixel
                r = r + r2 >= 255 ? 255 : r + r2 <= 0 ? 0 : r + r2;
                g = g + g2 >= 255 ? 255 : g + g2 <= 0 ? 0 : g + g2;
                b = b + b2 >= 255 ? 255 : b + b2 <= 0 ? 0 : b + b2;


                //-------fin
                //Log.d("Canales despues oper","A"+a+"R"+r+"G"+g+"B"+b);

                //se vuelve a codificar el pixel
                pixel = ((a << 24) | (r << 16) | (g << 8) | b);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x, y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }

    public Bitmap EdgeDetect(Bitmap bitmap, int umbral) {
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel = 0;
        //C1
        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;
        //C2
        int r2 = 0;
        int g2 = 0;
        int b2 = 0;
        int a2 = 0;
        //C3
        int r3 = 0;
        int g3 = 0;
        int b3 = 0;
        int a3 = 0;

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;


        //se recorre la imagen de origen ancho por alto
        for (int x = 0; x < bitmap.getWidth() - 2; x++) {
            for (int y = 0; y < bitmap.getHeight() - 2; y++) {
                // se obtiene el pixel segun las coordenadas

                pixel = bitmap.getPixel(x, y);
                c1 = bitmap.getPixel(x, y);

                c2 = bitmap.getPixel(x + 1, y);
                c3 = bitmap.getPixel(x, y + 1);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se obtienen los canales del pixel por medio de corrimientoº


                a = (c1 >>> 24) & 0xff;
                r = (c1 >> 16) & 0xff;
                g = (c1 >> 8) & 0xff;
                b = c1 & 0xff;

                a2 = (c2 >>> 24) & 0xff;
                r2 = (c2 >> 16) & 0xff;
                g2 = (c2 >> 8) & 0xff;
                b2 = c2 & 0xff;

                a3 = (c3 >>> 24) & 0xff;
                r3 = (c3 >> 16) & 0xff;
                g3 = (c3 >> 8) & 0xff;
                b3 = c3 & 0xff;


                int D1 = (int) Math.pow(r - r2, 2.0) + (int) Math.pow(g - g2, 2.0) + (int) Math.pow(b - b2, 2.0);
                D1 = (int) Math.sqrt(D1);
                int D2 = (int) Math.pow(r - r3, 2.0) + (int) Math.pow(g - g3, 2.0) + (int) Math.pow(b - b3, 2.0);
                D2 = (int) Math.sqrt(D2);

                if (D1 >= umbral || D2 >= umbral) {
                    D1 = 255;
                } else {
                    D1 = 0;
                }
                //Log.d("Canales","A"+a+"R"+r+"G"+g+"B"+b);

                //-----Inicio
                //se realiza la operacion por pixel

                //-------fin
                //Log.d("Canales despues oper","A"+a+"R"+r+"G"+g+"B"+b);

                //se vuelve a codificar el pixel
                pixel = ((a << 24) | (D1 << 16) | (D1 << 8) | D1);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x, y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }


    public Bitmap contraste(Bitmap bitmap, int cons) {
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel = 0;

        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;

        if (cons < 0) {
            cons = 0;
        } else if (cons > 255) {
            cons = 255;
        }
        //se recorre la imagen de origen ancho por alto
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                // se obtiene el pixel segun las coordenadas
                pixel = bitmap.getPixel(x, y);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se obtienen los canales del pixel por medio de corrimiento
                a = (pixel >>> 24) & 0xff;
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = pixel & 0xff;

                //Log.d("Canales","A"+a+"R"+r+"G"+g+"B"+b);

                //-----Inicio
                //se realiza la operacion por pixel

                double tet = cons / (Math.PI * 180);

                r = (int) ((r - 128) * Math.tan(tet) + 180) >= 255 ? 255 : (int) ((r - 128) * Math.tan(tet) + 180);

                g = (int) ((g - 128) * Math.tan(tet) + 180) >= 255 ? 255 : (int) ((g - 128) * Math.tan(tet) + 180);
                b = (int) ((b - 128) * Math.tan(tet) + 180) >= 255 ? 255 : (int) ((b - 128) * Math.tan(tet) + 180);


                //-------fin
                //Log.d("Canales despues oper","A"+a+"R"+r+"G"+g+"B"+b);

                //se vuelve a codificar el pixel
                pixel = ((a << 24) | (r << 16) | (g << 8) | b);
                //Log.d("Pixel codificado","X: "+x+"Y: "+y+"Pixel: "+pixel);
                //se agrega el pixel en el bitmap destino
                bmp.setPixel(x, y, pixel);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }

    public Bitmap Gamma(Bitmap bitmap) {
        //crear una copia de bitmap para modificar la imagen origen
        // la imagen origen no puede ser modificada por lo tanto se crea una copia
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        //se declaran las variables a utilizar para vaciar el pixel y los canales

        int pixel = 0;
        int r = 0;
        int g = 0;
        int b = 0;
        int a = 0;
        int cons = 10;
        int r2 = 4;
        int g2 = 3;
        int b2 = 2;
        if (r2 < .2 || r2 > 5) {
            r2 = 1;
        }
        if (g2 < .2 || g2 > 5) {
            g2 = 1;
        }
        if (b2 < .2 || b2 > 5) {
            b2 = 1;
        }


        //se declara la variable grey donde de descargara la sumatoria de los pixeles
        int grey = 0;
        //se recorre la imagen de origen ancho por alto
        for (int x = 0; x < bitmap.getWidth(); x++) {
            for (int y = 0; y < bitmap.getHeight(); y++) {
                // se obtiene el pixel segun las coordenadas
                pixel = bitmap.getPixel(x, y);
                //se obtienen los canales del pixel por medio de corrimiento
                //-----Inicio
                //se realiza la operacion por pixel
                a = (pixel >>> 24) & 0xff;
                r = (pixel >> 16) & 0xff;
                g = (pixel >> 8) & 0xff;
                b = pixel & 0xff;


                for (int j = 0; j < 256; j++) {

                    int[] cont = new int[0];
                    cont[j] = (int) Math.min(255, Math.round(255 * Math.pow(1 / r2, (cont[y] / 255)) + 0.5));
                    g = (int) Math.min(255, Math.round(255 * Math.pow(1 / g2, (cons / 255)) + 0.5));
                    b = (int) Math.min(255, Math.round(255 * Math.pow(1 / b2, (cons / 255)) + 0.5));
                }


                //-------fin
                //se vuelve a codificar el pixel y se termina


                //se agrega el pixel en el bitmap destino
                pixel = ((a << 24) | (r << 16) | (g << 8) | b);
            }
        }
        //retorna el bitmap final para ser renderizado por imageView
        return bmp;
    }


   /* public void grabar(Bitmap bitmap) {


        try {
            File tarjeta = Environment.getExternalStorageDirectory();

            Toast.makeText(this,tarjeta.getAbsolutePath(),Toast.LENGTH_LONG).show();

            File file = new File(tarjeta.getAbsolutePath(), nomarchivo);
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream(file));
            osw.write(bitmap);
            osw.flush();
            osw.close();



        } catch (IOException ioe) {

        }*/







}

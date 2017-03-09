package example.edu.androidfiltros;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Activity2 extends AppCompatActivity {
    int Rojo = 0, Verde = 0, Azul = 0;
    SeekBar seekBar1, seekBar2, seekBar3;
    BitmapDrawable bitmapDrawable;

    Bitmap bmp;
    private ImageView imageView;
    private Filtros filtros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        imageView = (ImageView) findViewById(R.id.imageView);
        filtros = new Filtros();
        bitmapDrawable = (BitmapDrawable) imageView.getDrawable();

        seekBar1 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar5);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar6);

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Rojo = progress;
                bmp = filtros.MODRGB(bitmapDrawable.getBitmap(), Rojo, Verde, Azul);
                imageView.setImageBitmap(bmp);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progres, boolean fromUser) {
                Verde = progres;

                bmp = filtros.MODRGB(bitmapDrawable.getBitmap(), Rojo, Verde, Azul);
                imageView.setImageBitmap(bmp);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progre, boolean fromUser) {
                Azul = progre;
                bmp = filtros.MODRGB(bitmapDrawable.getBitmap(), Rojo, Verde, Azul);
                imageView.setImageBitmap(bmp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}

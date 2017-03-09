package example.edu.androidfiltros;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    BitmapDrawable bitmapDrawable;
    private SeekBar seekBar, seekBar2, seekBar3;
    private ImageView imageView;
    private Filtros filtros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imagen);
        filtros = new Filtros();

        bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
        //Bitmap bmp=filtros.greyScale(bitmapDrawable.getBitmap());
        //Bitmap bmp=filtros.invert(bitmapDrawable.getBitmap());
        //Bitmap bmp=filtros.brillo(bitmapDrawable.getBitmap(),100);
        //Bitmap bmp=filtros.MODRGB(bitmapDrawable.getBitmap());
        //Bitmap bmp= filtros.contraste(bitmapDrawable.getBitmap());
        Bitmap bmp = filtros.Gamma(bitmapDrawable.getBitmap());

        imageView.setImageBitmap(bmp);


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bitmap bmp = filtros.contraste(bitmapDrawable.getBitmap(), progress);
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
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                Bitmap bmp = filtros.brillo(bitmapDrawable.getBitmap(), progress);
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
            public void onProgressChanged(SeekBar seekBar3, int progress, boolean fromUser) {
                Bitmap bmp = filtros.EdgeDetect(bitmapDrawable.getBitmap(), progress);
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


    //seekbar2,3,4


    public void invert(View v) {

        Bitmap bmp=filtros.invert(bitmapDrawable.getBitmap());
        imageView.setImageBitmap(bmp);

    }

    public void grey(View v) {

        Bitmap bmp = filtros.greyScale(bitmapDrawable.getBitmap());
        imageView.setImageBitmap(bmp);
    }

    public void main2(View v) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }


}







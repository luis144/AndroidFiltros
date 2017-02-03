package example.edu.androidfiltros;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Filtros filtros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView) findViewById(R.id.imagen);
        filtros=new Filtros();

        BitmapDrawable bitmapDrawable=(BitmapDrawable) imageView.getDrawable();
        Bitmap bmp=filtros.greyScale(bitmapDrawable.getBitmap());
        imageView.setImageBitmap(bmp);

    }


}

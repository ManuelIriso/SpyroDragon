package dam.pmdm.spyrothedragon.ui;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dam.pmdm.spyrothedragon.MainActivity;
import dam.pmdm.spyrothedragon.R;

public class PantallaBienvenida extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_bienvenida);
        ImageView iv = findViewById(R.id.spyroFlying);
        aparicionImagen(iv);
        ImageButton boton = findViewById(R.id.btnStart);
        boton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent= new Intent(PantallaBienvenida.this, MainActivity.class);
                startActivity(intent);
                MediaPlayer mp = MediaPlayer.create(v.getContext(), R.raw.up);
                mp.start();
            }
        });

    }

    public void aparicionImagen(ImageView image){
        final ValueAnimator animacion = ValueAnimator.ofFloat(0.1f, 1.5f);
        animacion.setDuration(4000);
        animacion.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                image.setScaleX((Float) animation.getAnimatedValue());
                image.setScaleY((Float) animation.getAnimatedValue());

            }
        });
        animacion.start();
    }
}

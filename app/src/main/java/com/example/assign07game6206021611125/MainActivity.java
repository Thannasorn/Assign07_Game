package com.example.assign07game6206021611125;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int res_iv[] = {R.id.imageView1, R.id.imageView2, R.id.imageView3,
            R.id.imageView4, R.id.imageView5, R.id.imageView6,
            R.id.imageView7, R.id.imageView8, R.id.imageView9};
    int res_image[] = {R.drawable.apple, R.drawable.apricot,
            R.drawable.banana, R.drawable.cherry,
            R.drawable.mango, R.drawable.pear,
            R.drawable.strawberry, R.drawable.watermalon};
    int fg = R.drawable.tree;
    ImageView iv[] = new ImageView[res_iv.length];
    Button startButton;
    int iNum = -1, oldNum = -1, iImage = -1;
    CountDownTimer timer1;
    Random rnd = new Random();
    int Max = res_image.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int n = 0; n < iv.length; n++) {
            iv[n] = (ImageView) findViewById(res_iv[n]);
            iv[n].setImageResource(fg);
        }
        timer1 = new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                if (oldNum != -1)
                    iv[oldNum].setImageResource(fg);

                iNum = rnd.nextInt(Max);
                iImage = rnd.nextInt(Max);
                iv[iNum].setImageResource(res_image[iImage]);
                oldNum = iNum;
            }

            public void onFinish() {
                iv[iNum].setImageResource(fg);
                startButton.setEnabled(true);
            }
        };
        startButton = (Button) findViewById(R.id.buttonStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                timer1.start();
                startButton.setEnabled(false);
            }
        });
    }
}
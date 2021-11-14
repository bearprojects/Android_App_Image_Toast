package com.project.image_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    ImageView imageView;
    Toast toast;

    int[] bookId = new int[]{R.drawable.dog1,R.drawable.dog2,R.drawable.dog3};
    int p = 0;
    int count = bookId.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("ImageView_Toast");

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        imageView = (ImageView)findViewById(R.id.imageView);

        btn1.setOnClickListener(btnClick);
        btn2.setOnClickListener(btnClick);

        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(p == 0) {
                    if(toast != null)
                        toast.cancel();

                    toast = Toast.makeText(MainActivity.this,"dog：1", toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(p == 1) {
                    if(toast != null)
                        toast.cancel();

                    toast = Toast.makeText(MainActivity.this,"dog：2", toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(p == 2) {
                    if(toast != null)
                        toast.cancel();

                    toast = Toast.makeText(MainActivity.this,"dog：3", toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
                return false;
            }
        });
    }

    Button.OnClickListener btnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                //下一張
                case R.id.btn1:
                    p++;
                    if(p == count){
                        p = 0;
                    }
                    imageView.setImageResource(bookId[p]);
                    break;
                //上一張
                case  R.id.btn2:
                    p--;
                    if(p < 0){
                        p = count - 1;
                    }
                    imageView.setImageResource(bookId[p]);
            }
        }
    };
}

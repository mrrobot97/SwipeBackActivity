package me.mrrobot97.swipeback;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends SwipeBackActivity {
    private RelativeLayout mRelativeLayout;
    private Button mButton;
    private Random mRandom;
    private TextView mTextView;
    private int pagenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mRelativeLayout= (RelativeLayout) findViewById(R.id.relative_layout);
        Intent intent=getIntent();
        if(intent!=null){
            pagenum=intent.getIntExtra("pagenum",0);
        }else{
            pagenum=0;
        }
        mTextView= (TextView) findViewById(R.id.page_text);
        mTextView.setText(mTextView.getText().toString()+pagenum);
        mButton= (Button) findViewById(R.id.add_bt);
        mRandom=new Random();
        int color= Color.argb(255,mRandom.nextInt(256),mRandom.nextInt(256),mRandom.nextInt(256));
        mRelativeLayout.setBackgroundColor(color);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                intent.putExtra("pagenum",pagenum+1);
                startActivity(intent);
            }
        });

    }
}

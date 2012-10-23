package com.fhx.app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;

@TargetApi(14)
public class FHXAppActivity extends Activity {
	public static final String TAG = "FHXAppActivity";
	
    public Integer[] imageIds = {
            R.drawable.hong_1, R.drawable.gong_1, R.drawable.ji_1, 
            R.drawable.lu_1, R.drawable.wei_1, R.drawable.ba_1,
            R.drawable.yi_1, R.drawable.tou_1, R.drawable.zuan_1, 
            R.drawable.dao_1, R.drawable.di_2, R.drawable.di_1, 
            R.drawable.xia_1
    };

    private GridLayout addZone;
    private GridView dropZone;
    
    private List<ImageButton> wordList = new ArrayList<ImageButton>();
    private AtomicInteger id = new AtomicInteger(0);
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Log.i(TAG, "FHXApp started...");
        
        this.addZone = (GridLayout) findViewById(R.id.add_zone); 
        Button addButton = (Button) findViewById(R.id.add_button);
        
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	if (id.get() >= imageIds.length) {
            		Log.i(TAG, "all words are already in add zone.");
            		
            		return ;
            	}
            	
    	    	ImageButton newButton = new ImageButton(FHXAppActivity.this);
    	    	newButton.setImageResource(imageIds[id.get()]);
    	    	newButton.setId(id.getAndIncrement());
    	    	wordList.add(newButton);
    	    	
            	Log.i(TAG, "add word: " + id);
            	
            	//gridLayout.addView(newBtn, Math.max(0, gridContainer.getChildCount()));
            	addZone.addView(newButton, Math.max(0, addZone.getChildCount()));
            }
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

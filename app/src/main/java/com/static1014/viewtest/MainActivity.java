package com.static1014.viewtest;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickCircleBtn(View view) {
        Animator openAnimator, closeAnimator;
        final View myView = findViewById(R.id.my_view);
        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.rl_base_dialog).setVisibility(View.VISIBLE);
            }
        });
        int cx = myView.getRight();
        int cy = myView.getTop() + myView.getHeight();
        int openRadius = Math.max(myView.getWidth(), myView.getHeight());

        if (myView.getVisibility() == View.INVISIBLE) {
            myView.setVisibility(View.VISIBLE);
            openAnimator = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, openRadius);
            openAnimator.start();
        } else {
            closeAnimator = ViewAnimationUtils.createCircularReveal(myView, cx, cy, openRadius, 0);
            closeAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    myView.setVisibility(View.INVISIBLE);
                }
            });
            closeAnimator.start();
        }
    }

    public void clickBtn(View view) {
        Intent it = new Intent(this, CenterActivity.class);
        startActivity(it);
    }

    public void clickDialogBtn(View view) {
        findViewById(R.id.rl_base_dialog).setVisibility(View.GONE);
    }


}

package com.example.alertdialog;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private AlertDialog.Builder alertDialog;                                                                                       //build the alertDialog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {                                                                      //listener of the button
            @Override
            public void onClick(View v) {
                alertDialog = new AlertDialog.Builder(MainActivity.this);                                                    // to show the alert in this contextview
                alertDialog.setTitle( getResources().getString(R.string.alert_title) );                                             //alert title
                alertDialog.setMessage(getResources().getString(R.string.alert_message));                                           //allert message
                alertDialog.setCancelable(false);                                                                                   //to be not cancelable - force shown
                alertDialog.setPositiveButton(getResources().getString(R.string.yes_button), new DialogInterface.OnClickListener() { //if click Yes do this
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish();                                                                                  //exit MainActivity
                    }//end of onClick()
                }); //end of OnClickListener()
                alertDialog.setNegativeButton(getResources().getString(R.string.no_button), new DialogInterface.OnClickListener() {  //if click No do this
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel(); // cancel the dialog and return to MainActivity
                    }//end of onClick()
                }); //end of OnClickListener()
                AlertDialog dialog = alertDialog.create();
                dialog.show();
            }//end of onClick()
        }); // end of OnClickListener()
    }//end of onCreate()
}//end class
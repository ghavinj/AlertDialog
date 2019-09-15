package com.ghavinj.alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button showAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showAlertDialog = (Button)findViewById(R.id.showDialogButton);

        showAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show the actual dialog (alert dialog)

                alertDialog = new AlertDialog.Builder(MainActivity.this);

                //Set things up - setup title

                alertDialog.setTitle(R.string.title);

                //Set Icon
                alertDialog.setIcon(android.R.drawable.btn_star_big_on);

                //Set Message
                alertDialog.setMessage(getResources().getString(R.string.message));

                //setCancelable

                alertDialog.setCancelable(false);

                //Set positive button

                alertDialog.setPositiveButton(getResources().getString(R.string.yes),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Exit our window activity
                                MainActivity.this.finish();
                            }
                        });

                //Set negative button
                alertDialog.setNegativeButton(getResources().getString(R.string.no),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                //Create actual dialog
                AlertDialog dialog = alertDialog.create();

                //Show dialog
                dialog.show();

            }
        });
    }
}

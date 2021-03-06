package go.app.newe.article;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import go.app.newe.R;
import go.app.newe.data.Data_Buttons;

public class Art_5 extends AppCompatActivity {

    private Dialog dialog;
    private Button ShowDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art5);
        Random addition1 = new Random();
        int additionint1 = addition1.nextInt(322)+3;
        TextView additionText1 = (TextView) findViewById(R.id.number_likes);
        String additionString1 = String.valueOf(additionint1);
        additionText1.setText(additionString1);

        ShowDialog = findViewById(R.id.flag);

        //Create the Dialog here
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button Okay = dialog.findViewById(R.id.btn_okay);
        Button Cancel = dialog.findViewById(R.id.btn_cancel);

        Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Art_5.this, "Your message is delivered", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Art_5.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        ShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show(); // Showing the dialog here
            }
        });
    }

    public void back(View view) {
        Intent intent = new Intent(Art_5.this, Data_Buttons.class);
        startActivity(intent);

    }

    public void share(View view) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String sharebody = "Amazing game, You should try it!";
        String subject = "https://play.google.com/store/apps/details?id=go.app.newe";
        i.putExtra(Intent.EXTRA_SUBJECT,sharebody);
        i.putExtra(Intent.EXTRA_TEXT,subject);
        startActivity(Intent.createChooser(i,"AVADH TUTOR"));
    }
}

package example.tamasakiss.com.sendingmessage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by tamas.a.kiss on 9/11/2017.
 */

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    // Create the function content for the page
    TextView tvRequest;
    Button btn;
    String emailContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_2); // This atache the activity_2 layout (activity_2.xml)

        Bundle b = getIntent().getExtras(); // Final Class, takeing care of all the data, passed on to OnCreate
        // Creating a new Bundle AND GET THE INTENT FROM MAINACTIVITY(MainActivity.java)

        emailContent = b.getString("keyForExtras", "default"); // getString get the data from the first screen useing Bundle b
        // from IntentToNextScreen but set the second parameter default, we dont send any data to a next window

        tvRequest = (TextView) findViewById(R.id.tv);
        tvRequest.setText(emailContent); // We passing the data to emailContent, this will write the data to the next page

        btn = (Button) findViewById(R.id.btnEmail); // Creating email sending button
        btn.setOnClickListener(this);  // Set a listener to this button, THIS WILL WORK ON onClick method
    }

    @Override
    public void onClick(View v) {

        //ACTION(String): Dialing a number, Shareing a message, Web Search, Email
        //DATA(you need this): Phone number, Message text, Keywords to search, Email id Email body
        // This is the ACTION, WHAT DO YOU WANT TO BE DONE?(send an email)
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: ")); // ONLY EMAIL APPS SHOULD HANDLE THIS!!!

        intent.putExtra(Intent.EXTRA_TEXT, emailContent); //This will put the emailContent to the email(MainActivity.java,
        // and Activity2.java)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Testing an email with Implicit intents"); // Set the email text(implicit)

        // send the email to someone(implicit)
        // its an array, you can put more email inside
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"testing@gmail.com", "tamas.kiss.job@gmail.com"});


        // if the user dont have an email application we need to do with try
        try {
            startActivity(intent);
        } catch (Exception e){
            e.printStackTrace();
            // Print a message for the user using TOAST message(write message in the phone picture)
            Toast.makeText(this, "There is no email app on your phone", Toast.LENGTH_SHORT).show();
        }
    }
}

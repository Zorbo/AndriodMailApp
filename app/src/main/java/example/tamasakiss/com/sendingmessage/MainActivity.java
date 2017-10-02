    package example.tamasakiss.com.sendingmessage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by tamas.a.kiss on 9/11/2017.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // First we need to create the buttons and everyyhing else what got A FUNCTION
    EditText e;
    CheckBox cb1, cb2, cb3;
    Button b;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sending_message);  // The XML name in the project, connecting JAVA with XML
        e = (EditText) findViewById(R.id.name); //Create text field work

        cb1 = (CheckBox) findViewById(R.id.dogCheckBox); //Create checkbox1 use XML ID
        cb2 = (CheckBox) findViewById(R.id.catCheckBox);  //Create checkbox2 use XML ID
        cb3 = (CheckBox) findViewById(R.id.medicineCheckBox);  //Create checkbox3 use XML ID

        b = (Button) findViewById(R.id.submit);  //Create Submit button

        b.setOnClickListener(this); // View.OnClickListener interface, make a button WORK with setOnclickListener(this)
                                    // AND THIS will run the onclick method (the setOnClickListener)
    }

    @Override
    public void onClick(View v) {

        // Creating the desired information that we wanted to pass on, ON CLICK!
        String name = e.getText().toString(); //Get the text, need to convert to String
        boolean cat = cb1.isChecked(); // is checked? give back true or false
        boolean dog = cb2.isChecked();
        boolean medicine = cb3.isChecked();

        String finalRequest = "Need a" + name +"\n" + "Cat " + cat + "\n" + //The final message that we wanted to pass on
                "Dog " + dog + "\n" + "Medicine " + medicine;

        // Intent is a class witch can be used to get some action done.
        // We make an object(Activity2) of this class to carry out the desired actions
        Intent intentToNextScreen = new Intent(MainActivity.this, Activity2.class); //First parameter Same MainActivity,
                                                                                    // Second Activity Go to another screen

        intentToNextScreen.putExtra("keyForExtras", finalRequest); //putExtra method two parameter first is the KEY,
                                                                   // Second one What data do we want to pass

        startActivity(intentToNextScreen); //Its TAKE TO THE NEXT SCREEN ACTIVITY2.java

    }
}

package thegenuinegourav.ideax;

import android.content.DialogInterface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class IdeaDetailActivity extends AppCompatActivity {


    private ArrayList<String> values;
    TextView heading,description;
    String heading_bn;
    String description_bn;
    ImageView imageResources;
    Integer Imageres;
    TextToSpeech t1;
    ImageButton CommentButton;
    ListView li;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_detail);

        heading = (TextView)findViewById(R.id.heading);
        description = (TextView)findViewById(R.id.description);
        imageResources = (ImageView) findViewById(R.id.idea_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });
        CommentButton = (ImageButton) findViewById(R.id.comment_button);


        // Get ListView object from xml
        li = (ListView) findViewById(R.id.list_comments);

        values = new ArrayList<String>(); //Creating a new ArrayList
        values.add("Miley Cyrus");
        values.add("Selena Gomez");
        values.add("Jonas Brothers");

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        Bundle bn = getIntent().getExtras();
        if(bn != null){
            heading_bn = bn.getString("heading");
            description_bn = bn.getString("description");
            Imageres = bn.getInt("ImageResource");

            heading.setText(heading_bn);
            description.setText(description_bn);
            imageResources.setImageResource(Imageres);

        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                t1.speak(description_bn, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        li.setAdapter(adapter);

        CommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLangDialog();
            }
        });

    }


    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();

    }

    public void showChangeLangDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.comment_dialog_box, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit1);

        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //do something with edt.getText().toString();
                if(edt.getText().toString().length()!=0)
                {
                    values.add(edt.getText().toString());
                    Toast.makeText(getApplicationContext(),"comment added successfully!",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Write Comment!!",Toast.LENGTH_SHORT).show();
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();

        b.show();

    }
}

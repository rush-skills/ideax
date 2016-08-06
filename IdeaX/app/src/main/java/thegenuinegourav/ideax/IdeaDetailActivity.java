package thegenuinegourav.ideax;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class IdeaDetailActivity extends AppCompatActivity {


    TextView heading,description;
    String heading_bn;
    String description_bn;
    ImageView imageResources;
    Integer Imageres;
    ImageButton new_comment;
    ListView comments_list;
    private ArrayList<String> comments;
    private ArrayAdapter adapter;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_detail);

        heading = (TextView)findViewById(R.id.heading);
        description = (TextView)findViewById(R.id.description);
        imageResources = (ImageView) findViewById(R.id.idea_image);
        new_comment = (ImageButton)findViewById(R.id.new_comment);
        comments_list = (ListView)findViewById(R.id.comments_list);
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

        Bundle bn = getIntent().getExtras();
        if(bn != null){
            heading_bn = bn.getString("heading");
            description_bn = bn.getString("description");
            Imageres = bn.getInt("ImageResource");

            heading.setText(heading_bn);
            description.setText(description_bn);
            imageResources.setImageResource(Imageres);

        }

        comments = new ArrayList<String>(); //Creating a new ArrayList
        comments.add("Miley Cyrus");
        comments.add("Selena Gomez");
        comments.add("Jonas Brothers");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,comments);
        comments_list.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                t1.speak(description_bn, TextToSpeech.QUEUE_FLUSH, null);
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
}

package thegenuinegourav.ideax;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class IdeaDetailActivity extends AppCompatActivity {


    TextView heading,description;
    String heading_bn;
    String description_bn;
    ImageView imageResources;
    Integer Imageres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idea_detail);

        heading = (TextView)findViewById(R.id.heading);
        description = (TextView)findViewById(R.id.description);
        imageResources = (ImageView) findViewById(R.id.idea_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
            }
        });



    }
}

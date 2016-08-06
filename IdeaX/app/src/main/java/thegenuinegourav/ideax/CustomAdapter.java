package thegenuinegourav.ideax;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;

    private Integer[] ImageResources={R.drawable.it,R.drawable.snapchat,R.drawable.appointments,R.drawable.agile,
            R.drawable.ai};
    private String[] Tag1 = {"IT","Snapchat","Appointments","Agile","Artificial"};
    private String[] Tag2 = {"Experience","Leadership","July 2016","Reliable","Intelligence"};
    private String[] Tag3 = {"Products","Career","Agencies","Predictable","Herbert"};
    //private String[] HeadingNames={"Dog1","Dog2","Dog3","Dog4","Dog5","Dog6","Dog7","Dog8"};
    private String[] Description={"There has never been a better time to work in IT; never has technology been so fundamental, so strategic and so important as it is in the digital age. Technology is being used to create new types of products and services, enhance existing products and services and create deeper, more rewarding customer experiences. And it is also being used to enable entirely new business models that are transforming industries."
            ,"Recently I wrote a blog with my advice for young executives managing older, experienced staff. My entire career was focused on managing and working with experienced staff and there are things that I learn and adapt daily in my management style. I have adjusted my leadership style for the different personalities on the team. I have developed the skills in working a boardroom and understand how to observe the audience. Most importantly I have transitioned to think like a chairman of the board, investor of the company, CEO of the organization, and other top executive leaders. This mentality will never go away and it is a life long learning journey, as I would call it. Learning will never stop. The next wave of leadership that I must focus on is managing the upcoming millennial workforce."
            ,"Two top federal agencies, NASA and the Veterans Affairs (VA) Department, have appointed new chief information security officers (CISO). Less than two months after the last head of information security, Brian Burns, left the VA for another job in the public sector, the agency named Roopangi Kadakia as the next CISO. Previously, Kadakia served as web services executive in NASA’s Office of the CIO.",
            "Like most established companies, we have for many years focused on the core tenets of reliability, predictability, interoperability, security, and cost containment in delivering on our IT mission – “doing IT right”. In recent years we have also faced demands from the market and from customers for greater speed and agility, adding to the challenge of doing things right – “doing IT fast.” When I became CIO earlier this year, it was clear that we could not continue to operate IT in a traditional manner and remain competitive.",
            "We have been hearing predictions for decades of a takeover of the world by artificial intelligence. In 1957, Herbert A. Simon predicted that within 10 years a digital computer would be the world’s chess champion.  That didn’t happen until 1996.  And despite Marvin Minsky’s 1970 prediction that “in from three to eight years we will have a machine with the general intelligence of an average human being,” we still consider that a feat of science fiction."};
    private String[] headings;

    CustomAdapter(Context context,String[] Head)
    {
        super(context,R.layout.custom_list,Head);
        headings=Head;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view=inflater.inflate(R.layout.custom_list, parent, false);
        ImageView image;
        TextView text1;
        TextView text2;
        Button tag1,tag2,tag3;
        CardView card = (CardView)view.findViewById(R.id.card_view);
        image = (ImageView)view.findViewById(R.id.image);
        text1 = (TextView)view.findViewById(R.id.text1);
        text2 = (TextView)view.findViewById(R.id.text2);
        tag1 = (Button)view.findViewById(R.id.tag1);
        tag2 = (Button)view.findViewById(R.id.tag2);
        tag3 = (Button)view.findViewById(R.id.tag3);
        image.setImageResource(ImageResources[position]);
        text1.setTypeface(Typeface.DEFAULT_BOLD);
        text1.setText(getItem(position));
        text2.setText(Description[position]);
        tag1.setText(Tag1[position]);
        tag2.setText(Tag2[position]);
        tag3.setText(Tag3[position]);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                        Intent i = new Intent(context,IdeaDetailActivity.class);

                        i.putExtra("ImageResource",ImageResources[position]);
                        i.putExtra("heading",headings[position]);
                        i.putExtra("description",Description[position]);
                        context.startActivity(i);


            }
        });

        return view;
    }
}
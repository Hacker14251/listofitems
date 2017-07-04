package hp.example.com.listofitems;

import java.util.ArrayList;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/** Note that here we are inheriting ListActivity class instead of Activity class **/
public class MainActivity extends AppCompatActivity{
    ListView listView;
    /** Items entered by the user is stored in this ArrayList variable */
    ArrayList<String> list = new ArrayList<String>();
    /** Declaring an ArrayAdapter to set items to ListView */
    ArrayAdapter<String> adapter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /** Setting a custom layout for the list activity */
        setContentView(R.layout.activity_main);

        /** Reference to the button of the layout main.xml */
        Button btn = (Button) findViewById(R.id.btnAdd);

      listView= (ListView) findViewById(R.id.list);
        /** Defining the ArrayAdapter to set items to ListView */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        /** Defining a click event listener for the button "Add" */
        listView.setAdapter(adapter);
        OnClickListener listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                list.add(edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
            }
        };

        /** Setting the event listener for the add button */
        btn.setOnClickListener(listener);
        /** Setting the adapter to the ListView */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View view,
                                    int position,long id) {
            TextView t=(TextView)view;
                Intent myintent = new Intent(view.getContext(), Main2Activity.class);

                myintent.putExtra("userName",t.getText().toString());

                startActivity(myintent);

            }
        });

    }



}


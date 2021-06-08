package sg.edu.rp.c346.id20022735.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    EditText edEle;
    Button btnAdd;
    Button btnrem;
    Button btnup;
    ListView lvcolor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement = findViewById(R.id.editTextColor);
        btnAdd = findViewById(R.id.buttonAddItem);
        btnrem = findViewById(R.id.buttonR);
        btnup = findViewById(R.id.buttonU);
        lvcolor = findViewById(R.id.listViewColor);
        edEle = findViewById(R.id.editTextPosition);


        ArrayList<String> alColours;
        alColours = new ArrayList<String>();
        alColours.add("Red");
        alColours.add("Orange");

        ArrayAdapter aaColour = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,alColours);

        lvcolor.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etElement.getText().toString().isEmpty() && !edEle.getText().toString().isEmpty()) {
                    String colours = etElement.getText().toString();
                    int pos = Integer.parseInt(edEle.getText().toString());
                    alColours.add(pos, colours);
                    aaColour.notifyDataSetChanged(); //force refresh
                } else {
                    Toast.makeText(MainActivity.this, "Please enter something", Toast.LENGTH_SHORT).show();
                }
            }});

        btnrem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edEle.getText().toString().isEmpty()){
                    int pos = Integer.parseInt(edEle.getText().toString());
                    alColours.remove(pos);
                    aaColour.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(MainActivity.this, "Please enter correct position", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String colours = etElement.getText().toString();
                    int pos = Integer.parseInt(edEle.getText().toString());
                    alColours.set(pos, colours);
                    aaColour.notifyDataSetChanged(); //force refresh
                }
        });

        lvcolor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
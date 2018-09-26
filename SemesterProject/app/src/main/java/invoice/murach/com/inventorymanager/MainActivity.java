package invoice.murach.com.inventorymanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button helpButton;
    private Button settingsButton;
    private Spinner spinner;
    private ArrayList<String> locationArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set all controls
        helpButton = findViewById(R.id.helpButton);
        settingsButton = findViewById(R.id.settingsButton);
        spinner = findViewById(R.id.locationSpinner);
        locationArray.add("Select Location...");




        // Setup location options
        locationArray.add("Garage");


        locationArray.add("Add New Location");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,locationArray);
        spinner.setAdapter(adapter);

        // Set listeners
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHelp();
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getApplicationContext(), Integer.toString(position), Toast.LENGTH_LONG).show();

                String selectionName = spinner.getSelectedItem().toString();
                switch(selectionName){
                    case "Add New Location":
                        openNewLocation();
                        spinner.setSelection(0);
                        break;
                    case "Select Location...":
                        break;
                    default:
                        openLocation(selectionName);
                        spinner.setSelection(0);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });

    }

    public void openLocation(String selectionName){
        // Selection name will pass the page to load
        Intent intent = new Intent(MainActivity.this, view_location.class);
        startActivity(intent);
    }
    public void openNewLocation(){
        Intent intent = new Intent(MainActivity.this, new_location.class);
        startActivity(intent);
    }
    // Open help activity
    public void openHelp() {
        Intent intent = new Intent(MainActivity.this, help.class);
        startActivity(intent);
    }
    // Open settings activity
    public void openSettings(){
        Intent intent = new Intent(MainActivity.this, settings.class);
            startActivity(intent);
    }
}

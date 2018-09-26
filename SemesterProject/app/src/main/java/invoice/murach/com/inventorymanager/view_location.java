package invoice.murach.com.inventorymanager;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class view_location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button itemId;
        Button addItem;
        FloatingActionButton editLocation;
        Button viewLog;
        setContentView(R.layout.activity_view_location);

        // Get views by ID
        itemId = findViewById(R.id.inventoryItem_01);
        addItem = findViewById(R.id.addItemButton);
        editLocation = findViewById(R.id.editLocationButton);
        viewLog = findViewById(R.id.inventoryLogButton);

        // Setup listeners
        itemId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openItem();
            }
        });
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });
        editLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editLocation();
            }
        });

        viewLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLog();
            }
        });

    }

    public void openItem() {
        Intent intent = new Intent(view_location.this, view_item.class);
        startActivity(intent);
    }

    public void addItem() {
        Intent intent = new Intent(view_location.this, AddItem.class);
        startActivity(intent);
    }

    public void editLocation() {
        Intent intent = new Intent(view_location.this, EditLocation.class);
        startActivity(intent);

    }
    public void showLog(){
        Intent intent = new Intent(view_location.this, InventoryLog.class);
        startActivity(intent);
    }
}

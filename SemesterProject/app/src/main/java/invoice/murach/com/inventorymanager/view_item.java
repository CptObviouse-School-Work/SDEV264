package invoice.murach.com.inventorymanager;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class view_item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FloatingActionButton editItem;
        setContentView(R.layout.activity_view_item);

        // Get views by id
        editItem = findViewById(R.id.floatingActionButton2);

        // Setup event listeners
        editItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditItem();
            }
        });
    }

    public void showEditItem(){
        Intent intent = new Intent(view_item.this, EditItem.class);
        startActivity(intent);
    }
}

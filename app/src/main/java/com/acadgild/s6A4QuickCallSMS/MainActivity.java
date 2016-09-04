package com.acadgild.s6A4QuickCallSMS;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/*Implement context menu having two options call and sms.

- For this you need to have custom list having two text view in row.
- One text view for name and another one for phone phoneNumbers.
- Write implicit intent action for call and sms.*/
public class MainActivity extends AppCompatActivity {

    ListView contactDetailsList;

    String[] names = MainData.getNames();
    String[] phoneNumbers = MainData.getPhoneNumbers();

    final int CALL_OPTION_ID = 101;
    final int SMS_OPTION_ID = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        contactDetailsList = (ListView) findViewById(R.id.contacts_details_list);
        contactDetailsList.setAdapter(new MainAdapter(this, names, phoneNumbers));
        registerForContextMenu(contactDetailsList);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle(getResources().getString(R.string.context_menu_heading));
        menu.add(0, CALL_OPTION_ID, 0, getResources().getString(R.string.option_call));
        menu.add(0, SMS_OPTION_ID, 0, getResources().getString(R.string.option_sms));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        Intent intent;
        int menuItemPosition = ((AdapterView.AdapterContextMenuInfo) item.getMenuInfo()).position;

        switch (item.getItemId()) {
            case CALL_OPTION_ID: {
                intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumbers[menuItemPosition]));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                    return true;
                startActivity(intent);
                break;
            }
            case SMS_OPTION_ID:{
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra("address",  phoneNumbers[menuItemPosition] );
                intent.putExtra(Intent.EXTRA_TEXT, "SMS Sent Through: QuickCallSMS App.\n");
                startActivity(intent);
                break;
            }
            default:{
                Toast.makeText(this, "Error: This option is not supported for device.", Toast.LENGTH_SHORT).show();
                break;
            }

        }

        return true;
    }
}

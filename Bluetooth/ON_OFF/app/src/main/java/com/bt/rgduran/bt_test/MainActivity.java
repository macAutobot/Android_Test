package com.bt.rgduran.bt_test;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declare variables
	Button BT_ON, BT_OFF;
	BluetoothAdapter myBT_Adapter;
    String Check_BT = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init my variables
        Init();
        //setup Button listeners
        setup_listeners();
    }

    public void setup_listeners(){
        BT_ON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check_BT = "Bluetooth-ON Button";
                Toast.makeText(getApplicationContext(),Check_BT, Toast.LENGTH_LONG).show();
                myBT_Adapter.enable();
				check_BT();
            }
        });

        BT_OFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check_BT = "Bluetooth-OFF Button";
                Toast.makeText(getApplicationContext(),Check_BT, Toast.LENGTH_LONG).show();
                myBT_Adapter.disable();
				check_BT();
            }
        });
    }

    public void Init(){
        BT_ON = (Button) findViewById(R.id.BT_ON);
        BT_OFF= (Button) findViewById(R.id.BT_OFF);
        Check_BT = null;
        myBT_Adapter = BluetoothAdapter.getDefaultAdapter();
    }
	
	public void check_BT()
	{
		if(!myBT_Adapter.isEnabled()) {
            //set a variable to test assert in unit test
            Toast.makeText(getApplicationContext(),"Bluetooth Enabled",Toast.LENGTH_LONG).show();
        }
        else {
            //set a variable to test assert in unit test
            Toast.makeText(getApplicationContext(),"Bluetooth not Enabled",Toast.LENGTH_LONG).show();
        }
	
	}
}

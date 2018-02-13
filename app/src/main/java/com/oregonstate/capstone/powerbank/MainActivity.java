package com.oregonstate.capstone.powerbank;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter mBluetoothAdapter;
    String currentVal = "96%";
    String deviceName = "JBL Flip 3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updateLevel(currentVal);
        updateList(deviceName);
    }

    public void updateLevel(String level) {
        TextView mTextView = (TextView) findViewById(R.id.battery_level);
        mTextView.setText(level);
    }

    public void updateList(String deviceName) {
        TextView mLayout = (TextView) findViewById(R.id.device_list);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();

        List<String> s = new ArrayList<String>();
        for(BluetoothDevice bt : pairedDevices) {
            s.add(bt.getName());
            if(bt.getName().toString().equals(deviceName)) {
                mLayout.setText(bt.getName().toString() + " = " + bt.toString());
            }
            Log.d("MainActivity", bt.getName().toString());
        }



        //       setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, s));
    }


}

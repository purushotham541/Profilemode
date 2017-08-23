package com.example.raj.setprofilemode;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Naveen on 6/17/2017.
 */

public class MyBR extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        Object o = bundle.get("pdus");
        Object mess[] = (Object[])o;

        for (int i=0;i<mess.length;i++)
        {
            byte b[] = (byte[])mess[i];
            SmsMessage sms = SmsMessage.createFromPdu(b);
            String from_no = sms.getDisplayOriginatingAddress();
            String message = sms.getDisplayMessageBody();
            Intent intent1 = new Intent();
            intent1.setClassName("com.example.raj.setprofilemode","com.example.raj.setprofilemode.MainActivity");
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent1.putExtra("k1",from_no);
            intent1.putExtra("k2",message);
            context.startActivity(intent1);
        }
    }
}

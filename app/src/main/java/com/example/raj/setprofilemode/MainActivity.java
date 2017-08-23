package com.example.raj.setprofilemode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.AlarmManager;
import android.content.Intent;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.telephony.SmsManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.oopiri);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        if (b != null) {
            String cno = b.getString("k1");
            String mess = b.getString("k2");

            tv1.setText(cno);
            tv2.setText(mess);

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage("8125251050", null, cno + "\n" + mess, null, null);

            //if (cno.equals("+917007054983"))
            //{
            if (mess.equals("PLAY")) {
                mp.start();
            } else if (mess.equals("NORMAL")) {
                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            } else if (mess.equals("SILENT")) {
                am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
            } else if (mess.equals("VIBRATE")) {
                am.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
            //}
        }
    }
}
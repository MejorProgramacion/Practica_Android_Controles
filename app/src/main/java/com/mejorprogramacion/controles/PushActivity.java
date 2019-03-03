package com.mejorprogramacion.controles;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PushActivity extends AppCompatActivity {

    Button BtnNotificacionPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);

        setTitle("Notificaciones Push");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BtnNotificacionPush = (Button) findViewById(R.id.BtnNotificacionPush);
        BtnNotificacionPush.setOnClickListener(new ClickEvent());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(PushActivity.this,Notificaciones.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    class ClickEvent implements View.OnClickListener{
        public  void onClick(View Btn){
            if(Btn == BtnNotificacionPush){
                NotificationCompat.Builder mBuilder;
                NotificationManager mNotifyMgr =(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);

                Intent i=new Intent(PushActivity.this, Notificaciones.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(PushActivity.this, 0, i, 0);

                int Icono = R.drawable.ic_videogame_asset_black_24dp;
                Uri NotificacionSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

                mBuilder =new NotificationCompat.Builder(getApplicationContext())
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(Icono)
                        .setContentTitle("Mi App")
                        .setContentText("Abrir la app en Notificaciones")
                        .setVibrate(new long[] {100, 250, 100, 500})
                        .setSound(NotificacionSound)
                        .setAutoCancel(true);

                mNotifyMgr.notify(1, mBuilder.build());
            }
        }
    }


}

package br.tcc.unicid.photostamp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.EventBll;
import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.DTO.Event;
import br.tcc.unicid.photostamp.model.DTO.Photo;

//This is called every second (depends on repeatTime)
public class ProcessTimerReceiver extends BroadcastReceiver {

    @Inject
    PhotoBll photoBll;
    @Inject
    EventBll eventBll;



    @Override
    public void onReceive(Context context, Intent intent) {

        MainApplication.getComponent().inject(this);

        if(photoBll.GetTotalWithoutTag() > 0) {
            NotificationManager notif = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, TagActivity.class), 0);
            Notification notify = new Notification.Builder
                    (context)
                    .setContentText("Não deixe de marcar suas fotos!")
                    .setContentTitle("Fotos pendentes")
                    .setSmallIcon(R.drawable.ic_menu_camera)
                    .setContentIntent(contentIntent)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .build();

            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.notify(0, notify);
        }


        Event event = eventBll.Get();

        if(event != null && event.getID() != 0) {
            NotificationManager notif = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(context, PhotoActivity.class), 0);
            Notification notify = new Notification.Builder
                    (context)
                    .setContentText("Uma data especial merece uma foto especial!")
                    .setContentTitle("Dia das Mães")
                    .setSmallIcon(R.drawable.ic_menu_camera)
                    .setContentIntent(contentIntent)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .build();

            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.notify(1, notify);
        }
    }
}
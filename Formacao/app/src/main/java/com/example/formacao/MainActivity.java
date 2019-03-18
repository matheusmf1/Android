package com.example.formacao;

import android.Manifest;
import android.app.ActionBar;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

import static com.example.formacao.Notification.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;

    @BindView( R.id.imageView )
    ImageView imageViewPhoto;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ButterKnife.bind(this );

        checkPermissions();
        notificationManager = NotificationManagerCompat.from( this );
    }

    public void showToast( View v ) {
        //SHOW MESSAGE
        Toast.makeText( getApplicationContext(), getString(R.string.toastMsg), Toast.LENGTH_LONG ).show();
    }

    public void showSnackBar( View v ) {
        //The SnackBar is a new Widget introduced as a replacement Toast
        //A Toast message don’t have action button, but Snackbar may have action button optionally.

        Snackbar meuSnack;
        meuSnack = Snackbar.make(v, getString(R.string.snackBar), Snackbar.LENGTH_LONG);
        meuSnack.show();

        meuSnack.setAction("Snack Action", new OnClickListener() {
            @Override
            public void onClick( View v ) { Log.i("SnackBarLOG", "Clicou no SnackBar"); }
        });
    }

    public void showNotification( View v ) {
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon( R.drawable.ic_one )
                .setContentTitle( "Title" )
                .setContentText( getString(R.string.notificationHw) ).setPriority( NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE )
                .build();

        notificationManager.notify(1, notification );
    }


    @OnClick( R.id.fragmentBtn )
    public void showFragment( View v ) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.changeToFrag, new Fragment1());
        ft.commit();
    }

    public void showActivity2( View v ) {
        Intent intent = new Intent(this, Tela2Activity.class );
        startActivity( intent );
    }

    @OnClick( R.id.dialogBtn )
    public void showDialog( View v ) {
        Dialog dialog = new Dialog();
        dialog.show( getSupportFragmentManager(), "ExampleDialog" );
    }


    public void showDial( View v ) {
        Intent intent = new Intent( Intent.ACTION_DIAL );
        startActivity( intent );
    }


    @OnClick( R.id.cameraBtn )
    public void showCamera( View v ) {
        imageViewPhoto = ( ImageView ) findViewById(R.id.imageView);

        Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult( intent,1 );
        takePicture();
    }


    private void takePicture( ){
        Intent intent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult( intent,1 );
    }


    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data ) {
        if ( requestCode == 1 && resultCode == RESULT_OK ){
            Bundle extras = data.getExtras();
            Bitmap imagem = ( Bitmap ) extras.get( "data" );
            imageViewPhoto.setImageBitmap( imagem );
        }
        super.onActivityResult( requestCode, resultCode, data );
    }

    public void checkPermissions(){
        //CALL
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},0); }

        //CAMERA
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},0); }

    }

}
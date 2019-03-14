//package com.example.formacao;
//
//import android.Manifest;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import androidx.annotation.Nullable;
//import androidx.core.app.ActivityCompat;
//import androidx.appcompat.app.AppCompatActivity;
//import android.view.View;
//import android.widget.ImageView;
//
//public class Camera extends AppCompatActivity {
//    ImageView imageViewPhoto;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},0);
//        }
//
//        imageViewPhoto = (ImageView)findViewById(R.id.imageView);
//        findViewById(R.id.cameraBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                takePicture();
//            }
//        });
//    }
//
//    public void takePicture(){
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent,1);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (requestCode == 1 && resultCode == RESULT_OK){
//            Bundle extras = data.getExtras();
//            Bitmap imagem = (Bitmap) extras.get("data");
//            imageViewPhoto.setImageBitmap(imagem);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
//
//}

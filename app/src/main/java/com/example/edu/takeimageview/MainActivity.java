package com.example.edu.takeimageview;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.provider.MediaStore;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
final int IMAGE_CAPTURE=102;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button imageCaptureButton = (Button)findViewById(R.id.imageCaptureButton);
        imageCaptureButton.setOnClickListener(this);
    }
    public void onClick(View view) {
        if(getPackageManager()

                .hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView imageView=findViewById(R.id.imageView);

        if (requestCode == IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(bitmap);
        }}
}

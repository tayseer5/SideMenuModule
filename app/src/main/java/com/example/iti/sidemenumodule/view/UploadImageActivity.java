package com.example.iti.sidemenumodule.view;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.example.iti.sidemenumodule.R;
import com.example.iti.sidemenumodule.daos.UserManager;
import com.example.iti.sidemenumodule.helperclasses.Utility;
import com.example.iti.sidemenumodule.model.Users;
import com.github.mikephil.charting.utils.Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class UploadImageActivity extends ActionBarActivity {
    private static final int SELECT_PICTURE = 100;
    private String encoded_image,image_name;
    private File file;
    private Uri file_uri; //reference file uri
    private Uri outputFileUri;
    private Bitmap bitmap;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
        Button bt = (Button) findViewById(R.id.button3);
        if (bt!=null) {
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

//                    boolean result = Utility.checkPermission(UploadImageActivity.this);
//                    if (result)
//                        imageIntent();
                }
            });
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_upload_image, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void imageIntent()
    {
        // Determine Uri of camera image to save.
        final File root = new File(Environment.getExternalStorageDirectory() + File.separator + "MyDir" + File.separator);
        root.mkdirs();
        final String fname = "xyz.jpg";
        final File sdImageMainDirectory = new File(root, fname);
        outputFileUri = Uri.fromFile(sdImageMainDirectory);

        // Camera.
        final List<Intent> cameraIntents = new ArrayList<Intent>();
        final Intent captureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        final PackageManager packageManager = getPackageManager();
        final List<ResolveInfo> listCam = packageManager.queryIntentActivities(captureIntent, 0);
        for(ResolveInfo res : listCam) {
            final String packageName = res.activityInfo.packageName;
            final Intent intent = new Intent(captureIntent);
            intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            intent.setPackage(packageName);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
            cameraIntents.add(intent);
        }
        // Filesystem.
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        // Chooser of filesystem options.
        final Intent chooserIntent = Intent.createChooser(galleryIntent, "Select Source");

        // Add the camera options.
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, cameraIntents.toArray(new Parcelable[cameraIntents.size()]));

        startActivityForResult(chooserIntent,152);
    }
    private void galleryIntent()
    {
        Intent intent = new Intent();

        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);
       // getFileUri();
        startActivityForResult(Intent.createChooser(intent,"Select file to upload "), SELECT_PICTURE);


    }
    private void getFileUri() {

        image_name="test123.jpg";
        file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+file.separator+image_name);//reference sdcard
        file_uri=Uri.fromFile(file);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 152) {
                final boolean isCamera;
                if (data == null) {
                    isCamera = true;
                } else {
                    final String action = data.getAction();
                    if (action == null) {
                        isCamera = false;
                    } else {
                        isCamera = action.equals(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    }
                }

                Uri selectedImageUri;
                if (isCamera) {
                    selectedImageUri = outputFileUri;
                    onSelectFromGalleryResult(selectedImageUri);
                } else {

                    selectedImageUri = data == null ? null : data.getData();
                    Log.e("selectedImageUri",selectedImageUri+"");
                    onSelectFromGalleryResult(data.getData());
                }
            }
        }

    }
public Uri test;
    private void onSelectFromGalleryResult(Uri data) {

        ImageView ivImage= (ImageView) findViewById(R.id.imageView2);
        if (ivImage!=null) {
            if(data!=null) {
                ivImage.setImageURI(data);
                Log.e("data",data+"");
                test=data;
               new Encode_image().execute(data);
            }
        }
    }
    private  class Encode_image extends AsyncTask<Uri,Void,Void>
    {

        @Override
        protected Void doInBackground(Uri... params) {
            Log.e("tag1",test+"");


                String[] projection = { MediaStore.Images.Media.DATA };
                Cursor cursor = managedQuery(test, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                String mys=cursor.getString(column_index);

            bitmap= BitmapFactory.decodeFile(mys);
            Log.e("tag3",bitmap+"");
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
            byte[] array=stream.toByteArray();
            encoded_image= Base64.encodeToString(array, 0);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            Log.e("encode image",encoded_image);
        }
    }
}


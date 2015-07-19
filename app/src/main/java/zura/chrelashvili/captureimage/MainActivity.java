package zura.chrelashvili.captureimage;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    int REQUEST_CODE=1;
     ImageView imageView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.imageView= (ImageView) findViewById(R.id.image);
        Button btn= (Button) findViewById(R.id.BTN);
        

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                 if(intent.resolveActivity(getPackageManager()) != null)
                 {

                     startActivityForResult(intent,REQUEST_CODE);
                 }






             }
         });



    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            
             Bitmap photo=(Bitmap) data.getExtras().get("data");
              imageView.setImageBitmap(photo);
        }
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
}

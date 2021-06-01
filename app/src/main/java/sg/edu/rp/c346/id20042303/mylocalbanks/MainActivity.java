package sg.edu.rp.c346.id20042303.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String clicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,getString(R.string.website));
        menu.add(0,1,1,getString(R.string.contactBank));
        if(v == tvDBS){
            clicked = "dbs";
        }else if(v == tvOCBC){
            clicked = "ocbc";
        }else if(v == tvUOB){
            clicked = "uob";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(clicked == "dbs"){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsWebsite)));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbsNumber)));
                startActivity(intent);
            }
        }else if(clicked == "ocbc"){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcWebsite)));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbcNumber)));
                startActivity(intent);
            }
        }else if(clicked == "uob"){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobWebsite)));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobNumber)));
                startActivity(intent);
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.EnglishSelection){
            tvDBS.setText(getString(R.string.dbs));
            tvOCBC.setText(getString(R.string.ocbc));
            tvUOB.setText(getString(R.string.uob));
        }else if(id==R.id.ChineseSelection){
            tvDBS.setText(getString(R.string.dbsChinese));
            tvOCBC.setText(getString(R.string.ocbcChinese));
            tvUOB.setText(getString(R.string.uobChinese));
        }

        return super.onOptionsItemSelected(item);
    }
}
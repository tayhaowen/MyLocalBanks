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

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
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
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intent);
            }
        }else if(clicked == "ocbc"){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intent);
            }
        }else if(clicked == "uob"){
            if(item.getItemId()==0){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/"));
                startActivity(intent);
            }else if(item.getItemId()==1){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
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
            tvDBS.setText("DBS Bank");
            tvOCBC.setText("OCBC Bank");
            tvUOB.setText("UOB Bank");
        }else if(id==R.id.ChineseSelection){
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("乌布银行");
        }

        return super.onOptionsItemSelected(item);
    }
}
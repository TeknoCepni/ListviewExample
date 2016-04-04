package hsyn.caliskan.listviewexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lv = (ListView)findViewById(R.id.listView);
        final Intent intent = new Intent(this,ImageActivity.class);

        String[] isimler = new String[] {
                "Ice Age",
                "Gazi Üniversitesi",
        };

        final String[] urller = new String[] {
                "http://trthaberstatic.s3-website-eu-west-1.amazonaws.com/resimler/30000/30218.jpg",
                "https://upload.wikimedia.org/wikipedia/tr/5/58/Gazi_%C3%9Cniversitesi_Logo_jpg.jpg",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, isimler);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pozisyon, long id) {
                String  isim = (String) lv.getItemAtPosition(pozisyon);
                Globals.isim = isim;
                Globals.pozisyon = pozisyon;
                Globals.urlResim = urller[pozisyon];
                startActivity(intent);

            }
        });

    }
}

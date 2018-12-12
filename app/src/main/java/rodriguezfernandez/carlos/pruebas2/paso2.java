package rodriguezfernandez.carlos.pruebas2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class paso2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paso2);
        //recuperar variables
        Bundle b=getIntent().getExtras();
        String tt=b.getString("t1");
        Toast.makeText(getApplicationContext(),tt,Toast.LENGTH_SHORT).show();
        String t1=getIntent().getStringExtra("t1");
        String t2=getIntent().getStringExtra("t2");
        TextView texto1=findViewById(R.id.dato1);
        TextView texto2=findViewById(R.id.dato2);
        texto1.setText(t1);
        texto2.setText(t2);
    }
}

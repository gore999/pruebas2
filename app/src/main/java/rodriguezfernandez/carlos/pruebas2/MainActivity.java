package rodriguezfernandez.carlos.pruebas2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity{
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=findViewById(R.id.Aceptar);
        Button b2=findViewById(R.id.Cancelar);
        CheckBox chome=findViewById(R.id.homeCb);
        CheckBox cmuller=findViewById(R.id.mullerCb);
        RadioButton r1=findViewById(R.id.nazi);
        RadioButton r2=findViewById(R.id.comu);
        Spinner bebidas=findViewById(R.id.bebidas);
        View.OnClickListener Radioesc=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.comu:
                        Toast.makeText(v.getContext(),"Elegido Comunismo",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nazi:
                        Toast.makeText(v.getContext(),"Sieg Hail",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        r1.setOnClickListener(Radioesc);
        r2.setOnClickListener(Radioesc);
        View.OnClickListener miListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb=(CheckBox)v;
                Button b1local=findViewById(R.id.Aceptar);
                if(cb.isChecked()) {
                    switch (cb.getId()) {
                        case R.id.homeCb:
                            b1local.setText("Elexiu o home");
                            break;
                        case R.id.mullerCb:
                            b1local.setText("Elexiu a muller");
                            break;
                    }
                }else{
                    switch(cb.getId()){
                        case R.id.homeCb:
                            b1local.setText("desmarcou o home");
                            break;
                        case R.id.mullerCb:
                                b1local.setText("mandou o carallo a muller");
                                break;
                    }
                }
            }
        };
        chome.setOnClickListener(miListener);
        cmuller.setOnClickListener(miListener);
        b1.setOnClickListener(new Gestor());
        b2.setOnClickListener(new Gestor());
        b2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
               Spinner sp=findViewById(R.id.bebidas);
               String selec=sp.getSelectedItem().toString();
               Toast.makeText(v.getContext(),"Ha decidido beber:"+selec,Toast.LENGTH_SHORT).show();
               Intent cambio=new Intent(getApplicationContext(), paso2.class);
               cambio.putExtra("t1",((TextView)findViewById(R.id.texto)).getText());
                cambio.putExtra("t2",((TextView)findViewById(R.id.texto2)).getText());
                startActivity(cambio);
               return true;
            }
        });
        EditText texto2=findViewById(R.id.texto2);
        texto2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_SEND){
                    TextView t=findViewById(R.id.texto);
                    t.setText(v.getText());
                }
                return false;
            }
        });
    }

    public void responder(View view) {
        Toast.makeText(getApplicationContext(),"Veñen sendo os maricons...",Toast.LENGTH_SHORT).show();
    }

    private class Gestor implements View.OnClickListener {

        @SuppressLint("ResourceType")
        @Override

        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.Aceptar:
                    Toast.makeText(v.getContext(), "Tostada de aceptacion", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.Cancelar:
                    TextView texto = findViewById(R.id.texto);
                    i += 10;
                    texto.setTextColor(Color.rgb(i, i, i));

                    Toast.makeText(v.getContext(), "Hola", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}

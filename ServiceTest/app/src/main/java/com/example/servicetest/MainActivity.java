package com.example.servicetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.servicetest.Service.MyService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "[ServiceTest]";
    private Intent serviceIntent;

    //View elements
    @BindView(R.id.bttnStartService) Button bttnStartService;
    @BindView(R.id.bttnStopService) Button bttnStopService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i( DEBUG_TAG, "MainActivity thread id: " + Thread.currentThread().getId());
        setContentView(R.layout.activity_main);
        ButterKnife.bind( this );
        serviceIntent = new Intent( getApplicationContext(), MyService.class );
    }

    //onClick Methods
    /**
     * Trata qual dos botões operacionais foi clicado e chama a função correspondente
     * @param button
     */
    @OnClick({R.id.bttnStartService, R.id.bttnStopService})
    public void clicouNoBotao( Button button ){
        switch ( button.getId() ) {
            case ( R.id.bttnStartService ):
                Log.d(DEBUG_TAG,"Clicou em Começar Serviço");
                startService( serviceIntent );
                break;
            case ( R.id.bttnStopService ):
                Log.d(DEBUG_TAG,"Clicou em Parar Serviço");
                stopService( serviceIntent );
                break;
        }
    }
}

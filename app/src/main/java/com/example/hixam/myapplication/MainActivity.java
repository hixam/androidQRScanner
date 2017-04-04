package com.example.hixam.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.zxing.Result;
import com.google.zxing.client.android.Intents;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CameraPreview;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
  /*  public void handleResult(Result rawResult) {

        // Do something with the result here</p>
         Log.e("result is : ",rawResult.getText()); // Prints scan results
        Log.e("", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)</p>
            // show the scanner result into dialog box.<br />
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("tituloooo");
                builder.setMessage(rawResult.getText());
                AlertDialog alert1 = builder.create();
                alert1.show();
             // If you would like to resume scanning, call this method below:<br />
        // mScannerView.resumeCameraPreview(this);<br />
    }*/

    public void QrScanner(View view){
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view<br />
        setContentView(mScannerView);
                mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.<br />
        mScannerView.startCamera();         // Start camera<br />
    }

    @Override
    public void onPause() {
            super.onPause();
            mScannerView.stopCamera();   // Stop camera on pause<br />
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here</p>
               Log.e("result is : ", rawResult.getText()); // Prints scan results<br />
        Log.e("result is : ", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)</p>
              // show the scanner result into dialog box.<br />
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("titleeeee");
                builder.setMessage(rawResult.getText());
                AlertDialog alert1 = builder.create();
                alert1.show();
               // If you would like to resume scanning, call this method below:<br />
        // mScannerView.resumeCameraPreview(this);<br />
    }
}
/*
    public void scanBarcode(View view) {
        new IntentIntegrator(this).initiateScan();
    }

    public void scanBarcodeInverted(View view){
        IntentIntegrator integrator = new IntentIntegrator(this);
       // integrator.addExtra(Intents.Scan.INVERTED_SCAN, true);
        integrator.initiateScan();
    }

    public void scanBarcodeCustomLayout(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
       // integrator.setCaptureActivity(AnyOrientationCaptureActivity.class);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
        integrator.setPrompt("Scan something");
        integrator.setOrientationLocked(false);
        integrator.setBeepEnabled(false);
        integrator.initiateScan();
    }

    public void scanBarcodeFrontCamera(View view) {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.setCameraId(Camera.CameraInfo.CAMERA_FACING_FRONT);
        integrator.initiateScan();
    }

    public void scanContinuous(View view) {
        //Intent intent = new Intent(this, ContinuousCaptureActivity.class);
       // startActivity(intent);
    }

    public void scanToolbar(View view) {
       // new IntentIntegrator(this).setCaptureActivity(ToolbarCaptureActivity.class).initiateScan();
    }

    public void scanCustomScanner(View view) {
      //  new IntentIntegrator(this).setOrientationLocked(false).setCaptureActivity(CustomScannerActivity.class).initiateScan();
    }

    public void scanMarginScanner(View view) {
       // IntentIntegrator integrator = new IntentIntegrator(this);
        //integrator.setOrientationLocked(false);
       // integrator.setCaptureActivity(SmallCaptureActivity.class);
       // integrator.initiateScan();
    }

    public void scanWithTimeout(View view) {
       // IntentIntegrator integrator = new IntentIntegrator(this);
        //integrator.setTimeout(8000);
       // integrator.initiateScan();
    }

    public void tabs(View view) {
      //  Intent intent = new Intent(this, TabbedScanning.class);
        //startActivity(intent);
    }
*/
  //  @Override
  //  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }*/
   // }
/*

     * Sample of scanning from a Fragment

    public static class ScanFragment extends Fragment {
        private String toast;

        public ScanFragment() {
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            displayToast();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_scan, container, false);
            Button scan = (Button) view.findViewById(R.id.scan_from_fragment);
            scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    scanFromFragment();
                }
            });
            return view;
        }

        public void scanFromFragment() {
            IntentIntegrator.forSupportFragment(this).initiateScan();
        }

        private void displayToast() {
            if(getActivity() != null && toast != null) {
                Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
                toast = null;
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if(result != null) {
                if(result.getContents() == null) {
                    toast = "Cancelled from fragment";
                } else {
                    toast = "Scanned from fragment: " + result.getContents();
                }

                // At this point we may or may not have a reference to the activity
                displayToast();
            }
        }
    }*/
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final IntentIntegrator integrator = new IntentIntegrator(this);
        setContentView(R.layout.activity_main);
        Button btn = (Button) this.findViewById(R.id.button);
        WebView myWebView = (WebView) this.findViewById(R.id.webView);
        myWebView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //webview.loadUrl("file:///android_asset/file.html");
        myWebView.loadUrl("https://www.w3schools.com/w3css/tryw3css_templates_pizza.htm");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);
                integrator.setPrompt("Scan a barcode");
                integrator.setCameraId(0);  // Use a specific camera of the device
             //   integrator.setBeepsEnabled(false);
               // integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("MainActivity", "Cancelled scan");
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Log.d("MainActivity", "Scanned");
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();

            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        */


package murali.myapplication;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import murali.myapplication.rest_api_work.RestPresenter;

public class Main3Activity extends AppCompatActivity implements RestPresenter.RestCallBackListener {

    private Button createBtn;
    private EditText name, job;
    private RestPresenter presenter;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        createBtn = (Button) findViewById(R.id.go_btn);
        name = (EditText) findViewById(R.id.emp_name);
        job = (EditText) findViewById(R.id.emp_job);

        presenter = new RestPresenter(this, this);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().length() > 0 && job.getText().toString().length() > 0) {
                    presenter.addNewEmployee(name.getText().toString(), job.getText().toString());
                } else {
                    Toast.makeText(Main3Activity.this, "Please give valid Employee name and job", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showLoading() {
        dialog = new ProgressDialog(Main3Activity.this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void dismissLoading() {

        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    public void callBackResult(boolean responseStatus, int responseCode) {
        if (responseStatus) {
            if (responseCode == 200 || responseCode == 201)
                Log.d("result", "Success");
                //Toast.makeText(Main3Activity.this, "Success", Toast.LENGTH_SHORT).show();
            else
                //Toast.makeText(Main3Activity.this, "Error!", Toast.LENGTH_SHORT).show();
                Log.d("result", "Error!");
        } else
            //Toast.makeText(Main3Activity.this, "Request is not success", Toast.LENGTH_SHORT).show();
            Log.d("result", "Request is not success");
    }

    @Override
    public void callBackFailure() {
        //Toast.makeText(Main3Activity.this, "Request is failed", Toast.LENGTH_SHORT).show();
        Log.d("result", "Request is failed");
    }
}

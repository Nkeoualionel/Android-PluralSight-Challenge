package com.lionelnkeoua.pluralsight1.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lionelnkeoua.pluralsight1.R;
import com.lionelnkeoua.pluralsight1.api.ApiForm;
import com.lionelnkeoua.pluralsight1.interfaces.ApiInterface;

public class SubmitActivity extends AppCompatActivity {

    @BindView(R.id.mFirstName)
    EditText mFirstName;

    @BindView(R.id.mLastName)
    EditText mLastName;

    @BindView(R.id.mEmail)
    EditText mEmail;

    @BindView(R.id.mGithubProjetLink)
    EditText mGithubProjetLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Project Submit");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ButterKnife.bind(this);
    }

    private boolean validate(EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true; // returs true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }


    @OnClick(R.id.mSubmit)
    public void onClickButton(){

        if (validate(mFirstName) && validate(mLastName) && validate(mEmail) && validate(mGithubProjetLink)){
            sendData(mFirstName.getText().toString(), mLastName.getText().toString(),
                    mEmail.getText().toString(), mGithubProjetLink.getText().toString());
        }else {
            Toast.makeText(SubmitActivity.this, "Remplissez tout les champs", Toast.LENGTH_LONG).show();
        }
    }

    public void sendData(String firstName, String lastName, String email, String github){
        ApiInterface api = ApiForm.getApiClient().create(ApiInterface.class);

        api.insertData(firstName, lastName, email, github).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    switch (response.code()){
                        case 200:
                            Toast.makeText(SubmitActivity.this, "SUCCES ADD", Toast.LENGTH_LONG).show();
                            alerteDialogue(R.drawable.succes);
                            break;
                        case 404:
                            Toast.makeText(SubmitActivity.this, "NOT FUND", Toast.LENGTH_LONG).show();
                            alerteDialogue(R.drawable.faild);
                            break;

                        case 500:
                            Toast.makeText(SubmitActivity.this, "ERROR SERVER", Toast.LENGTH_LONG).show();
                            alerteDialogue(R.drawable.faild);
                            break;

                        default:
                            Toast.makeText(SubmitActivity.this, "FAILD ADD", Toast.LENGTH_LONG).show();
                            alerteDialogue(R.drawable.faild);
                            break;
                    }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(SubmitActivity.this, "ERREUR INTERNET", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void alerteDialogue(int image){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(SubmitActivity.this);
        final View dialogView = LayoutInflater.from(SubmitActivity.this).inflate(R.layout.server_response, null);
        dialogBuilder.setView(dialogView);

        final ImageView img =  dialogView.findViewById(R.id.mImgResponseServer);
        Glide.with(SubmitActivity.this)
                .load(image)
                .into(img);

        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}
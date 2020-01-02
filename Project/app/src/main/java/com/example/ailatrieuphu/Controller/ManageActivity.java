package com.example.ailatrieuphu.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.Object.User;
import com.example.ailatrieuphu.PresenterImp.ManagePresenterImp;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.Dialog.CustomDialog;

import org.json.JSONException;
import org.json.JSONObject;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener, ManageView {

    private EditText edtUserName, edtEmail, edtPassword, edtPrePassword;
    private Button btnUpdateAccount;
    private ManagePresenterImp managePresenterImp;
    private User nguoi_dung;
    private JSONObject saveJsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);
        //
        initialView();
        managePresenterImp = new ManagePresenterImp(this);
        btnUpdateAccount.setOnClickListener(this);
    }

    public void initialView() {
        this.edtUserName = findViewById(R.id.txtUserNameManageAccount);
        this.edtEmail = findViewById(R.id.edtEmailManageAccount);
        this.edtPassword = findViewById(R.id.edtPasswordManageAccount);
        this.edtPrePassword = findViewById(R.id.edtConfirmPasswordManageAccount);
        this.btnUpdateAccount = findViewById(R.id.btnUpdateManageAccount);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                saveJsonObject = new JSONObject(intent.getStringExtra("nguoi_dung"));
                //Log.e("aaaa", intent.getStringExtra("nguoi_dung"));
                edtUserName.setText(saveJsonObject.getString("ten_dang_nhap"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("aaaa", "null");
        }

    }

    public EditText getEdtUserName() {
        return edtUserName;
    }

    public void setEdtUserName(EditText edtUserName) {
        this.edtUserName = edtUserName;
    }

    public EditText getEdtEmail() {
        return edtEmail;
    }

    public void setEdtEmail(EditText edtEmail) {
        this.edtEmail = edtEmail;
    }

    public EditText getEdtPassword() {
        return edtPassword;
    }

    public void setEdtPassword(EditText edtPassword) {
        this.edtPassword = edtPassword;
    }

    public EditText getEdtPrePassword() {
        return edtPrePassword;
    }

    public void setEdtPrePassword(EditText edtPrePassword) {
        this.edtPrePassword = edtPrePassword;
    }

    public Button getBtnUpdateAccount() {
        return btnUpdateAccount;
    }

    public void setBtnUpdateAccount(Button btnUpdateAccount) {
        this.btnUpdateAccount = btnUpdateAccount;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnUpdateManageAccount: {
                nguoi_dung = new User();
                nguoi_dung.setUsername(edtUserName.getText().toString().trim());
                nguoi_dung.setEmail(edtEmail.getText().toString().trim());
                nguoi_dung.setPassword(edtPassword.getText().toString().trim());
                nguoi_dung.setPrePassword(edtPrePassword.getText().toString().trim());
                //
                ManagePresenterImp.onButtonUpdateAccountClick(this, nguoi_dung);
            }
        }
    }

    public void handlingUpdateAccount() {

    }

    @Override
    public void updateSuccess() {
        new CustomDialog(this, "Thông báo!", "Cập nhật thành công!", "OK", CustomDialog.SIZE_M).show();
    }

    @Override
    public void updateFailed() {
        new CustomDialog(this, "Thông báo!", "Cập nhật thất bại!", "Cancel", CustomDialog.SIZE_M).show();
    }

    @Override
    public void showEmailFailed() {
        new CustomDialog(this, "Thông báo!", "Email không được trống!", "OK", CustomDialog.SIZE_M).show();
    }

    @Override
    public void showPasswordFailed() {
        new CustomDialog(this, "Thông báo!", "Password không được trống!", "OK", CustomDialog.SIZE_M).show();
    }

    @Override
    public void showPrePasswordFailed() {
        new CustomDialog(this, "Thông báo!", "Prepassword không được trống!", "OK", CustomDialog.SIZE_M).show();
    }

    @Override
    public void showPasswordNotMatch() {
        new CustomDialog(this, "Thông báo!", "Mật khẩu không trùng khớp!", "OK", CustomDialog.SIZE_M).show();
    }

    public JSONObject getSaveJsonObject() {
        return saveJsonObject;
    }

    public void setSaveJsonObject(JSONObject saveJsonObject) {
        this.saveJsonObject = saveJsonObject;
    }
}

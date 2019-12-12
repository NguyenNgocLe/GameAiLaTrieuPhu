package com.example.ailatrieuphu.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ailatrieuphu.Object.User;
import com.example.ailatrieuphu.PresenterImp.ManagePresenterImp;
import com.example.ailatrieuphu.R;
import com.example.ailatrieuphu.Utilities.Dialog.CustomDialog;

import org.json.JSONObject;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener, ManageView {

    private EditText edtUserName, edtEmail, edtPassword, edtPrePassword;
    private Button btnUpdateAccount;
    private ManagePresenterImp managePresenterImp;
    private User nguoi_dung;
    JSONObject saveJsonObject;

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
        edtUserName = findViewById(R.id.txtUserNameManageAccount);
        edtEmail = findViewById(R.id.edtEmailManageAccount);
        edtPassword = findViewById(R.id.edtPasswordManageAccount);
        edtPrePassword = findViewById(R.id.edtConfirmPasswordManageAccount);
        btnUpdateAccount = findViewById(R.id.btnUpdateManageAccount);
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
                managePresenterImp.onButtonUpdateAccountClick(this, nguoi_dung);
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

}

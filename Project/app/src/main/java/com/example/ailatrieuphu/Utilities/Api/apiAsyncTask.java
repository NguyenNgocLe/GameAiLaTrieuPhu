package com.example.ailatrieuphu.Utilities.Api;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.util.Map;

public class apiAsyncTask extends AsyncTask<String, Void, String> implements XuLyJS{
    private String METHOD;
    private Map<String, String> paramets;
    private Context context;
    private String titleProgressBar;
    private String messages;
    ProgressDialog progressDialog;
    private boolean flagProgressBar;
    // hiển thị xử lý có 4 tham số truyền vào
    public apiAsyncTask(Context context,String METHOD, Map<String, String> paramets) {
        this.METHOD = METHOD;
        this.paramets = paramets;
        this.context = context;
    }
    // hiển thị thanh progressbar custom
    public apiAsyncTask(Context context,String METHOD, Map<String, String> paramets, String titleProgressbar, String messages) {
        this.METHOD = METHOD;
        this.paramets = paramets;
        this.context = context;
        this.titleProgressBar = titleProgressbar;
        this.messages = messages;
        flagProgressBar = true;
    }

    @Override
    protected void onPreExecute() {
        if (flagProgressBar) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setTitle(this.titleProgressBar);
            progressDialog.setMessage(this.messages);
            progressDialog.show();
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getJSONData(strings[0], this.METHOD, this.paramets);
    }

    @Override
    protected void onPostExecute(String json) {

        xuLy(context,json);
        // nếu progressbar chưa đc khởi tạo thì dismiss nó đi
        if(flagProgressBar){
            progressDialog.dismiss();
        }
    }

    @Override
    public void xuLy(Context context, String json) {

    }
}

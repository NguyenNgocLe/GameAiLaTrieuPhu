package com.example.ailatrieuphu.PresenterImp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.example.ailatrieuphu.Model.ChooseModel;
import com.example.ailatrieuphu.Utilities.Api.apiAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChoosePresenterImp {
    private Context context;
    ChooseModel model;

    public ChoosePresenterImp(Context context) {
        this.context = context;
        model = new ChooseModel(context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @SuppressLint("StaticFieldLeak")
    public void handlingGetQuestionByCategoryField(Context context) {
        int categoryKey = model.getCategoryId();
        //Log.e("key" + categoryKey + " ");
        (new apiAsyncTask(context, "GET", null, "Load câu hỏi", "Chờ xíu nha...") {

            @Override
            public void xuLy(Context context, String json) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(json);
                    JSONArray jsonArray = (JSONArray) jsonObject.getJSONArray("data");
                    Log.e("json", jsonArray + " ");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).execute("cau-hoi/linh-vuc/" + categoryKey);
    }

    public ChoosePresenterImp() {

    }
}

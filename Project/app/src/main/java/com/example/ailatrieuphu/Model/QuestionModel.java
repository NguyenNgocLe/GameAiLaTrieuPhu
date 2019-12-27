package com.example.ailatrieuphu.Model;

import android.app.Activity;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionModel {

    private String noi_dung;
    private String cau_hoi_a;
    private String cau_hoi_b;
    private String cau_hoi_c;
    private String cau_hoi_d;
    private String dap_an;
    private int id;
    private int linh_vuc_id;
    private int categoryId;
    private Context context;

    public String getNoi_dung() {
        return noi_dung;
    }

    public void setNoi_dung(String noi_dung) {
        this.noi_dung = noi_dung;
    }

    public String getCau_hoi_a() {
        return cau_hoi_a;
    }

    public void setCau_hoi_a(String cau_hoi_a) {
        this.cau_hoi_a = cau_hoi_a;
    }

    public String getCau_hoi_b() {
        return cau_hoi_b;
    }

    public void setCau_hoi_b(String cau_hoi_b) {
        this.cau_hoi_b = cau_hoi_b;
    }

    public String getCau_hoi_c() {
        return cau_hoi_c;
    }

    public void setCau_hoi_c(String cau_hoi_c) {
        this.cau_hoi_c = cau_hoi_c;
    }

    public String getCau_hoi_d() {
        return cau_hoi_d;
    }

    public void setCau_hoi_d(String cau_hoi_d) {
        this.cau_hoi_d = cau_hoi_d;
    }

    public String getDap_an() {
        return dap_an;
    }

    public void setDap_an(String dap_an) {
        this.dap_an = dap_an;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinh_vuc_id() {
        return linh_vuc_id;
    }

    public void setLinh_vuc_id(int linh_vuc_id) {
        this.linh_vuc_id = linh_vuc_id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public QuestionModel(String noi_dung, String cau_hoi_a, String cau_hoi_b, String cau_hoi_c, String cau_hoi_d, String dap_an, int id, int linh_vuc_id, int categoryId, Context context) {
        this.noi_dung = noi_dung;
        this.cau_hoi_a = cau_hoi_a;
        this.cau_hoi_b = cau_hoi_b;
        this.cau_hoi_c = cau_hoi_c;
        this.cau_hoi_d = cau_hoi_d;
        this.dap_an = dap_an;
        this.id = id;
        this.linh_vuc_id = linh_vuc_id;
        this.categoryId = categoryId;
        this.context = context;
    }

    public QuestionModel() {
        categoryId = ((Activity) context).getIntent().getIntExtra("id", 1);
    }

    public QuestionModel(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getInt("id");
            this.cau_hoi_a = jsonObject.getString("cau_hoi_a");
            this.cau_hoi_b = jsonObject.getString("cau_hoi_b");
            this.cau_hoi_c = jsonObject.getString("cau_hoi_c");
            this.cau_hoi_d = jsonObject.getString("cau_hoi_d");
            this.dap_an = jsonObject.getString("dap_an");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void handlingDataField(Context context) {
//        @SuppressLint("StaticFieldLeak") apiAsyncTask apiAsyncTask = new apiAsyncTask(context, "GET", null, "Load lĩnh vực", "Chờ xíu nha") {
//            @Override
//            public void xuLy(Context context, String json) {
//                JSONObject jsonObject = new JSONObject();
//                try {
//                    if (jsonObject.getBoolean("success")) {
//                        Toast.makeText(context, jsonObject + "", Toast.LENGTH_SHORT).show();
//                        new CustomDialog(context, "Thông báo!", "Load lĩnh vực thành công!", CustomDialog.SIZE_M).show();
//                    } else {
//                        new CustomDialog(context, "Thông báo!", "Load lĩnh vực thất bại!", CustomDialog.SIZE_M).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        apiAsyncTask.execute("linh-vuc/danh-sach");
        // Toast.makeText(context, "Vo dc roi nha", Toast.LENGTH_SHORT).show();
    }

}

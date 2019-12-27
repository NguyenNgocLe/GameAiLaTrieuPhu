package com.example.ailatrieuphu.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class FieldModel {
    private int id;
    private String linh_vuc;

    public FieldModel(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getInt("id");
            this.linh_vuc = jsonObject.getString("linh_vuc");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public FieldModel(int id, String linh_vuc) {
        this.id = id;
        this.linh_vuc = linh_vuc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinh_vuc() {
        return linh_vuc;
    }

    public void setLinh_vuc(String linh_vuc) {
        this.linh_vuc = linh_vuc;
    }
}

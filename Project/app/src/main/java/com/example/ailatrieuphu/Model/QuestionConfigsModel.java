package com.example.ailatrieuphu.Model;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionConfigsModel { // cấu hình câu hỏi
    private int thu_tu;
    private int diem;

    public QuestionConfigsModel(JSONObject jsonObject) {
        try {
            this.thu_tu = jsonObject.getInt("thu_tu");
            this.diem = jsonObject.getInt("diem");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getThu_tu() {
        return thu_tu;
    }

    public void setThu_tu(int thu_tu) {
        this.thu_tu = thu_tu;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}

package com.example.ailatrieuphu.Model;

public class PlayerDetailsModel { // chi tiết lượt chơi
    private int luot_choi_id;
    private int cau_hoi_id;
    private int diem;
    private String phuong_an;

    public PlayerDetailsModel(int luot_choi_id, int cau_hoi_id, int diem, String phuong_an) {
        this.luot_choi_id = luot_choi_id;
        this.cau_hoi_id = cau_hoi_id;
        this.diem = diem;
        this.phuong_an = phuong_an;
    }

    public int getLuot_choi_id() {
        return luot_choi_id;
    }

    public void setLuot_choi_id(int luot_choi_id) {
        this.luot_choi_id = luot_choi_id;
    }

    public int getCau_hoi_id() {
        return cau_hoi_id;
    }

    public void setCau_hoi_id(int cau_hoi_id) {
        this.cau_hoi_id = cau_hoi_id;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public String getPhuong_an() {
        return phuong_an;
    }

    public void setPhuong_an(String phuong_an) {
        this.phuong_an = phuong_an;
    }
}

package id.sch.smktelkom_mlg.privateassignment.xirpl108.baymoviesreview;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Bayu on 5/14/2017.
 */

public class IstimewaItem extends SugarRecord implements Serializable {
    public String judul;
    public String deskripsi;
    public String urlgambar;

    public IstimewaItem() {
    }

    public IstimewaItem(String judul, String deskripsi, String urlgambar) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.urlgambar = urlgambar;
    }


}
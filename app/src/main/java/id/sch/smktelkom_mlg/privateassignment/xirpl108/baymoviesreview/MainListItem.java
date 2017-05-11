package id.sch.smktelkom_mlg.privateassignment.xirpl108.baymoviesreview;

/**
 * Created by Bayu on 5/11/2017.
 */

public class MainListItem {
    private String imageUri;
    private String head;
    private String desc;


    public MainListItem(String imageUri, String head, String desc) {

        this.imageUri = imageUri;
        this.head = head;
        this.desc = desc;

    }

    public String getImageUri() {
        return imageUri;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
}

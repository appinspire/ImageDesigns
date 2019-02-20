package com.amanapps.imagedesigns;


import java.util.ArrayList;
import java.util.List;

/*
 * Created by troy379 on 14.09.16.
 */
public final class Demo {
    private Demo() {
        throw new AssertionError();
    }

    public static List<String> getPosters(String base_url, int count) {
        List<String> imageList = new ArrayList<>();
        for(int i=0;i<count;i++){
            imageList.add(base_url+"design"+(i+1)+".jpg?alt=media");
        }
        return imageList;
    }

}

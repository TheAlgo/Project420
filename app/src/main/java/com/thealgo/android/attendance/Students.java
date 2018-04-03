package com.thealgo.android.attendance;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by thealgo on 4/3/18.
 */

@IgnoreExtraProperties
public class Students {
    public List<String> names;
    public String familyname;

    public Students()
    {

    }

    public Students(String familyname,List<String> names) {

        this.familyname = familyname;
        this.names=names;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getNames() {
        return names;
    }
}
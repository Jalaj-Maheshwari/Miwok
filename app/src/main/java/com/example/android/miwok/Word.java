/**
 * Created by Jalaj on 7/10/2016.
 */

package com.example.android.miwok;

public class Word {

    private String mDefaultTranslation; // 'm' to indicate member variable
    private String mMiwokTranslation;
    private int mImageResourceId = -1;


    public Word(String defaultTransalation, String miwokTranslation) {
        mDefaultTranslation = defaultTransalation;
        mMiwokTranslation = miwokTranslation;

    }

    public Word(String defaultTransalation, String miwokTranslation, int ImageResourceId) {
        mDefaultTranslation = defaultTransalation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = ImageResourceId;

    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;

    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

}
package com.example.admin.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 02-08-2017.
 */

public class Products implements Parcelable {
    private int pImage;
    private String pName, pAmount;
    private int pImage1, pImage2, pImage3, pImage4;

    public Products(int pImage, String pName, String pAmount, int pImage1, int pImage2, int pImage3, int pImage4) {
        this.pImage = pImage;
        this.pName = pName;
        this.pAmount = pAmount;

        this.pImage1 = pImage1;
        this.pImage2 = pImage2;
        this.pImage3 = pImage3;
        this.pImage4 = pImage4;
    }

    public int getpImage() {
        return pImage;
    }

    public void setpImage(int pImage) {
        this.pImage = pImage;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAmount() {
        return pAmount;
    }

    public void setpAmount(String pAmount) {
        this.pAmount = pAmount;
    }

    public int getpImage1() {
        return pImage1;
    }

    public void setpImage1(int pImage1) {
        this.pImage1 = pImage1;
    }

    public int getpImage2() {
        return pImage2;
    }

    public void setpImage2(int pImage2) {
        this.pImage2 = pImage2;
    }

    public int getpImage3() {
        return pImage3;
    }

    public void setpImage3(int pImage3) {
        this.pImage3 = pImage3;
    }

    public int getpImage4() {
        return pImage4;
    }

    public void setpImage4(int pImage4) {
        this.pImage4 = pImage4;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.pImage);
        dest.writeString(this.pName);
        dest.writeString(this.pAmount);
        dest.writeInt(this.pImage1);
        dest.writeInt(this.pImage2);
        dest.writeInt(this.pImage3);
        dest.writeInt(this.pImage4);
    }

    protected Products(Parcel in) {
        this.pImage = in.readInt();
        this.pName = in.readString();
        this.pAmount = in.readString();
        this.pImage1 = in.readInt();
        this.pImage2 = in.readInt();
        this.pImage3 = in.readInt();
        this.pImage4 = in.readInt();
    }

    public static final Creator<Products> CREATOR = new Creator<Products>() {
        @Override
        public Products createFromParcel(Parcel source) {
            return new Products(source);
        }

        @Override
        public Products[] newArray(int size) {
            return new Products[size];
        }
    };
}

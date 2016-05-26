package tw.com.ischool.testparcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kevinhuang on 2016/5/26.
 */

public class ExamScore implements Parcelable {

    public String examName;
    public String examID;
    public String score;

    public ExamScore(String name, String id, String score) {
        this.examID = id ;
        this.examName = name ;
        this.score = score ;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.examName);
        dest.writeString(this.examID);
        dest.writeString(this.score);
    }

    protected ExamScore(Parcel in) {
        this.examName = in.readString();
        this.examID = in.readString();
        this.score = in.readString();
    }

    public static final Parcelable.Creator<ExamScore> CREATOR = new Parcelable.Creator<ExamScore>() {
        @Override
        public ExamScore createFromParcel(Parcel source) {
            return new ExamScore(source);
        }

        @Override
        public ExamScore[] newArray(int size) {
            return new ExamScore[size];
        }
    };
}

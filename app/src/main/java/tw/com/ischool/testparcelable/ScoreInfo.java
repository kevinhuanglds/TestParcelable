package tw.com.ischool.testparcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinhuang on 2016/5/26.
 * 這個 Parcelable 物件是先建立好我要的欄位後，再使用 Android Studio plugins 自動產生的，請參考：
 * https://guides.codepath.com/android/Using-Parcelable#passing-data-between-intents
 */

public class ScoreInfo implements Parcelable {

    public String courseID;
    public String subjectName ;

    public ArrayList<ExamScore> scores ;

    public ScoreInfo(String id, String name) {
        this.courseID = id ;
        this.subjectName = name ;
        this.scores = new ArrayList<>();
    }

    public void addExamScore(ExamScore score) {
        this.scores.add(score);
    }

    public List<ExamScore> getScores() {
        return this.scores ;
    }

    //============  以下是自動產生的實作 Parcelable 的 method ============
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.courseID);
        dest.writeString(this.subjectName);
        dest.writeList(this.scores);
    }

    protected ScoreInfo(Parcel in) {
        this.courseID = in.readString();
        this.subjectName = in.readString();
        this.scores = new ArrayList<ExamScore>();
        in.readList(this.scores, ExamScore.class.getClassLoader());
    }

    public static final Parcelable.Creator<ScoreInfo> CREATOR = new Parcelable.Creator<ScoreInfo>() {
        @Override
        public ScoreInfo createFromParcel(Parcel source) {
            return new ScoreInfo(source);
        }

        @Override
        public ScoreInfo[] newArray(int size) {
            return new ScoreInfo[size];
        }
    };
}

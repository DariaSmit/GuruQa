package workWithFilesTest.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Teacher {


 public String name;
 public String lastname;
 @SerializedName("favorite_music")
 public List<String> favoriteMusic;
public Address address;
}

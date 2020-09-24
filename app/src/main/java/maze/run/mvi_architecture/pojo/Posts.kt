package maze.run.mvi_architecture.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Posts(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("userid")
    @Expose
    var userid: Int,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("body")
    @Expose
    var body: String

)
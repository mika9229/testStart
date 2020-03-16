package test.com.demostart.core.api.request

import com.google.gson.annotations.SerializedName

class NameRequest {
    @SerializedName("type")
    var type: String?  = null

    @SerializedName("ipsum")
    var ipsum: String?  = null
}
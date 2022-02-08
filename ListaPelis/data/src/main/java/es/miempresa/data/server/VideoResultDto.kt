package es.miempresa.data.server

import com.google.gson.annotations.SerializedName

data class VideoResultDto(
    @SerializedName("id")val id: Int,
    @SerializedName("results")val results: List<VideoDto>
) {
}
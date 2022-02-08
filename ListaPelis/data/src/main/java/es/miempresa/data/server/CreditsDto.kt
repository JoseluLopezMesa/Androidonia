package es.miempresa.data.server

import com.google.gson.annotations.SerializedName

class CreditsDto(@SerializedName("cast") val cast:List<CastDto>) {
}
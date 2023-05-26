package com.example.netflix
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.netflix.databinding.ActivityReproducirBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class Reproducir : AppCompatActivity() {
    lateinit var binding: ActivityReproducirBinding
    val db = Firebase.firestore
    val videoid= mapOf<String,String>(Pair("La casa de papel","3y-6iaveY6c"),Pair("Narcos","VNP2znpZvUE"),Pair("Stranger Things","x7Yq9MJUqjY&t"),Pair("Entrevías","ZaEPgyZGBeQ"))
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityReproducirBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var sp_r= intent.getStringExtra("sp")
        val docRef=db.collection("Series").document("NgFzA7tWFXYZnrRLzgoS")
        val youTubePlayerView: YouTubePlayerView = binding.youtubePlayerView
        val options: IFramePlayerOptions = IFramePlayerOptions.Builder()
            .controls(0)
            .build()





        docRef.get().addOnSuccessListener { document ->
                if (document != null) {
                    var series=document.data

                    var serie=SP("")
                    for (serienom in series?.keys!!) {

                        if (serienom.equals(sp_r)){
                            binding.spNombre.setText(serienom)
                            val playerListener=object : AbstractYouTubePlayerListener() {
                                override fun onReady(youTubePlayer: YouTubePlayer) {
                                    // loading the selected video into the YouTube Player
                                    youTubePlayer.loadVideo(videoid.get(serienom).toString(), 0.toFloat())

                                }
                            }
                            youTubePlayerView.enableAutomaticInitialization=false
                            youTubePlayerView.initialize(playerListener,options)
                            serie.nombre=serienom
                            serie.descripcion=((series.get(serienom) as Map <*,*>).get("descripción").toString())
                            binding.spDescripcion.setText(serie.descripcion)
                            for (capitulo in ((series.get(serienom) as Map <*,*>).get("capítulos") as Map<*,*>).keys){


                                serie.capitulos.add(SP.Capitulo(capitulo.toString(),(((series.get(serienom) as Map <*,*>).get("capítulos") as Map<*,*>)).get(capitulo).toString()))

                            }
                        }
                    }

                        binding.spNombre.setText(serie.nombre)
                        binding.spDescripcion.setText(serie.descripcion)

                        binding.cap1Nom.setText(serie.capitulos.get(0).nombre_c)
                        binding.cap1Desc.setText(serie.capitulos.get(0).descripcion)
                        binding.cap2Nom.setText(serie.capitulos.get(1).nombre_c)
                        binding.cap2Desc.setText(serie.capitulos.get(1).descripcion)
                        binding.cap3Nom.setText(serie.capitulos.get(2).nombre_c)
                        binding.cap3Desc.setText(serie.capitulos.get(2).descripcion)
                        binding.cap4Nom.setText(serie.capitulos.get(3).nombre_c)
                        binding.cap4Desc.setText(serie.capitulos.get(3).descripcion)
                        binding.cap5Nom.setText(serie.capitulos.get(4).nombre_c)
                        binding.cap5Desc.setText(serie.capitulos.get(4).descripcion)




                } else {
                    Toast.makeText(this, "documento no existe", Toast.LENGTH_SHORT).show()

                }
            }

            .addOnFailureListener { exception ->
                Toast.makeText(this, "fallo  ${exception}", Toast.LENGTH_SHORT).show()

            }

        binding.imageBack.setOnClickListener(){
            this.navigateTo(Contenido::class.java)
        }

    }

}
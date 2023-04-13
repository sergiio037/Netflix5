package com.example.netflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.netflix.databinding.ActivityReproducirBinding

class Reproducir : AppCompatActivity() {
    lateinit var binding: ActivityReproducirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReproducirBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var sp_r= intent.getStringExtra("sp")
        binding.imageBack.setOnClickListener(){
            this.navigateTo(Contenido::class.java)
        }

        var lcp=SP("La casa de papel")
        var narcos=SP("Narcos")
        var entrevias=SP("Entrevias")
        var st=SP("Stranger Things")

        lcp.descripcion="Ocho atracadores toman rehenes en la Fábrica Nacional de Moneda y Timbre española. Desde el encierro, su líder manipula a la policía para llevar a cabo un ambicioso plan."
        lcp.capitulos.add(SP.Capitulo("1. El final del camino","El Profesor se enfrenta a Sierra mientras Tamayo llama al Ejército y sube el listón de las negociaciones. En el pasado, Berlín se reúne con un miembro de su familia."))
        lcp.capitulos.add(SP.Capitulo("2. ¿Crees en la reencarnación?","Arturo aprovecha la oportunidad que se le presenta para tomar represalias y llevar su venganza personal al siguiente nivel. Lisboa hace un descubrimiento crucial."))
        lcp.capitulos.add(SP.Capitulo("3. El espectáculo de la vida","Sierra se ve sorprendida por una traición y una emergencia inesperadas. Palermo reúne a la tropa mientras el Ejército estrecha el cerco a la banda."))
        lcp.capitulos.add(SP.Capitulo("4. Tu sitio en el cielo", "Con la vida de Helsinki en peligro, los atracadores ponen en marcha un contraataque encubierto. Años antes, Berlín y su hijo dan su primer golpe juntos."))
        lcp.capitulos.add(SP.Capitulo("5. Vivir muchas vidas","En medio del tiroteo y atrapada en la cocina, Tokio echa la vista atrás para rememorar su primer amor y... su encuentro inicial con el Profesor."))

        narcos.descripcion="A pesar de un nuevo tratado de extradición, EE UU sigue invirtiendo en la lucha contra el comunismo, lo que vuelve a complicar la caza de Pablo para Murphy y Peña."
        narcos.capitulos.add(SP.Capitulo("1. Descenso","El químico chileno Cucaracha lleva su producto a Escobar, el narco colombiano. Steve Murphy, agente de la DEA, se une a la lucha contra el narcotráfico en Bogotá."))
        narcos.capitulos.add(SP.Capitulo("2. La espada de Simón Bolívar","El grupo radical comunista M-19 actúa contra los narcos. Peña, el nuevo compañero de Murphy, le explica cómo funcionan las fuerzas del orden colombianas."))
        narcos.capitulos.add(SP.Capitulo("3. Los hombres de siempre","Al intentar demostrar que Escobar es un narco para arruinar sus ambiciones políticas, Murphy y Peña se topan con la corrupción del gobierno."))
        narcos.capitulos.add(SP.Capitulo("4. El palacio en llamas", "A pesar de un nuevo tratado de extradición, EE UU sigue invirtiendo en la lucha contra el comunismo, lo que vuelve a complicar la caza de Pablo para Murphy y Peña."))
        narcos.capitulos.add(SP.Capitulo("5. Habrá un futuro","Los métodos extremos de Pablo agravan el enfrentamiento de los narcos con Carrillo y el Gobierno. Peña intenta proteger a Elisa, su testigo."))

        entrevias.descripcion="Cuando su nieta adolescente cae en las garras de los traficantes de drogas que controlan el barrio, un hastiado veterano de guerra decide tomar cartas en el asunto."
        entrevias.capitulos.add(SP.Capitulo("1. Colgar la casaca","Decidida a controlar todo el negocio de la droga en Entrevías, Nata ataca a una banda rival. Tirso, ahora jubilado, dedica sus días a vigilar el barrio pistola en mano."))
        entrevias.capitulos.add(SP.Capitulo("2. Un vagón olvidado","El compañero de trabajo de Jimena le cuenta sus planes inmobiliarios para Entrevías. Ezequiel descubre el punto débil de Nata. Irene comparte sus sueños con su abuelo."))
        entrevias.capitulos.add(SP.Capitulo("3. Escucha al corazón","Amanda encuentra más casos de violación como el de Irene. Gladys trabaja de cocinera en el bar de Pepe. Aún vivo, Ezequiel obtiene una pista sobre el asesino de Santo."))
        entrevias.capitulos.add(SP.Capitulo("4. Padre e hijos", "A pesar de un nuevo tratado de extradición, EE UU sigue invirtiendo en la lucha contra el comunismo, lo que vuelve a complicar la caza de Pablo para Murphy y Peña."))
        entrevias.capitulos.add(SP.Capitulo("5. La cruda verdad","Nelson acepta infiltrarse en la banda para identificar al Fantasma. Irene se va de la lengua. Yeyo le ofrece a Tirso información sobre los violadores... por un precio."))

        st.descripcion="Owens lleva a Ce a Nevada, donde se ve forzada a afrontar su pasado. Los chicos de Hawkins registran una casa derruida en busca de pistas. Vecna se cobra otra víctima."
        st.capitulos.add(SP.Capitulo("1. La desaparición de Will Byers","Cuando vuelve en bici a su casa, Will ve algo horroroso. Cerca de allí, un siniestro secreto acecha en las profundidades de un laboratorio estatal."))
        st.capitulos.add(SP.Capitulo("2. La maldicion de Vecna","Mientras Mike pone rumbo a California, la aparición de un cadáver sacude Hawkins. Nancy sale a buscar pistas. Eddie, muy afectado, le cuenta a la pandilla lo que vio."))
        st.capitulos.add(SP.Capitulo("3. El monstruo y la superheroína","Murray y Joyce vuelan a Alaska. Ce se enfrenta a graves consecuencias. Robin y Nancy investigan el lado oscuro de Hawkins. El Dr. Owens tiene una noticia inquietante."))
        st.capitulos.add(SP.Capitulo("4. Querido Billy", "Max corre un grave peligro... y se está quedando sin tiempo. Un paciente del psiquiátrico Pennhurst recibe una visita. En Rusia, Hopper sigue buscando la forma de huir."))
        st.capitulos.add(SP.Capitulo("5. El proyecto Nina","Owens lleva a Ce a Nevada, donde se ve forzada a afrontar su pasado. Los chicos de Hawkins registran una casa derruida en busca de pistas. Vecna se cobra otra víctima."))

        if(sp_r.equals("La casa de papel")){
            binding.spNombre.setText(lcp.nombre)
            binding.spDescripcion.setText(lcp.descripcion)
            binding.imageViewPresentacion.setImageDrawable(getDrawable(R.drawable.la_casa_de_papel_presentacion))
            binding.cap1Nom.setText(lcp.capitulos.get(0).nombre_c)
            binding.cap1Desc.setText(lcp.capitulos.get(0).descripcion)
            binding.imageViewCap1.setImageDrawable(getDrawable(R.drawable.la_casa_de_papel_cap_1))
            binding.cap2Nom.setText(lcp.capitulos.get(1).nombre_c)
            binding.cap2Desc.setText(lcp.capitulos.get(1).descripcion)
            binding.imageViewCap2.setImageDrawable(getDrawable(R.drawable.la_casa_de_papel_cap_2))
            binding.cap3Nom.setText(lcp.capitulos.get(2).nombre_c)
            binding.cap3Desc.setText(lcp.capitulos.get(2).descripcion)
            binding.imageViewCap1.setImageDrawable(getDrawable(R.drawable.la_casa_de_papel_cap_3))
            binding.cap4Nom.setText(lcp.capitulos.get(3).nombre_c)
            binding.cap4Desc.setText(lcp.capitulos.get(3).descripcion)
            binding.imageViewCap4.setImageDrawable(getDrawable(R.drawable.la_casa_de_papel_cap_4))
            binding.cap5Nom.setText(lcp.capitulos.get(4).nombre_c)
            binding.cap5Desc.setText(lcp.capitulos.get(4).descripcion)
            binding.imageViewCap5.setImageDrawable(getDrawable(R.drawable.la_casa_de_papel_cap_5))
        }
        if(sp_r.equals("Narcos")){
            binding.spNombre.setText(narcos.nombre)
            binding.spDescripcion.setText(narcos.descripcion)
            binding.imageViewPresentacion.setImageDrawable(getDrawable(R.drawable.narcos_portada))
            binding.cap1Nom.setText(narcos.capitulos.get(0).nombre_c)
            binding.cap1Desc.setText(narcos.capitulos.get(0).descripcion)
            binding.imageViewCap1.setImageDrawable(getDrawable(R.drawable.narcos_cap1))
            binding.cap2Nom.setText(narcos.capitulos.get(1).nombre_c)
            binding.cap2Desc.setText(narcos.capitulos.get(1).descripcion)
            binding.imageViewCap2.setImageDrawable(getDrawable(R.drawable.narcos_cap2))
            binding.cap3Nom.setText(narcos.capitulos.get(2).nombre_c)
            binding.cap3Desc.setText(narcos.capitulos.get(2).descripcion)
            binding.imageViewCap3.setImageDrawable(getDrawable(R.drawable.narcos_cap3))
            binding.cap4Nom.setText(narcos.capitulos.get(3).nombre_c)
            binding.cap4Desc.setText(narcos.capitulos.get(3).descripcion)
            binding.imageViewCap4.setImageDrawable(getDrawable(R.drawable.narcos_cap4))
            binding.cap5Nom.setText(narcos.capitulos.get(4).nombre_c)
            binding.cap5Desc.setText(narcos.capitulos.get(4).descripcion)
            binding.imageViewCap5.setImageDrawable(getDrawable(R.drawable.narcos_cap5))
        }
        if(sp_r.equals("Entrevias")){
            binding.spNombre.setText(entrevias.nombre)
            binding.spDescripcion.setText(entrevias.descripcion)
            binding.imageViewPresentacion.setImageDrawable(getDrawable(R.drawable.entrevias_portada))
            binding.cap1Nom.setText(entrevias.capitulos.get(0).nombre_c)
            binding.cap1Desc.setText(entrevias.capitulos.get(0).descripcion)
            binding.imageViewCap1.setImageDrawable(getDrawable(R.drawable.entrevias_cap_1))
            binding.cap2Nom.setText(entrevias.capitulos.get(1).nombre_c)
            binding.cap2Desc.setText(entrevias.capitulos.get(1).descripcion)
            binding.imageViewCap2.setImageDrawable(getDrawable(R.drawable.entrevias_cap_2))
            binding.cap3Nom.setText(entrevias.capitulos.get(2).nombre_c)
            binding.cap3Desc.setText(entrevias.capitulos.get(2).descripcion)
            binding.imageViewCap3.setImageDrawable(getDrawable(R.drawable.entrevias_cap_3))
            binding.cap4Nom.setText(entrevias.capitulos.get(3).nombre_c)
            binding.cap4Desc.setText(entrevias.capitulos.get(3).descripcion)
            binding.imageViewCap4.setImageDrawable(getDrawable(R.drawable.entrevias_cap_4))
            binding.cap5Nom.setText(entrevias.capitulos.get(4).nombre_c)
            binding.cap5Desc.setText(entrevias.capitulos.get(4).descripcion)
            binding.imageViewCap5.setImageDrawable(getDrawable(R.drawable.entrevias_cap_5))
        }
        if(sp_r.equals("Stranger things")){
            binding.spNombre.setText(st.nombre)
            binding.spDescripcion.setText(st.descripcion)
            binding.imageViewPresentacion.setImageDrawable(getDrawable(R.drawable.portada_strager_things))
            binding.cap1Nom.setText(st.capitulos.get(0).nombre_c)
            binding.cap1Desc.setText(st.capitulos.get(0).descripcion)
            binding.imageViewCap1.setImageDrawable(getDrawable(R.drawable.stranger_things_cap_1))
            binding.cap2Nom.setText(st.capitulos.get(1).nombre_c)
            binding.cap2Desc.setText(st.capitulos.get(1).descripcion)
            binding.imageViewCap2.setImageDrawable(getDrawable(R.drawable.stranger_things_cap_2))
            binding.cap3Nom.setText(st.capitulos.get(2).nombre_c)
            binding.cap3Desc.setText(st.capitulos.get(2).descripcion)
            binding.imageViewCap3.setImageDrawable(getDrawable(R.drawable.stranger_things_cap_3))
            binding.cap4Nom.setText(st.capitulos.get(3).nombre_c)
            binding.cap4Desc.setText(st.capitulos.get(3).descripcion)
            binding.imageViewCap4.setImageDrawable(getDrawable(R.drawable.stranger_things_cap_4))
            binding.cap5Nom.setText(st.capitulos.get(4).nombre_c)
            binding.cap5Desc.setText(st.capitulos.get(4).descripcion)
            binding.imageViewCap5.setImageDrawable(getDrawable(R.drawable.stranger_things_cap_5))
        }


    }

}
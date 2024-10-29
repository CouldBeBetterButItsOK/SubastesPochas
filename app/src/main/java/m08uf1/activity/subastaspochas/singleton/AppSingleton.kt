package m08uf1.activity.subastaspochas.singleton
import m08uf1.activity.subastaspochas.models.SubastaObject

class AppSingleton private constructor() {
    private val llistaSubasta:MutableList<SubastaObject> = mutableListOf()

    companion object{
        @Volatile
        private  var instance: AppSingleton? = null
        fun getInstance(): AppSingleton{
            if(instance == null){
                synchronized(this){
                    if (instance == null){
                        instance = AppSingleton()
                    }
                }
            }
            return instance!!
        }
    }

    fun getSubasta(): MutableList<SubastaObject>{
        return this.llistaSubasta
    }
    fun addToSubasta(obj:SubastaObject){
        llistaSubasta.add(obj)
    }
    fun removeFromSubasta(obj: SubastaObject): String{
        val eliminat = llistaSubasta.remove(obj)
        if (eliminat) return obj.nom + " ha estat eliminat correctament"
        else    return obj.nom + "no s'ha pogut trobar"
    }
}
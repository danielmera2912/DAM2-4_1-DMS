class Alumno(){

    var id:Int?= null
    var nombre:String?=null
    var ap1:String?=null
    var ap2:String?=null
    constructor(id:Int,nombre:String,ap1:String,ap2:String) : this() {
        this.id=id
        this.nombre=nombre
        this.ap1=ap1
        this.ap2=ap2
    }
}
class Modulo(){
    companion object {
        const val EVALUACION1 = 0
        const val EVALUACION2 = 1
        const val EVALUACION3 = 2
        const val EVALUACION_FINAL = 3
    }
    var alumnos: Array<Alumno?> = arrayOfNulls(15)
    var notas:Array<Array<Float>> = Array(4) {Array(alumnos.size){-1.0F}}

    private fun sacarEvaluacion (textoEva: String):Int {
        if(textoEva=="EVALUACION1"){
            return 0
        }
        else if (textoEva=="EVALUACION2"){
            return 1
        }
        else if(textoEva=="EVALUACION3"){
            return 2
        }
        else if(textoEva=="EVALUACION_FINAL"){
            return 3
        }
        else{
            return 3
        }
    }

    fun matricularAlumno(alumno: Alumno){
        alumnos+=alumno
    }
    // 13
    fun darBaja(alumno:Alumno){
        alumnos[alumno.id!!]= null
    }
    fun introducirNota(id_Alumno: Int, nota1:Float, nota2:Float, nota3:Float){
        this.notas[EVALUACION1][id_Alumno]= nota1
        this.notas[EVALUACION2][id_Alumno]= nota2
        this.notas[EVALUACION3][id_Alumno]= nota3
        this.notas[EVALUACION_FINAL][id_Alumno]= (nota1+nota2+nota3)/3
    }
    // 3
    fun listaNotas(evaluacion:String="EVALUACION_FINAL"): String{
        val evNum=sacarEvaluacion(evaluacion)
        var textoNotas:String=" s "
        try{
            for(i in this.alumnos.indices){
                textoNotas=textoNotas+notas[evNum][i]+"\n"
            }
        }catch (e: Exception){

        }
        return textoNotas
    }
    // 4
    fun numeroAprobados(evaluacion:String="EVALUACION_FINAL"): Int{
        val evNum=sacarEvaluacion(evaluacion)
        var cont:Int=0
        try{
            for (i in this.alumnos.indices){
                if(notas[evNum][i]>=5.0f){
                    cont++
                }
            }
        }catch (e: Exception){

        }

        return cont
    }
    // 5
    fun notaMasBaja(evaluacion:String="EVALUACION_FINAL"):Float{
        val evNum=sacarEvaluacion(evaluacion)
        var numActual=10.0f
        var numMenor=10.0f
        try{
            for (i in this.alumnos.indices){
                numActual=notas[evNum][i]
                if (numActual<=numMenor){
                    numMenor = numActual;
                }
            }
        }catch (e: Exception){

        }

        return numMenor
    }
    // 6
    fun notaMasAlta(evaluacion:String="EVALUACION_FINAL"): Float{
        val evNum=sacarEvaluacion(evaluacion)
        var numActual=0.0f
        var numMayor=0.0f
        try{
            for (i in this.alumnos.indices){
                numActual=notas[evNum][i]
                if (numActual>=numMayor){
                    numMayor = numActual;
                }
            }
        }catch (e: Exception){

        }

        return numMayor
    }
    // 7
    fun notaMedia(evaluacion:String="EVALUACION_FINAL"): Float{
        val evNum=sacarEvaluacion(evaluacion)
        var num1=0.0f
        var numTotal=0.0f
        var cont=0.0f
        try{
            for (i in this.alumnos.indices){
                num1=notas[evNum][i]
                numTotal=+num1
                cont++
            }
            numTotal=numTotal/cont
        }catch (e:Exception){

        }

        return numTotal
    }
    // 8
    fun hayAlumnosConDiez(evaluacion:String="EVALUACION_FINAL"): Boolean{
        val evNum=sacarEvaluacion(evaluacion)
        return notas[evNum].any{ it == 10.0f }
    }
    // 9
    fun hayAlumnosAprobados(evaluacion:String="EVALUACION_FINAL"): Boolean{
        val evNum=sacarEvaluacion(evaluacion)
        return notas[evNum].any{ it >= 5.0f }
    }
    // 10
    fun primeraNotaNoAprobada(evaluacion:String="EVALUACION_FINAL"): Float? {
        val evNum=sacarEvaluacion(evaluacion)
        return notas[evNum].find{ it >= 5.0f }
    }
    // 11
    fun listaNotasOrdenados(evaluacion:String="EVALUACION_FINAL"): String {
        val evNum=sacarEvaluacion(evaluacion)
        return " "+notas[evNum].sort()
    }

}
fun main(args: Array<String>) {
    // comprobar 1
    var ada=Modulo()
    var a1=Alumno(1,"Juan","Perez","Perez")
    var a2=Alumno(2,"Pedro","Perez","Perez")
    var a3=Alumno(3,"Lucas","Perez","Perez")
    var a4=Alumno(4,"Adolfo","Perez","Perez")
    var a5=Alumno(5,"Aida","Perez","Perez")
    var a6=Alumno(6,"Jazzmin","Perez","Perez")
    var a7=Alumno(7,"Julia","Perez","Perez")
    var a8=Alumno(8,"Julio","Perez","Perez")
    var a9=Alumno(9,"Pepe","Perez","Perez")
    var a10=Alumno(10,"Antonio","Perez","Perez")
    // comprobar 12
    ada.matricularAlumno(a1)
    ada.matricularAlumno(a2)
    ada.matricularAlumno(a3)
    ada.matricularAlumno(a4)
    ada.matricularAlumno(a5)
    ada.matricularAlumno(a6)
    ada.matricularAlumno(a7)
    ada.matricularAlumno(a8)
    ada.matricularAlumno(a9)
    ada.matricularAlumno(a10)
    // comprobar 1
    ada.introducirNota(1,4.0f,5.0f,4.0f)
    ada.introducirNota(2,5.0f,5.0f,2.0f)
    ada.introducirNota(3,4.0f,5.0f,5.0f)
    ada.introducirNota(4,2.0f,5.0f,2.0f)
    ada.introducirNota(5,1.0f,5.0f,1.0f)
    ada.introducirNota(6,4.0f,5.0f,0.0f)
    ada.introducirNota(7,3.0f,5.0f,2.0f)
    ada.introducirNota(8,4.0f,5.0f,3.0f)
    ada.introducirNota(9,1.0f,5.0f,4.0f)
    ada.introducirNota(10,4.0f,6.0f,0.0f)

    // comprobar 2
    println(ada.notas[3][1])
    // comprobar 3
    println(ada.listaNotas())
    // comprobar 4
    println(ada.numeroAprobados())
    // comprobar 5
    println(ada.notaMasBaja())
    // comprobar 6
    println(ada.notaMasAlta())
    // comprobar 7
    println(ada.notaMedia())
    // comprobar 8
    println(ada.hayAlumnosConDiez())
    // comprobar 9
    println(ada.hayAlumnosAprobados())
    // comprobar 10
    println(ada.primeraNotaNoAprobada())
    // comprobar 11
    println(ada.listaNotasOrdenados())

    // comprobar 13
    ada.darBaja(a10)
}
package mx.tecnm.tepic.ladm_u4_practica1_canvas_y_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class Imagen(punteroLienzo: Lienzo, posX : Float, posY : Float, nombreImagen: Int) {
    var x = posX
    var y = posY
    var imagen = BitmapFactory.decodeResource(punteroLienzo.resources, nombreImagen)

    fun pintar(c: Canvas) {
        c.drawBitmap(imagen, x, y, Paint())
    }

}
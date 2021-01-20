package mx.tecnm.tepic.ladm_u4_practica1_canvas_y_sensores

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Lienzo (p:MainActivity) : View(p) {

    var cX = 100f
    var siProximidad = true
    var img = Imagen(this, 500f,1000f,R.drawable.contento)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        if (siProximidad) {
            // RECTANGULO DE MITAD HACIA ARRIBA CIELO
            p.setColor(Color.argb(255, 3,169,244))
            c.drawRect(0f,0f,1080f,1065f,p)

            // RECTANGULO DE MITAD HACIA ABAJO PASTO
            p.setColor(Color.argb(255,27,94,32))
            c.drawRect(0f,1065f,1080f,2131f,p)

            // Nubes
            p.style = Paint.Style.FILL
            p.setColor(Color.argb(255,145,145,140))
            cX = 100f
            for (i in 0..2){
                c.drawCircle(cX,200f,75f,p)
                cX += 75f
            }
            cX = 510f
            for (i in 0..2){
                c.drawCircle(cX,300f,75f,p)
                cX += 75f
            }
            cX = 810f
            for (i in 0..2){
                c.drawCircle(cX,150f,75f,p)
                cX += 75f
            }

            // Troncos
            p.style = Paint.Style.FILL
            p.setColor(Color.argb(255, 80,45,30))
            c.drawRect(200f,800f, 300f,1065f,p)
            c.drawRect(880f,800f, 780f,1065f,p)

            // Arboles
            p.setColor(Color.argb(255,27,94,32))
            c.drawCircle(250f,605f,200f,p)
            c.drawCircle(830f,605f,200f,p)

            img.imagen = BitmapFactory.decodeResource(resources, R.drawable.contento)
            img.pintar(c)

        } else {
            // RECTANGULO DE MITAD HACIA ARRIBA CIELO
            p.setColor(Color.argb(255, 63,81,181))
            c.drawRect(0f,0f,1080f,1065f,p)

            // RECTANGULO DE MITAD HACIA ABAJO PASTO
            p.setColor(Color.argb(255,27,94,32))
            c.drawRect(0f,1065f,1080f,2131f,p)

            //LUNA
            p.strokeWidth = 7f
            p.setColor(Color.argb(255,235,230,210))
            c.drawCircle(540f,200f,150f,p)
            p.style = Paint.Style.STROKE
            p.setColor(Color.BLACK)
            c.drawCircle(540f,200f,150f,p)

            // Nubes
            p.style = Paint.Style.FILL
            p.setColor(Color.argb(255,145,145,140))
            cX = 100f
            for (i in 0..2){
                c.drawCircle(cX,200f,75f,p)
                cX += 75f
            }
            cX = 510f
            for (i in 0..2){
                c.drawCircle(cX,300f,75f,p)
                cX += 75f
            }
            cX = 810f
            for (i in 0..2){
                c.drawCircle(cX,150f,75f,p)
                cX += 75f
            }

            // Troncos
            p.style = Paint.Style.FILL
            p.setColor(Color.argb(255, 80,45,30))
            c.drawRect(200f,800f, 300f,1065f,p)
            c.drawRect(880f,800f, 780f,1065f,p)

            // Arboles
            p.setColor(Color.argb(255,27,94,32))
            c.drawCircle(250f,605f,200f,p)
            c.drawCircle(830f,605f,200f,p)

            img.imagen = BitmapFactory.decodeResource(resources, R.drawable.chico)
            img.pintar(c)
        }

        invalidate()

    }

    fun moverImagen (x : Float, y : Float) {
        img.x += x*(-1)
        img.y += y
        if (img.x<=0){
            img.x = 0f
        }
        if (img.x>=width-img.imagen.height){
            img.x = width.toFloat()-img.imagen.height
        }
        if (img.y<=0){
            img.y = 0f
        }
        if (img.y>=height-img.imagen.width){
            img.y = height.toFloat()-img.imagen.width
        }

        invalidate()
    }
}
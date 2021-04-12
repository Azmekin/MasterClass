package ru.skillbranch.masterclass

import android.content.Context
import android.content.Context.CAMERA_SERVICE
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.skillbranch.masterclass.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   lateinit var BClass : ActivityMainBinding
   var Color=0
   //var context:Context=applicationContext


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(BClass.root)
        var cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        var cameraId:String=cameraManager.cameraIdList[0]
        BClass.b1.setOnClickListener {
            if (Color == 0) {
                BClass.lighter.setBackgroundColor(android.graphics.Color.WHITE)
                BClass.b1.text = "Выключить фонарик"
                BClass.TestText.text="Фонарик работает"
                Color = 1
                try {

                    cameraManager.setTorchMode(cameraId, true) //Turn ON
                } catch (e: CameraAccessException) {
                    e.printStackTrace()
                }
            } else {
                BClass.lighter.setBackgroundColor(android.graphics.Color.BLACK)
                BClass.b1.text = "Включить фонарик"
                BClass.TestText.text="Включите фонарик"
                Color = 0
                try {
                    cameraManager.setTorchMode(cameraId, false) //Turn Off
                } catch (e: CameraAccessException) {
                    e.printStackTrace()
                }

            }
        }
    }


}

package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val editText1: EditText = findViewById(R.id.call_number)
        val ocamera = findViewById<Button>(R.id.button4)
        ocamera.setOnClickListener {
            val ocamera: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (ocamera.resolveActivity(packageManager) != null) {
                startActivity(ocamera)
            }
        }
        val omcall: Button = findViewById(R.id.button2)
        omcall.setOnClickListener {

            val phone: Uri = Uri.parse("tel:" + editText1.text.toString())
            val intent: Intent = Intent(Intent.ACTION_CALL, phone)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Enter Valid Phone", Toast.LENGTH_SHORT).show()
            }
        }
        val ocalllog: Button = findViewById(R.id.button6)
        ocalllog.setOnClickListener {
            val ocalllog_intent: Intent = Intent(Intent.ACTION_VIEW)
            ocalllog_intent.setType(CallLog.Calls.CONTENT_TYPE)
            startActivity(ocalllog_intent)
        }

        val ocontact: Button = findViewById(R.id.button3)
        ocontact.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        val ogalley: Button = findViewById(R.id.button5)
        ogalley.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
        val ourl: Button = findViewById(R.id.button)
        ourl.setOnClickListener {
            val editText: EditText = findViewById(R.id.editTextTextPersonName)
            val url: Uri = Uri.parse(editText.text.toString())
            val intent: Intent = Intent(Intent.ACTION_VIEW, url)
            if (intent.resolveActivity(packageManager) != null)
                startActivity(intent)
        }
       // val osetalarm: Button = findViewById(R.id.button7)
        //osetalarm.setOnClickListener {
          //  val oalarm_intent: Intent = Intent(this, setalarm::class.java)
            //startActivity(oalarm_intent)
        //}

    }
}
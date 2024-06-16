

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener

class MainActivity : AppCompatActivity() {
    var number : EditText? =null
    var button : Button? =null
    var arrayList = arrayOf("Add","sub","Rest")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        number = findViewById(R.id.number)
        button = findViewById(R.id.button)
        button?.setOnClickListener {
            AlertDialog.Builder(this)
                .apply {
                    val number1 = number?.text.toString().toIntOrNull() ?: 0
                    setTitle("Calculation :")
                    setMessage("1) Press 'ADD' to Add + ${number1},\n" +
                            "2) Press 'SUB' to sub - ${number1},\n" +
                            "3) Press 'NEUTRAL' to Reset \n")
                    setCancelable(false)
                    setPositiveButton("Positive", { _, _ ->
                        val number1 = number?.text.toString().toIntOrNull() ?: 0
                        val result = number1 + number1
                        number?.setText(result.toString())
                        Toast.makeText(this@MainActivity, "Added", Toast.LENGTH_SHORT).show()
                    })
                    setNegativeButton("Negative", { _, _ ->
                        val number1 = number?.text.toString().toIntOrNull() ?: 0
                        val result = number1 - number1
                        number?.setText(result.toString())
                        Toast.makeText(this@MainActivity, "Subtracted", Toast.LENGTH_SHORT).show()
                    })
                    setNeutralButton("Rest", { _, _ ->
                        val number1 = number?.text.toString().toIntOrNull() ?: 0
                        val result = 0
                        number?.setText(result.toString())
                        Toast.makeText(this@MainActivity, "Reset", Toast.LENGTH_SHORT).show()
                    })
                    show()
                }
        }
    }
}
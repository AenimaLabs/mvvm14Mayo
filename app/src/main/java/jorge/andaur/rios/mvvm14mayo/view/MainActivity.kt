package jorge.andaur.rios.mvvm14mayo.view

import android.os.Bundle
import android.text.SpannableString
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jorge.andaur.rios.mvvm14mayo.R
import jorge.andaur.rios.mvvm14mayo.model.User
import jorge.andaur.rios.mvvm14mayo.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val textViewGreeting = findViewById<TextView>(R.id.textViewGreeting)
        val buttonGenerateGreeting = findViewById<Button>(R.id.buttonSubmit)

        //Observa el nombre ingresado por el usuario
        viewModel.user.observe(this) { user ->
            editTextName.setText(user.name)
        }

        //Observa el saludo generado por el ViewModel
        viewModel.greeting.observe(this) { greeting ->
//            val spannableGreeting = SpannableString(greeting)
//            textViewGreeting.text = spannableGreeting
            textViewGreeting.text = greeting
        }

        //Activa el botón para generar el saludo
        buttonGenerateGreeting.setOnClickListener {
            val name = editTextName.text.toString()
            viewModel.setUser(name)
            viewModel.generateGreeting()
        }
    }
}
package stan_atilovich.harry_potter_and_retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import stan_atilovich.harry_potter_and_retrofit.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
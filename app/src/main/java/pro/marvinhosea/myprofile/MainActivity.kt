package pro.marvinhosea.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pro.marvinhosea.myprofile.models.Service

class MainActivity : AppCompatActivity() {

    val services = Service("Carpentry", 700,"We make art from carpentry");

    internal lateinit var showNextServiceButton: Button
    internal lateinit var serviceNameView: TextView
    internal lateinit var serviceDescriptionView: TextView
    internal lateinit var servicePrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNextServiceButton = findViewById(R.id.showNextServiceButton)
        serviceNameView = findViewById(R.id.serviceName)
        serviceDescriptionView = findViewById(R.id.serviceDescription)
        servicePrice = findViewById(R.id.servicePrice)

        //Listen to show next service button click
        showNextServiceButton.setOnClickListener { view ->
            displayServiceDetail()
        }
    }

    /**
     * This method display the selected random business
     */
    private fun displayServiceDetail() {
        serviceNameView.text = getString(R.string.serviceName, services.name)
        serviceDescriptionView.text = getString(R.string.serviceDescription, services.description)
        servicePrice.text = getString(R.string.servicePrice, services.price)
    }



}
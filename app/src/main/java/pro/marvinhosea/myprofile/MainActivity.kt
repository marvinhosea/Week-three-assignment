package pro.marvinhosea.myprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pro.marvinhosea.myprofile.controllers.ServiceController
import pro.marvinhosea.myprofile.models.Service

class MainActivity : AppCompatActivity() {

    //Retrieve
    val serviceController = ServiceController()

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
     * This method display the selected random business service
     */
    private fun displayServiceDetail() {

        val service = getRandomService()
        serviceNameView.text = getString(R.string.serviceName, service.name)
        serviceDescriptionView.text = getString(R.string.serviceDescription, service.description)
        servicePrice.text = getString(R.string.servicePrice, service.price)
    }

    private fun getRandomService(): Service {
        return serviceController.getSingleService()
    }

}
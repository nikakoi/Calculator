import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.R

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private var operand1: Double? = null
    private var operand2: Double? = null
    private var operator: Char? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

        val button0: Button = findViewById(R.id.button0)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)

        val buttonAdd: Button = findViewById(R.id.buttonPlus)
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        val buttonMultiply: Button = findViewById(R.id.buttonMultiply)
        val buttonDivide: Button = findViewById(R.id.buttonDivide)
        val buttonEqual: Button = findViewById(R.id.buttonEqual)
        val buttonClear: Button = findViewById(R.id.buttonAC)

        val buttonList = listOf(
            button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9,
            buttonAdd, buttonMinus, buttonMultiply, buttonDivide,
            buttonEqual, buttonClear
        )

        for (button in buttonList) {
            button.setOnClickListener(View.OnClickListener {
                val input = button.text.toString()
                when (input) {
                    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                        if (resultTextView.text.toString() == "0") {
                            resultTextView.text = input
                        } else {
                            resultTextView.append(input)
                        }
                    }
                    "+", "-", "*", "/" -> {
                        operand1 = resultTextView.text.toString().toDouble()
                        operator = input[0]
                        resultTextView.text = "0"
                    }
                    "=" -> {
                        operand2 = resultTextView.text.toString().toDouble()
                        when (operator) {
                            '+' -> resultTextView.text = (operand1?.plus(operand2!!)).toString()
                            '-' -> resultTextView.text = (operand1?.minus(operand2!!)).toString()
                            '*' -> resultTextView.text = (operand1?.times(operand2!!)).toString()
                            '/' -> {
                                if (operand2 == 0.0) {
                                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                                    resultTextView.text = "0"
                                } else {
                                    resultTextView.text = (operand1?.div(operand2!!)).toString()
                                }
                            }
                        }
                    }
                    "AC" -> {
                        resultTextView.text = "0"
                    }
                }
            })
        }
    }
}
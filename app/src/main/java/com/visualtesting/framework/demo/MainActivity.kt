package com.visualtesting.framework.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createDemoLayout())
        setupDemoContent()
    }

    private fun createDemoLayout(): View {
        val scrollView = ScrollView(this)
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        // Header
        val headerText = MaterialTextView(this).apply {
            text = "Visual Testing Demo"
            textSize = 24f
            setPadding(0, 0, 0, 32)
            setTextColor(ContextCompat.getColor(context, android.R.color.black))
        }
        mainLayout.addView(headerText)

        // Form Card
        val formCard = MaterialCardView(this).apply {
            setPadding(24, 24, 24, 24)
            cardElevation = 8f
            radius = 16f
            setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        }

        val formLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        // Text Input
        val textInput = TextInputLayout(this).apply {
            hint = "Enter your name"
            setPadding(0, 0, 0, 16)
        }
        formLayout.addView(textInput)

        // Buttons
        val buttonLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, 16, 0, 16)
        }

        val primaryButton = MaterialButton(this).apply {
            text = "Primary Action"
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_blue_bright))
            setTextColor(ContextCompat.getColor(context, android.R.color.white))
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                setMargins(0, 0, 16, 0)
            }
        }

        val secondaryButton = MaterialButton(this).apply {
            text = "Secondary"
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.darker_gray))
            setTextColor(ContextCompat.getColor(context, android.R.color.white))
            layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        }

        buttonLayout.addView(primaryButton)
        buttonLayout.addView(secondaryButton)
        formLayout.addView(buttonLayout)

        // Switches and Checkboxes
        val controlsLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, 16, 0, 0)
        }

        val checkbox = MaterialCheckBox(this).apply {
            text = "Enable notifications"
            isChecked = true
        }
        controlsLayout.addView(checkbox)

        val switch = SwitchMaterial(this).apply {
            text = "Dark mode"
            isChecked = false
        }
        controlsLayout.addView(switch)

        formLayout.addView(controlsLayout)
        formCard.addView(formLayout)
        mainLayout.addView(formCard)

        // Status Section
        val statusLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, 32, 0, 0)
        }

        val statusTitle = MaterialTextView(this).apply {
            text = "Status Information"
            textSize = 18f
            setPadding(0, 0, 0, 16)
            setTextColor(ContextCompat.getColor(context, android.R.color.black))
        }
        statusLayout.addView(statusTitle)

        val statusItems = listOf(
            "✓ Light theme support",
            "✓ Dark theme support",
            "✓ RTL layout support",
            "✓ Multiple font scales",
            "✓ Various device sizes",
            "✓ Screenshot comparison"
        )

        statusItems.forEach { item ->
            val statusText = MaterialTextView(this).apply {
                text = item
                textSize = 14f
                setPadding(0, 4, 0, 4)
                setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray))
            }
            statusLayout.addView(statusText)
        }

        mainLayout.addView(statusLayout)
        scrollView.addView(mainLayout)
        return scrollView
    }

    private fun setupDemoContent() {
        // Additional setup if needed
    }
} 
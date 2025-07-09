package com.snapdroid.framework.demo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var profileCard: MaterialCardView
    private lateinit var nameInputLayout: TextInputLayout
    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var emailEditText: TextInputEditText
    
    private lateinit var preferencesCard: MaterialCardView
    private lateinit var notificationsSwitch: SwitchCompat
    private lateinit var darkModeSwitch: SwitchCompat
    private lateinit var biometricsSwitch: SwitchCompat
    
    private lateinit var actionsCard: MaterialCardView
    private lateinit var saveButton: MaterialButton
    private lateinit var resetButton: MaterialButton
    private lateinit var deleteButton: MaterialButton
    
    private lateinit var statusCard: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupToolbar()
        initViews()
        setupListeners()
        setupAccessibility()
    }

    private fun setupToolbar() {
        title = "📸 SnapDroid Demo"
        supportActionBar?.subtitle = "Visual Testing Made Simple"
    }

    private fun initViews() {
        // Profile card views
        profileCard = findViewById(R.id.profileCard)
        nameInputLayout = findViewById(R.id.nameInputLayout)
        nameEditText = findViewById(R.id.nameEditText)
        emailInputLayout = findViewById(R.id.emailInputLayout)
        emailEditText = findViewById(R.id.emailEditText)
        
        // Preferences card views
        preferencesCard = findViewById(R.id.preferencesCard)
        notificationsSwitch = findViewById(R.id.notificationsSwitch)
        darkModeSwitch = findViewById(R.id.darkModeSwitch)
        biometricsSwitch = findViewById(R.id.biometricsSwitch)
        
        // Actions card views
        actionsCard = findViewById(R.id.actionsCard)
        saveButton = findViewById(R.id.saveButton)
        resetButton = findViewById(R.id.resetButton)
        deleteButton = findViewById(R.id.deleteButton)
        
        // Status card
        statusCard = findViewById(R.id.statusCard)
        
        // Set default values
        nameEditText.setText("John Doe")
        emailEditText.setText("john.doe@example.com")
        notificationsSwitch.isChecked = true
        darkModeSwitch.isChecked = false
        biometricsSwitch.isChecked = true
    }

    private fun setupListeners() {
        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            
            if (name.isNotEmpty() && email.isNotEmpty()) {
                Toast.makeText(this, "✅ Changes saved successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "❌ Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
        
        resetButton.setOnClickListener {
            resetToDefaults()
            Toast.makeText(this, "🔄 Reset to defaults", Toast.LENGTH_SHORT).show()
        }
        
        deleteButton.setOnClickListener {
            androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("⚠️ Delete Account")
                .setMessage("Are you sure you want to delete your account? This action cannot be undone.")
                .setPositiveButton("Delete") { _, _ ->
                    Toast.makeText(this, "🗑️ Account deleted", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel", null)
                .show()
        }
        
        notificationsSwitch.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "📱 Notifications enabled" else "🔇 Notifications disabled"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
        
        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "🌙 Dark mode enabled" else "☀️ Light mode enabled"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            updateTheme(isChecked)
        }
        
        biometricsSwitch.setOnCheckedChangeListener { _, isChecked ->
            val message = if (isChecked) "👆 Biometric login enabled" else "🔑 Password login only"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupAccessibility() {
        profileCard.contentDescription = "User Profile Section"
        preferencesCard.contentDescription = "Preferences Section"
        actionsCard.contentDescription = "Actions Section"
        statusCard.contentDescription = "System Status"
        
        nameInputLayout.hint = "👤 Full Name"
        emailInputLayout.hint = "✉️ Email Address"
        
        saveButton.contentDescription = "Save all changes"
        resetButton.contentDescription = "Reset all settings to defaults"
        deleteButton.contentDescription = "Delete user account permanently"
        
        notificationsSwitch.contentDescription = "Toggle push notifications"
        darkModeSwitch.contentDescription = "Toggle dark mode theme"
        biometricsSwitch.contentDescription = "Toggle biometric authentication"
    }

    private fun resetToDefaults() {
        nameEditText.setText("John Doe")
        emailEditText.setText("john.doe@example.com")
        notificationsSwitch.isChecked = true
        darkModeSwitch.isChecked = false
        biometricsSwitch.isChecked = true
    }

    private fun updateTheme(isDarkMode: Boolean) {
        if (isDarkMode) {
            // Update card colors for dark theme
            val darkColor = ContextCompat.getColor(this, android.R.color.background_dark)
            profileCard.setCardBackgroundColor(darkColor)
            preferencesCard.setCardBackgroundColor(darkColor)
            actionsCard.setCardBackgroundColor(darkColor)
            statusCard.setCardBackgroundColor(darkColor)
        } else {
            // Update card colors for light theme
            val lightColor = ContextCompat.getColor(this, android.R.color.background_light)
            profileCard.setCardBackgroundColor(lightColor)
            preferencesCard.setCardBackgroundColor(lightColor)
            actionsCard.setCardBackgroundColor(lightColor)
            statusCard.setCardBackgroundColor(lightColor)
        }
    }
} 
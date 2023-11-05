package com.vallente.animal.midterm

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class ManageBlockActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manage_block)
        title = "Manage Block Animals"
    }
    @Deprecated("This method is intentionally overridden due to deprecation in the parent class.")
    override fun onBackPressed() {
        val intent = Intent(this@ManageBlockActivity, AnimalNamesActivity::class.java)
        startActivity(intent)
        finish()
    }
}

package com.example.kiemtra_laptrinhungdungdidong_2374802010451

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ View bắt buộc dùng findViewById truyền thống
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // 1. Kiểm tra bỏ trống
            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.setTextColor(resources.getColor(android.R.color.holo_red_dark, theme))
                tvStatus.text = "Lỗi: Email hoặc Mật khẩu không được để trống!"
                return@setOnClickListener
            }

            // 2. Kiểm tra định dạng Email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.setTextColor(resources.getColor(android.R.color.holo_red_dark, theme))
                tvStatus.text = "Lỗi: Định dạng Email không hợp lệ!"
                return@setOnClickListener
            }

            // 3. Kiểm tra độ dài mật khẩu (< 6 ký tự)
            if (password.length < 6) {
                tvStatus.setTextColor(resources.getColor(android.R.color.holo_red_dark, theme))
                tvStatus.text = "Lỗi: Mật khẩu phải có ít nhất 6 ký tự!"
                return@setOnClickListener
            }

            // 4. Dữ liệu hợp lệ -> Hiển thị thành công và chuyển màn hình (Câu 2)
            tvStatus.setTextColor(resources.getColor(android.R.color.holo_green_dark, theme))
            tvStatus.text = "Xác thực thành công!"

            // Khởi tạo Intent chuyển sang ProfileActivity và truyền Email qua Bundle (putExtra)
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("USER_EMAIL", email)
            }
            startActivity(intent)
        }
    }
}
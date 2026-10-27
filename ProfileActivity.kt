package com.example.kiemtra_laptrinhungdungdidong_2374802010451

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var lvSubjects: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ View bằng findViewById
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)
        lvSubjects = findViewById(R.id.lvSubjects)

        // NHẬN DỮ LIỆU CÂU 2: Trích xuất chuỗi Email truyền qua Intent
        val email = intent.getStringExtra("USER_EMAIL") ?: "Không có dữ liệu"
        tvUserEmail.text = "Email: $email"

        // XỬ LÝ ĐĂNG XUẤT CÂU 2: Gọi finish() để đóng màn hình hiện tại và quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }

        // CÂU 3: Khởi tạo mảng gồm ít nhất 5 môn học/kỹ năng mẫu
        val subjectsList = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // Gắn ArrayAdapter với layout mẫu android.R.layout.simple_list_item_1
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            subjectsList
        )
        lvSubjects.adapter = adapter

        // Bắt sự kiện Click trên từng item của ListView, hiển thị Toast chính xác tên phần tử
        lvSubjects.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = subjectsList[position]
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
        }
    }
}
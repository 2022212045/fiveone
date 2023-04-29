package com.example.fiveone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.fiveone.databinding.ActivityMainBinding
import com.example.fiveone.databinding.ActivityRegisteredBinding
import kotlin.text.Typography.registered

class RegisteredActivity : AppCompatActivity() {
    private val mBinding: ActivityRegisteredBinding by lazy {
        ActivityRegisteredBinding.inflate(layoutInflater) }
    private var isGender = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        //back()
        initView()
    }

    private fun initView() {

        //注册按钮点击事件
        mBinding.registered.setOnClickListener {
            //获取到输入框的值
            val name = mBinding.counter.text.trim()
            val password = mBinding.password.text.trim()
            //判断是否为空
            if (!TextUtils.isEmpty(name) and !TextUtils.isEmpty(password)) {
                //判断两次密码是否一致
                //注册
                val user = MyUser()
                user.setUsername(name.toString())
                user.setPassword(password.toString())
                Toast.makeText(RegisteredActivity(), "注册成功", Toast.LENGTH_SHORT).show()
//                    user.signUp(object : SaveListener<MyUser>() {
//                        override fun done(user: MyUser, e: BmobException) {
//                            if (e == null) {
//                                Toast.makeText(RegisteredActivity(),"注册成功",Toast.LENGTH_SHORT).show()
//                                finish()
//                            } else {
//                                Toast.makeText(RegisteredActivity(),"注册失败",Toast.LENGTH_SHORT).show()
//                            }
//                        }
//                    })
            } else {
                Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show()
            }
        }
//            }else{
//            Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show()
//        }
            }
        }



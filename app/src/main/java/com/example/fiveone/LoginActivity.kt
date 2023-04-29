package com.example.fiveone

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fiveone.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val mBinding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        initView()
    }
    private fun initView() {
//        //设置选择状态
//        val isCheck = ShareUtils().getBoolean(this,"keeppass",false)
//        keep_password.isChecked = isCheck
//        if(isCheck){
//            //设置密码
//            mBinding.counter.setText(ShareUtils().getString(this,"name",""))
//            mBinding.password.setText(ShareUtils().getString(this,"password",""))
//        }
        //注册按钮
        mBinding.registered?.setOnClickListener {
            startActivity(Intent(this, RegisteredActivity::class.java))
        }

        //登录按钮
        mBinding.login.setOnClickListener {
            //1.获取输入框的值
            val name = mBinding.counter?.text.toString().trim()
            val password = mBinding.password.text.toString().trim()
            //2.判断是否为空
            if(!TextUtils.isEmpty(name) and !TextUtils.isEmpty(password)){
                //3.登录
                val user = MyUser()
                user.setUsername(name)
                user.setPassword(password)
//                user.login(object : SaveListener<MyUser>() {
//                    override fun done(bmobUser: MyUser?, e: BmobException) {
//                        if (e == null) {
//                            //val user: MyUser = BmobUser.getCurrentUser(MyUser::class.java)
//                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
//                            finish()
//                        } else {
//                            L.i(e.toString())
//                            Toast.makeText(this@LoginActivity,"登录失败", Toast.LENGTH_SHORT).show()
//                            //startActivity(Intent(this@LoginActivity,MainActivity::class.java))
//                            //finish()
//                        }
//
//
//                    }
//                })
                //L().i("用户名："+name)
                //L().i("密码："+password)


            }else{
                Toast.makeText(this,"输入框不能为空", Toast.LENGTH_SHORT).show()
            }
        }

    }
//   // 假设我现在输入用户名和密码，但是我不点击登录，就直接提出了
//    override fun onDestroy() {
//        super.onDestroy()
//
//        //保存状态
//        ShareUtils().putBoolean(this,"keeppass",keep_password.isChecked)
//
//        //是否记住密码
//        if(keep_password.isChecked){
//            //记住用户名和密码
//            ShareUtils().putString(this,"name",et_name.text.toString().trim())
//            ShareUtils().putString(this,"password",et_password.text.toString().trim())
//
//        }else{
//            ShareUtils().deleShare(this,"name")
//            ShareUtils().deleShare(this,"password")
//        }
//    }

}



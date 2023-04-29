package com.example.fiveone

import TodoAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.fiveone.databinding.ActivityLoginBinding
import com.example.fiveone.databinding.ActivityMainBinding
import com.example.fiveone.databinding.DialogAddTodoBinding

class MainActivity : AppCompatActivity() {
    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var viewModel: TodoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        val adapter = TodoAdapter(this::onTodoItemClick)
        mBinding.todoList.adapter = adapter

        viewModel = ViewModelProvider(this).get(TodoListViewModel::class.java)
        viewModel.todoList.observe(this) { todoList ->
            adapter.submitList(todoList)
        }

        mBinding.btnAddTodo.setOnClickListener {
            showAddTodoDialog()
        }
    }

    private fun onTodoItemClick(todoItem: TodoItem) {
        viewModel.deleteTodoItem(todoItem)
    }

    private fun showAddTodoDialog() {
        val dialogBinding = DialogAddTodoBinding.inflate(layoutInflater)

        AlertDialog.Builder(this)
            .setTitle("Add Todo")
            .setView(dialogBinding.root)
            .setPositiveButton("Add") { _, _ ->
                viewModel.addTodoItem(
                    title = dialogBinding.etTitle.text.toString(),
                    description = dialogBinding.etDescription.text.toString()
                )
            }
            .setNegativeButton("Cancel", null)
            .show()
    }


}
